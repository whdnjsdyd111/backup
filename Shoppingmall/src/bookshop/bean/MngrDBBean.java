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

public class MngrDBBean {
	// MngrDBBean ���� ��ü ���� <- �Ѱ��� ��ü�� �����ؼ� ����
	private static MngrDBBean instance = new MngrDBBean();
	
	// MngrDBBean ��ü�� �����ϴ� �޼ҵ�
	public static MngrDBBean getInstance() {
		return instance;
	}
	
	private MngrDBBean() {}
	
	// Ŀ�ؼ� Ǯ���� Ŀ�ؼ� ��ü�� ���� �޼ҵ�
	private Connection getConnection() throws Exception {
		Context context = new InitialContext();
	    DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/jsptest1");
	    return ds.getConnection();
	}
	
	// ������ ���� �޼ҵ�
	public int userCheck(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		SHA256 sha = SHA256.getInstance();
		
		try {
			conn = getConnection();
			
			String orgPass = passwd;
			String shaPass = sha.getSha256(orgPass);
			
			pstmt = conn.prepareStatement("SELECT managerPasswd FROM manager WHERE managerId = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {	// �ش� ���̵� ������ ����
				String dbpasswd = rs.getString("managerPasswd");
				
				if(BCrypt.checkpw(shaPass, dbpasswd))
					x = 1;	// ���� ����
				else
					x = 0;	// ��й�ȣ Ʋ��
			} else	// �ش� ���̵� ������ ����
				x = -1;	// ���̵� ����
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
	
	// å ��� �޼ҵ�
	public void insertBook(MngrDataBean book) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int maxId = 1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("SELECT MAX(book_id) FROM book");
			rs = pstmt.executeQuery();
			
			if(rs.next())
				maxId = rs.getInt(1) + 1;
			else
				maxId = 1;
			
			pstmt.close();
			
			String sql = "INSERT INTO book VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, maxId);
			pstmt.setString(2, book.getBook_kind());
			pstmt.setString(3, book.getBook_title());
			pstmt.setInt(4, book.getBook_price());
			pstmt.setShort(5, book.getBook_count());
			pstmt.setString(6, book.getAuthor());
			pstmt.setString(7, book.getPublishing_com());
			pstmt.setString(8, book.getPublishing_date());
			pstmt.setString(9, book.getBook_image());
			pstmt.setString(10, book.getBook_content());
			pstmt.setByte(11, book.getDiscount_rate());
			pstmt.setTimestamp(12, book.getReg_date());
			
			pstmt.executeUpdate();
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
	
	// �̹� ��ϵ� å�� ����
	public int registedBookconfirm(String kind, String bookName, String author) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			
			String sql = "SELECT book_name FROM book ";
			sql += "WHERE book_kind = ? AND book_name = ? AND author = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind);
			pstmt.setString(2, bookName);
			pstmt.setString(3, author);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				x = 1;	// �ش� å�� �̹� ��ϵǾ� ����
			else
				x = -1;	// �ش� å�� �̹� ��ϵǾ� ���� ����
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
	
	// ��ü ��ϵ� å�� ���� ���� �޼ҵ�
	public int getBookCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("SELECT count(*) FROM book");
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
	
	// �ش� �з��� å�� ���� ���� �޼ҵ�
	public int getBookCount(String book_kind) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		int kind = Integer.parseInt(book_kind);
		
		try {
			conn = getConnection();
			
			String query = "SELECT count(*) FROM book WHERE book_kind = " + kind;
			pstmt = conn.prepareStatement(query);
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
	
	// å�� ������ ��
	public String getBookTitle(int book_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String x = "";
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("SELECT book_title FROM book WHERE book_id = " + book_id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				x = rs.getString(1);
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
	
	// �з��� �Ǵ� ��ü ��ϵ� å�� ������ ���� �޼ҵ�
	public List<MngrDataBean> getBooks(String book_kind) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MngrDataBean> bookList = null;
		
		try {
			conn = getConnection();
			
			String sql1 = "SELECT * FROM book";
			String sql2 = "SELECT * FROM book WHERE book_kind = ? ORDER BY reg_date DESC";
			
			if(book_kind.equals("all") || book_kind.equals(""))
				pstmt = conn.prepareStatement(sql1);
			else {
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, book_kind);
			}
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bookList = new ArrayList<>();
				
				do {
					MngrDataBean book = new MngrDataBean();
					
					book.setBook_id(rs.getInt("book_id"));
					book.setBook_kind(rs.getString("book_kind"));
					book.setBook_title(rs.getString("book_title"));
					book.setBook_price(rs.getInt("book_price"));
					book.setBook_count(rs.getShort("book_count"));
					book.setAuthor(rs.getString("author"));
					book.setPublishing_com(rs.getString("publishing_com"));
					book.setPublishing_date(rs.getString("publishing_date"));
					book.setBook_image(rs.getString("book_image"));
					book.setDiscount_rate(rs.getByte("discount_rate"));
					book.setReg_date(rs.getTimestamp("reg_date"));
					
					bookList.add(book);
				} while(rs.next());
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
		
		return bookList;
	}
	
	// ���θ� ���ο� ǥ���ϱ� ���ؼ� ����ϴ� �з��� �Ű�å ����� ���� �޼ҵ�
	public MngrDataBean[] getBooks(String book_kind, int count) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MngrDataBean bookList[] = null;
		int i = 0;
		
		try {
			conn = getConnection();
			
			String sql = "SELECT * FROM book WHERE book_kind = ? AND ROWNUM >= ? AND ROWNUM <= ? ";
			sql += "ORDER BY reg_date DESC ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book_kind);;
			pstmt.setInt(2, 0);
			pstmt.setInt(3, count);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bookList = new MngrDataBean[count];
				
				do {
					MngrDataBean book = new MngrDataBean();

					book.setBook_id(rs.getInt("book_id"));
					book.setBook_kind(rs.getString("book_kind"));
					book.setBook_title(rs.getString("book_title"));
					book.setBook_price(rs.getInt("book_price"));
					book.setBook_count(rs.getShort("book_count"));
					book.setAuthor(rs.getString("author"));
					book.setPublishing_com(rs.getString("publishing_com"));
					book.setPublishing_date(rs.getString("publishing_date"));
					book.setBook_image(rs.getString("book_image"));
					book.setDiscount_rate(rs.getByte("discount_rate"));
					book.setReg_date(rs.getTimestamp("reg_date"));
					
					bookList[i] = book;
					
					i++;
				} while(rs.next());
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
		
		return bookList;
	}
	
	// bookId�� �ش��ϴ� å�� ������ ���� �޼ҵ��
	// ��ϵ� å�� �����ϱ� ���� ���� ������ �о���̱� ���� �޼ҵ�
	public MngrDataBean getBook(int bookId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MngrDataBean book = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("SELECT * FROM book WHERE book_id = ?");
			pstmt.setInt(1, bookId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				book = new MngrDataBean();
				
				book.setBook_kind(rs.getString("book_kind"));
				book.setBook_title(rs.getString("book_title"));
				book.setBook_price(rs.getInt("book_price"));
				book.setBook_count(rs.getShort("book_count"));
				book.setAuthor(rs.getString("author"));
				book.setPublishing_com(rs.getString("publishing_com"));
				book.setPublishing_date(rs.getString("publishing_date"));
				book.setBook_image(rs.getString("book_image"));
				book.setBook_content(rs.getString("book_content"));
				book.setReg_date(rs.getTimestamp("reg_date"));
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
		
		return book;
	}
	
	// ��ϵ� å�� ������ ���� �� ����ϴ� �޼ҵ�
	public void updateBook(MngrDataBean book, int bookId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			conn = getConnection();
			
			sql = "UPDATE book SET book_kind = ?, book_title = ?, book_price = ?, ";
			sql += "book_count = ?, author = ?, publishing_com = ?, publishing_date = ?, ";
			sql += "book_image = ?, book_content = ?, discount_rate = ? ";
			sql += "WHERE book_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, book.getBook_kind());
			pstmt.setString(2, book.getBook_title());
			pstmt.setInt(3, book.getBook_price());
			pstmt.setShort(4, book.getBook_count());
			pstmt.setString(5, book.getAuthor());
			pstmt.setString(6, book.getPublishing_com());
			pstmt.setString(7, book.getPublishing_date());
			pstmt.setString(8, book.getBook_image());
			pstmt.setString(9, book.getBook_content());
			pstmt.setByte(10, book.getDiscount_rate());
			pstmt.setInt(11, bookId);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null)
				try { pstmt.close(); } catch(SQLException sqle) {}
			if(conn != null)
				try { conn.close(); } catch(SQLException sqle) {}
		}
	}
	
	// bookId�� �ش��ϴ� å�� ������ ���� �� ����ϴ� �޼ҵ�
	public void deleteBook(int bookId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("DELETE FROM book WHERE book_id = ?");
			pstmt.setInt(1, bookId);
			
			pstmt.executeUpdate();
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
}
