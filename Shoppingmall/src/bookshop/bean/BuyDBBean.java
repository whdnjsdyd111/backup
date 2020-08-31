package bookshop.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BuyDBBean {
	private static BuyDBBean instance = new BuyDBBean();
	
	public static BuyDBBean getInstance() {
		return instance;
	}
	
	private BuyDBBean() {}
	
	private Connection getConnection() throws Exception {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jsptest");
		return ds.getConnection();
	}
	
	// bank ���̺� �ִ� ��ü ���ڵ带 ���� �޼ҵ�
	public List<String> getAccount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> accountList = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("SELECT * FROM bank");
			rs = pstmt.executeQuery();
			
			accountList = new ArrayList<>();
			
			while(rs.next()) {
				String account = new String(rs.getString("account") + "" + rs.getString("bank") + "" + rs.getString("name"));
				accountList.add(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null)
				try { rs.close(); } catch(SQLException sqle) {}
			if(pstmt != null)
				try { pstmt.close(); } catch(SQLException sqle) {}
			if(conn != null)
				try { conn.close(); } catch(SQLException sqle) {}
		}
		return accountList;
	}
	
	// ���� ���̺��� buy�� ���� ��� ���
	public void insertBuy(List<CartDataBean> lists, String id, String account, String deliveryName,
			String deliveryTel, String deliveryAddress) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Timestamp reg_date = null;
		String sql = "";
		String maxDate = "";
		String number = "";
		String todayDate = "";
		String compareDate = "";
		long buyId = 0;
		short nowCount;
		
		try {
			conn = getConnection();
			reg_date = new Timestamp(System.currentTimeMillis());
			todayDate = reg_date.toString();
			compareDate = todayDate.substring(0, 4) + todayDate.substring(5, 7) + todayDate.substring(8, 10);
			
			pstmt = conn.prepareStatement("SELECT MAX(buy_id) FROM buy");
			
			rs = pstmt.executeQuery();
			rs.next();
			if(rs.getLong(1) > 0) {
				Long val = new Long(rs.getLong(1));
				maxDate = val.toString().substring(0, 8);
				number = val.toString().substring(8);
				
				if(compareDate.equals(maxDate)) {
					if(Integer.parseInt(number) + 1 < 10000)
						buyId = Long.parseLong(maxDate + (Integer.parseInt(number) + 1 + 10000));
					else
						buyId = Long.parseLong(maxDate + (Integer.parseInt(number) + 1));
				} else {
					compareDate += "00001";
					buyId = Long.parseLong(compareDate);
				}
			} else {
				compareDate += "00001";
				buyId = Long.parseLong(compareDate);
			}
			
			// 105 ~ 154���α��� �ϳ��� Ʈ��������� ó��
			conn.setAutoCommit(false);
			
			for (int i = 0; i < lists.size(); i++) {
				// �ش� ���̵� ���� cart ���̺��� ���ڵ带 ������ �� buy ���̺� �߰�
				CartDataBean cart = lists.get(i);
				
				sql = "INSERT INTO buy VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setLong(1, buyId);
				pstmt.setString(2, id);
				pstmt.setInt(3, cart.getBook_id());
				pstmt.setString(4, cart.getBook_title());
				pstmt.setInt(5, cart.getBuy_price());
				pstmt.setByte(6, cart.getBuy_count());
				pstmt.setString(7, cart.getBook_title());
				pstmt.setTimestamp(8, reg_date);
				pstmt.setString(9, account);
				pstmt.setString(10, deliveryName);
				pstmt.setString(11, deliveryTel);
				pstmt.setString(12, deliveryAddress);
				pstmt.executeUpdate();
				
				// ��ǰ�� ���ŵǾ����Ƿ� book ���̺��� ��ǰ ������ ��������
				pstmt.close();
				
				pstmt = conn.prepareStatement("SELECT book_count FROM book WHERE book_id = ?");
				pstmt.setInt(1, cart.getBook_id());
				rs = pstmt.executeQuery();
				rs.next();
				
				nowCount = (short) (rs.getShort(1) - 1);	// �ǹ������� ���� ������ �� ��
				
				pstmt.close();
				
				sql = "UPDATE book SET book_count = ? WHERE book_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setShort(1, nowCount);
				pstmt.setInt(2, cart.getBook_id());
				
				pstmt.executeUpdate();
				pstmt.close();
			}
			
			pstmt = conn.prepareStatement("DELETE FROM cart WHERE buyer = ?");
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
			conn.commit();
			conn.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null)
				try { rs.close(); } catch(SQLException sqle) {}
			if(pstmt != null)
				try { pstmt.close(); } catch(SQLException sqle) {}
			if(conn != null)
				try { conn.close(); } catch(SQLException sqle) {}
		}
	}
	
	// id�� �ش��ϴ� buy ���̺��� ���ڵ� ���� ���� �޼ҵ�
	public int getListCount(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("SELECT COUNT(*) FROM buy WHERE buyer = ?");
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				x = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null)
				try { rs.close(); } catch(SQLException sqle) {}
			if(pstmt != null)
				try { pstmt.close(); } catch(SQLException sqle) {}
			if(conn != null)
				try { conn.close(); } catch(SQLException sqle) {}
		}
		return x;
	}
	
	// buy ���̺��� ��ü ���ڵ� ���� ���� �޼ҵ�
	public int getListCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("SELECT COUNT(*) FROM buy");
			rs = pstmt.executeQuery();
			
			if(rs.next())
				x = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null)
				try { rs.close(); } catch(SQLException sqle) {}
			if(pstmt != null)
				try { pstmt.close(); } catch(SQLException sqle) {}
			if(conn != null)
				try { conn.close(); } catch(SQLException sqle) {}
		}
		
		return x;
	}
	
	// id�� �ش��ϴ� buy ���̺��� ���� ����� ���� �޼ҵ�
	public List<BuyDataBean> getBuyList(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BuyDataBean buy = null;
		String sql = "";
		List<BuyDataBean> lists = null;
		
		try {
			conn = getConnection();
			
			sql = "SELECT * FROM buy WHERE buyer = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			lists = new ArrayList<>();
			
			while(rs.next()) {
				buy = new BuyDataBean();
				
				buy.setBuy_id(rs.getLong("buy_id"));
				buy.setBook_id(rs.getInt("book_id"));
				buy.setBook_title(rs.getString("book_title"));
				buy.setBuy_price(rs.getInt("buy_price"));
				buy.setBuy_count(rs.getByte("buy_count"));
				buy.setBook_image(rs.getString("book_image"));
				buy.setSanction(rs.getString("sanction"));
				
				lists.add(buy);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null)
				try { rs.close(); } catch(SQLException sqle) {}
			if(pstmt != null)
				try { pstmt.close(); } catch(SQLException sqle) {}
			if(conn != null)
				try { conn.close(); } catch(SQLException sqle) {}
		}
		
		return lists;
	}
	
	// buy ���̺��� ��ü ����� ���� �޼ҵ�
	public List<BuyDataBean> getBuyList() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BuyDataBean buy = null;
		String sql = "";
		List<BuyDataBean> lists = null;
		
		try {
			conn = getConnection();
			
			sql = "SELECT * FROM buy";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			lists = new ArrayList<>();
			
			while(rs.next()) {
				buy = new BuyDataBean();
				
				buy.setBuy_id(rs.getLong("buy_id"));
				buy.setBuyer(rs.getString("buyer"));
				buy.setBook_id(rs.getInt("book_id"));
				buy.setBook_title(rs.getString("book_title"));
				buy.setBuy_price(rs.getInt("buy_price"));
				buy.setBuy_count(rs.getByte("buy_count"));
				buy.setBook_image(rs.getString("book_image"));
				buy.setBuy_date(rs.getTimestamp("buy_date"));
				buy.setAccount(rs.getString("account"));
				buy.setDeliveryName(rs.getString("deliveryName"));
				buy.setDeliveryTel(rs.getString("deliveryTel"));
				buy.setDeliveryAddress(rs.getString("deliveryAddress"));
				buy.setSanction(rs.getString("sanction"));
				
				lists.add(buy);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null)
				try { rs.close(); } catch(SQLException sqle) {}
			if(pstmt != null)
				try { pstmt.close(); } catch(SQLException sqle) {}
			if(conn != null)
				try { conn.close(); } catch(SQLException sqle) {}
		}
		
		return lists;
	}
}
