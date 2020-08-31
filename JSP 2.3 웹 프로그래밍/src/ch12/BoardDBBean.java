package ch12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDBBean {
	private static BoardDBBean instance = new BoardDBBean();
	
	// .jsp ���������� DB �������� BoardDBBean Ŭ������ �޼ҵ忡 ���� �� �ʿ�
	public static BoardDBBean getInstance() {
		return instance;
	}
	
	private BoardDBBean() {}
	
	// Ŀ�ؼ� Ǯ�κ��� Connection ��ü�� �� : DB �������� �������� �����ϴ� �޼ҵ忡�� ���
	private Connection getConnection() throws Exception {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jsptest");
		return ds.getConnection();
	}
	
	// board ���̺� ���� �߰�(insert ��) <--- writePro.jsp ���� ���
	public int insertArticle(BoardDataBean article) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		int number = 0;	// board ���̺� �� �� ��ȣ
		String sql = "";
		
		// ���� ������ ����� ���� ����
		int num = article.getNum();	// ������� �۹�ȣ
		int ref = article.getRef();	// ������� �׷�ȭ ���̵�
		int re_step = article.getRe_step();	// �׷� ���� ���� ����
		int re_level = article.getRe_level();	// �������� �鿩����
		
		try {
			conn = getConnection();
			
			// ���� ������ ���� board ���̺� ���ڵ��� ���� �Ǵܰ� �۹�ȣ ����
			pstmt = conn.prepareStatement("SELECT MAX(num) FROM board");
			rs = pstmt.executeQuery();
			
			if(rs.next())
				number = rs.getInt(1) + 1;	// ���� �� ��ȣ�� ���� ū �۹�ȣ + 1
			else
				number = 1;
			
			pstmt.close();
			
			// ���� ������ ����۰� ��� ���� ������ ����
			if(num != 0) {	// ��� - ������� �� ��ȣ�� ����
				sql = "UPDATE board SET re_step = re_step + 1 WHERE ref = ? AND re_step = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();
				re_step += 1;
				re_level += 1;
			} else {	// ����� - �۹�ȣ ����
				ref = number;
				re_step = 0;
				re_level = 0;
			}
			
			// ������ �ۼ� : board ���̺� ���ο� ���ڵ� �߰�
			sql = "INSERT INTO board(writer, subject, content, passwd, reg_date, ";
			sql += "ip, ref, re_step, re_level) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getWriter());
			pstmt.setString(2, article.getSubject());
			pstmt.setString(3, article.getContent());
			pstmt.setString(4, article.getPasswd());
			pstmt.setTimestamp(5, article.getReg_date());
			pstmt.setString(6, article.getIp());
			pstmt.setInt(7, ref);
			pstmt.setInt(8, re_step);
			pstmt.setInt(9, re_level);
			pstmt.executeUpdate();
			x = 1;	// ���ڵ� �߰� ����
		} catch(Exception e) {
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
	
	// board ���̺� ����� ��ü���� ���� �� <--- list.jsp���� ���
	public int getArticleCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("SELECT COUNT(*) FROM board");
			rs = pstmt.executeQuery();
			
			if(rs.next())
				x = rs.getInt(1);
		} catch(Exception e) {
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
	
	// ���� ����� ������ <--- list.jsp
	public List<BoardDataBean> getArticles(int start, int end){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardDataBean> articleList = null;	// �۸���� �����ϴ� ��ü
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("SELECT * FROM board WHERE ROWNUM >= ? AND ROWNUM <= ? ORDER BY ref DESC, re_step ASC");
			pstmt.setInt(1, start - 1);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {	// ResultSet�� ���ڵ带 ����
				articleList = new ArrayList<BoardDataBean>(end);
				
				do {
					BoardDataBean article = new BoardDataBean();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setSubject(rs.getString("subject"));
					article.setContent(rs.getString("content"));
					article.setPasswd(rs.getString("passwd"));
					article.setReg_date(rs.getTimestamp("reg_date"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setRe_step(rs.getInt("re_step"));
					article.setRe_level(rs.getInt("re_level"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
					
					// List ��ü�� ������ ������� BoardDataBean ��ü�� ����
					articleList.add(article);
				} while(rs.next());
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null)
				try { rs.close(); } catch(SQLException sqle) {}
			if(pstmt != null)
				try { pstmt.close(); } catch(SQLException sqle) {}
			if(conn != null)
				try { conn.close(); } catch(SQLException sqle) {}
		}
		
		return articleList;
	}
	
	// �ۼ��� ������ ����� ���� ����(1���� ��) <--- updateForm.jsp ���� ���
	public BoardDataBean updateGetArticle(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDataBean article = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("SELECT * FROM board WHERE num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				article = new BoardDataBean();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setSubject(rs.getString("subject"));
				article.setPasswd(rs.getString("passwd"));
				article.setReg_date(rs.getTimestamp("reg_date"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setRe_step(rs.getInt("re_step"));
				article.setRe_level(rs.getInt("re_level"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
			}
		} catch(Exception e) {
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
	
	// �ۼ��� ó�� �� ��� <--- updatePro.jsp���� ���
	public int updateArticle(BoardDataBean article) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("SELECT passwd FROM board WHERE num = ?");
			pstmt.setInt(1, article.getNum());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpasswd = rs.getString("passwd");
				
				if(dbpasswd.equals(article.getPasswd())) {
					pstmt.close();
					
					String sql = "UPDATE board SET subject = ?, content = ? WHERE num = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, article.getSubject());
					pstmt.setString(2, article.getContent());
					pstmt.setInt(3, article.getNum());
					pstmt.executeUpdate();
					x = 1;
				} else
					x = 0;
			} 
		} catch(Exception e) {
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
	
	// �ۻ��� ó�� �� ���(delete��) <--- deletePro.jsp
	public int deleteArticle(int num, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("SELECT passwd FROM board WHERE num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpasswd = rs.getString("passwd");
				
				if(dbpasswd.equals(passwd)) {
					pstmt.close();
					
					pstmt = conn.prepareStatement("DELETE FROM board WHERE num = ?");
					pstmt.setInt(1, num);
					pstmt.executeUpdate();
					x = 1;	// �ۻ��� ����
				} else
					x = 0;	// ��й�ȣ Ʋ��
			}
		} catch(Exception e) {
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
