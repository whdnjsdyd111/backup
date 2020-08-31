package bookshop.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CartDBBean {
	private static CartDBBean instance = new CartDBBean();
	
	public static CartDBBean getInstance() {
		return instance;
	}
	
	private CartDBBean() {}
	
	private Connection getConnection() throws Exception {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jsptest1");
		return ds.getConnection();
	}
	
	// [��ٱ��Ͽ� ���]�� Ŭ������ ����Ǵ� ������ cart ���̺� ���ο� ���ڵ带 �߰�
	public void insertCart(CartDataBean cart) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cart_id = 1;
		String sql = "";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("SELECT MAX(cart_id) FROM cart");
			rs = pstmt.executeQuery();
			
			if(rs.next())
				cart_id = rs.getInt(1) + 1;
			else
				cart_id = 1;
			
			pstmt.close();
			
			sql = "INSERT INTO cart VALUES(?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cart_id);
			pstmt.setString(2, cart.getBuyer());
			pstmt.setInt(3, cart.getBook_id());
			pstmt.setInt(4, cart.getBuy_price());
			pstmt.setByte(5, cart.getBuy_count());
			pstmt.setString(6, cart.getBook_image());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try { rs.close(); } catch (SQLException sqle) {}
			if (pstmt != null)
				try { pstmt.close(); } catch (SQLException sqle) {}
			if (conn != null)
				try { conn.close(); } catch (SQLException sqle) {}
		}
	}
	
	// id�� �ش��ϴ� ���ڵ��� ���� ���� �޼ҵ�
	public int getListCount(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("SELECT COUNT(*) FROM cart WHERE buyer = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				x = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try { rs.close(); } catch (SQLException sqle) {}
			if (pstmt != null)
				try { pstmt.close(); } catch (SQLException sqle) {}
			if (conn != null)
				try { conn.close(); } catch (SQLException sqle) {}
		}	
		return x;
	}
	
	// id�� �ش��ϴ� ���ڵ��� ����� ���� �޼ҵ�
	public List<CartDataBean> getCart(String id, int count) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CartDataBean cart = null;
		String sql = "";
		List<CartDataBean> lists = null;
		
		try {
			conn = getConnection();
			
			sql = "SELECT * FROM cart WHERE buyer = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			lists = new ArrayList<>(count);
			
			while(rs.next()) {
				cart = new CartDataBean();
				
				cart.setCart_id(rs.getInt("cart_id"));
				cart.setBook_id(rs.getInt("book_id"));
				cart.setBook_title(rs.getString("book_title"));
				cart.setBuy_price(rs.getInt("buy_price"));
				cart.setBuy_count(rs.getByte("buy_count"));
				cart.setBook_image(rs.getString("book_image"));
				
				lists.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try { rs.close(); } catch (SQLException sqle) {}
			if (pstmt != null)
				try { pstmt.close(); } catch (SQLException sqle) {}
			if (conn != null)
				try { conn.close(); } catch (SQLException sqle) {}
		}
		return lists;
	}
	
	// ��ٱ��Ͽ��� ���� ���� �� ����Ǵ� �޼ҵ�
	public void updateCount(int cart_id, byte count) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("UPDATE cart SET buy_count = ? WHERE cart_id = ?");
			pstmt.setByte(1, count);
			pstmt.setInt(2, cart_id);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try { pstmt.close(); } catch (SQLException sqle) {}
			if (conn != null)
				try { conn.close(); } catch (SQLException sqle) {}
		}
	}
	
	// ��ٱ��Ͽ��� cart_id�� ���� ���ڵ带 �����ϴ� �޼ҵ�
	public void deleteList(int cart_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("DELETE FROM cart WHERE cart_id = ?");
			pstmt.setInt(1, cart_id);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try { pstmt.close(); } catch (SQLException sqle) {}
			if (conn != null)
				try { conn.close(); } catch (SQLException sqle) {}
		}
	}
	
	// id�� �ش��ϴ� ��� ���ڵ带 �����ϴ� �޼ҵ�� [��ٱ��� ����] ��ư�� Ŭ�� �� ����ȴ�.
	public void deleteAll(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("DELETE FROM cart WHERE buyer = ?");
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try { pstmt.close(); } catch (SQLException sqle) {}
			if (conn != null)
				try { conn.close(); } catch (SQLException sqle) {}
		}
	}
}
