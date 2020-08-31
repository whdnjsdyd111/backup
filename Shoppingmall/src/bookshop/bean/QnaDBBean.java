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

public class QnaDBBean {
	private static QnaDBBean instance = new QnaDBBean();
	
	// .jsp ���������� DB �������� BoardDBBean Ŭ������ �޼ҵ忡 ���� �� �ʿ�
	public static QnaDBBean getInstance() {
		return instance;
	}
	
	private QnaDBBean() {}
	
	// Ŀ�ؼ� Ǯ�κ��� Connection ��ü�� ��
	private Connection getConnection() throws Exception {
		Context context = new InitialContext();
	    DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/jsptest1");
	    return ds.getConnection();
	}
	
	// qna ���̺� ���� �߰� - ����ڰ� �ۼ��ϴ� ��
	@SuppressWarnings("resource")
	public int insertArticle(QnaDataBean article) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		String sql = "";
		int group_id = 1;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("SELECT MAX(qna_id) FROM qna");
			rs = pstmt.executeQuery();
			
			if(rs.next())
				x = rs.getInt(1);
			else
				x = 1;
			
			if(x > 0)
				group_id = rs.getInt(1) + 1;
			
			pstmt.close();
			
			// ������ �ۼ� : board ���̺� ���ο� ���ڵ� �߰�
			sql = "INSERT INTO qna VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, x);
			pstmt.setInt(2, article.getBook_id());
			pstmt.setString(3, article.getBook_title());
			pstmt.setString(4, article.getQna_writer());
			pstmt.setString(5, article.getQna_content());
			pstmt.setInt(6, group_id);
			pstmt.setInt(7, article.getQora());
			pstmt.setInt(8, article.getReply());
			pstmt.setTimestamp(9, article.getReg_date());
			pstmt.executeUpdate();
			
			x = 1;	// ���ڵ� �߰� ����
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
	
	// qna ���̺� ���� �߰� - �����ڰ� �ۼ��� �亯
	@SuppressWarnings("resource")
	public int insertArticle(QnaDataBean article, int qna_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		String sql = "";
		
		try {
			conn = getConnection();
			
			// ������ �ۼ� : board ���̺� ���ο� ���ڵ� �߰�
			sql = "INSERT INTO qna VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, qna_id);
			pstmt.setInt(2, article.getBook_id());
			pstmt.setString(3, article.getBook_title());
			pstmt.setString(4, article.getQna_writer());
			pstmt.setString(5, article.getQna_content());
			pstmt.setInt(6, article.getGroup_id());
			pstmt.setInt(7, article.getQora());
			pstmt.setInt(8, article.getReply());
			pstmt.setTimestamp(9, article.getReg_date());
			pstmt.executeUpdate();
			
			pstmt.close();
			
			sql = "UPDATE qna SET reply = ? WHERE qna_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, 1);
			pstmt.setInt(2, qna_id);
			pstmt.executeUpdate();
			
			x = 1;	// ���ڵ� �߰� ����
			
		} catch (Exception e) {
			// TODO: handle exception
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
	
	// qna ���̺� ����� ��ü ���� ���� ��
	public int getArticleCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("SELECT count(*) FROM qna");
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
	
	// Ư�� å�� ���� �ۼ��� qna ���� ���� ��
	public int getArticleCount(int book_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("SELECT count(*) FROM qna WHERE book_id = " + book_id);
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
	
	// ������ ���� �ش��ϴ� qna ���� ���� ��
	public List<QnaDataBean> getArticles(int count){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QnaDataBean> articleList = null;	// �۸���� �����ϴ� ��ü
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("SELECT * FROM qna ORDER BY group_id DESC, qora ASC");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {	// rs�� ���ڵ带 ����
				articleList = new ArrayList<>(count);
				
				do {
					QnaDataBean article = new QnaDataBean();
					
					article.setQna_id(rs.getInt("qna_id"));
					article.setBook_id(rs.getInt("book_id"));
					article.setBook_title(rs.getString("book_title"));
					article.setQna_writer(rs.getString("qna_writer"));
					article.setQna_content(rs.getString("qna_content"));
					article.setGroup_id(rs.getInt("group_id"));
					article.setQora(rs.getByte("qora"));
					article.setReply(rs.getByte("reply"));
					article.setReg_date(rs.getTimestamp("reg_date"));
					
					// List ��ü�� ������ ������� BoardDataBean ��ü�� ����
					articleList.add(article);
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
		
		return articleList;	// List ��ü�� ���۷����� ����
	}
	
	// Ư�� å�� ���� �ۼ��� qna ���� ������ ����ŭ ��
	public List<QnaDataBean> getArticles(int count, int book_id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QnaDataBean> articleList = null;	// �۸���� �����ϴ� ��ü
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("SELECT * FROM qna WHERE book_id =  " + book_id +  " ORDER BY group_id DESC, qora ASC");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {	// rs�� ���ڵ带 ����
				articleList = new ArrayList<>(count);
				
				do {
					QnaDataBean article = new QnaDataBean();
					
					article.setQna_id(rs.getInt("qna_id"));
					article.setBook_id(rs.getInt("book_id"));
					article.setBook_title(rs.getString("book_title"));
					article.setQna_writer(rs.getString("qna_writer"));
					article.setQna_content(rs.getString("qna_content"));
					article.setGroup_id(rs.getInt("group_id"));
					article.setQora(rs.getByte("qora"));
					article.setReply(rs.getByte("reply"));
					article.setReg_date(rs.getTimestamp("reg_date"));
					
					// List ��ü�� ������ ������� BoardDataBean ��ü�� ����
					articleList.add(article);
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
		
		return articleList;	// List ��ü�� ���۷����� ����
	}
	
	// QnA �ۼ��� ������ ����� ���� ����
	public QnaDataBean updateGetArticle(int qna_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QnaDataBean article = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("SELECT * FROM qna WHERE qna_id =  ?");
			pstmt.setInt(1, qna_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {	// rs�� ���ڵ带 ����
				article = new QnaDataBean();
			
				article.setQna_id(rs.getInt("qna_id"));
				article.setBook_id(rs.getInt("book_id"));
				article.setBook_title(rs.getString("book_title"));
				article.setQna_writer(rs.getString("qna_writer"));
				article.setQna_content(rs.getString("qna_content"));
				article.setGroup_id(rs.getInt("group_id"));
				article.setQora(rs.getByte("qora"));
				article.setReply(rs.getByte("reply"));
				article.setReg_date(rs.getTimestamp("reg_date"));
				
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
		
		return article;
	}
	
	// QnA �ۼ��� ó������ ���
	public int updateArticle(QnaDataBean article) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			
			String sql = "UPDATE qna SET qna_content = ? WHERE qna_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getQna_content());
			pstmt.setInt(2, article.getQna_id());
			pstmt.executeUpdate();
			x = 1;
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
	
	// QnA �ۼ��� ���� ó�� �� ���
	public int deleteArticle(int qna_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("DELETE FROM qna WHERE qna_id = ?");
			pstmt.setInt(1, qna_id);
			pstmt.executeQuery();
			
			x = 1;	// �� ���� ����
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
}
