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
	// MngrDBBean 전역 객체 생성 <- 한개의 객체만 생성해서 공유
	private static MngrDBBean instance = new MngrDBBean();
	
	// MngrDBBean 객체를 리턴하는 메소드
	public static MngrDBBean getInstance() {
		return instance;
	}
	
	private MngrDBBean() {}
	
	// 커넥션 풀에서 커넥션 객체를 얻어내는 메소드
	private Connection getConnection() throws Exception {
		Context context = new InitialContext();
	    DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/jsptest1");
	    return ds.getConnection();
	}
	
	// 관리자 인증 메소드
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
			
			if(rs.next()) {	// 해당 아이디가 있으면 수행
				String dbpasswd = rs.getString("managerPasswd");
				
				if(BCrypt.checkpw(shaPass, dbpasswd))
					x = 1;	// 인증 성공
				else
					x = 0;	// 비밀번호 틀림
			} else	// 해당 아이디 없으면 수행
				x = -1;	// 아이디 없음
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
	
	// 책 등록 메소드
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
	
	// 이미 등록된 책을 검증
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
				x = 1;	// 해당 책이 이미 등록되어 있음
			else
				x = -1;	// 해당 책이 이미 등록되어 있지 않음
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
	
	// 전체 등록된 책의 수를 얻어내는 메소드
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
	
	// 해당 분류의 책의 수를 얻어내는 메소드
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
	
	// 책의 제목을 얻어냄
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
	
	// 분류별 또는 전체 등록된 책의 정보를 얻어내는 메소드
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
	
	// 쇼핑몰 메인에 표시하기 위해서 사용하는 분류별 신간책 목록을 얻어내는 메소드
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
	
	// bookId에 해당하는 책의 정보를 얻어내는 메소드로
	// 등록된 책을 수정하기 위해 수정 폼으로 읽어들이기 위한 메소드
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
	
	// 등록된 책의 정보를 수정 시 사용하는 메소드
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
	
	// bookId에 해당하는 책의 정보를 삭제 시 사용하는 메소드
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
