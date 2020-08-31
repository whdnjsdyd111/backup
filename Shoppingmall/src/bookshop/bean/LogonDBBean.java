package bookshop.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LogonDBBean {
	
	// LogonDBBean 전역 객체 생성 <- 한개의 객체만 생성해서 공유
	private static LogonDBBean instance = new LogonDBBean();

	// LogonDBBean 객체를 리턴하는 메소드
	public static LogonDBBean getInstance() {
		return instance;
	}

	private LogonDBBean() {}
	
	// 커넥션 풀에서 커넥션 객체를 얻어내는 메소드
	private Connection getConnection() throws Exception {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jsptest1");
		return ds.getConnection();
	}
	
	// 회원 가입 처리에서 사용하는 메소드
	public void insertMember(LogonDataBean member) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		SHA256 sha = SHA256.getInstance();
		try {
			conn = getConnection();

			String orgPass = member.getPasswd();
			String shaPass = sha.getSha256(orgPass);
			String bcPass = BCrypt.hashpw(shaPass, BCrypt.gensalt());

			pstmt = conn.prepareStatement("INSERT INTO member VALUES(?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, bcPass);
			pstmt.setString(3, member.getName());
			pstmt.setTimestamp(4, member.getReg_date());
			pstmt.setString(5, member.getAddress());
			pstmt.setString(6, member.getTel());
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

	// 로그인 폼 처리의 사용자 인증 처리에서 사용하는 메소드
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

			pstmt = conn.prepareStatement("SELECT passwd FROM member WHERE id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {	// 해당 아이디가 있으면 수행
				String dbpasswd = rs.getString("passwd");

				if (BCrypt.checkpw(shaPass, dbpasswd))
					x = 1;	// 인증 성공
				else
					x = 0;	// 비밀번호 틀림
			} else {	// 해당 아이디가 없으면 수행
				x = -1;
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
		return x;
	}

	// 아이디 중복 확인에서 아이디의 중복 여부를 확인하는 메소드
	public int confirmId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = -1;
		
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("SELECT id FROM member WHERE id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next())
				x = 1;	// 같은 아이디 있음
			else
				x = -1;		// 같은 아이디 없음
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try { rs.close(); } catch (SQLException sqle) {}
			if (pstmt != null)
				try { pstmt.close(); } catch (SQLException sqle) {}
			if (conn != null)
				try { conn.close();	} catch (SQLException sqle) {}
		}
		return x;
	}

	// 주어진 id에 해당하는 회원 정보를 얻어내는 메소드
	public LogonDataBean getMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LogonDataBean member = null;

		SHA256 sha = SHA256.getInstance();
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("SELECT * FROM member WHERE id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {	// 해당 아이디에 대하 레코드가 존재
				member = new LogonDataBean();	// 데이터 저장빈 객체 생성
				
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setReg_date(rs.getTimestamp("reg_date"));
				member.setAddress(rs.getString("address"));
				member.setTel(rs.getString("tel"));
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
		return member;	// 데이터 저장빈 객체 member 리턴
	}

	// 주어진 id, passwd 에 해당하는 회원 정보를 얻어내는 메소드
	public LogonDataBean getMember(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LogonDataBean member = null;

		SHA256 sha = SHA256.getInstance();
		try {
			conn = getConnection();

			String orgPass = passwd;
			String shaPAss = sha.getSha256(orgPass);
			
			pstmt = conn.prepareStatement("SELECT * FROM member WHERE id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {	// 해당 아이디에 대하 레코드가 존재
				String dbpasswd = rs.getString("passwd");
				
				// 사용자가 입력한 비밀번호와 테이블의 비밀번호가 같으면 수행
				if(BCrypt.checkpw(shaPAss, dbpasswd)) {
				
					member = new LogonDataBean();	// 데이터 저장빈 객체 생성
				
					member.setId(rs.getString("id"));
					member.setName(rs.getString("name"));
					member.setReg_date(rs.getTimestamp("reg_date"));
					member.setAddress(rs.getString("address"));
					member.setTel(rs.getString("tel"));
				}
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
		return member;	// 데이터 저장빈 객체 member 리턴
	}
	
	// 회원 정보 수정을 처리하는 메소드
	public int updateMember(LogonDataBean member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;

		SHA256 sha = SHA256.getInstance();
		try {
			conn = getConnection();

			String orgPass = member.getPasswd();
			String shaPass = sha.getSha256(orgPass);

			pstmt = conn.prepareStatement("SELECT * FROM member WHERE id = ?");
			pstmt.setString(1, member.getId());
			rs = pstmt.executeQuery();

			if (rs.next()) {	// 해당 아이디가 있으면 수행
				String dbpasswd = rs.getString("passwd");

				pstmt.close();

				if (BCrypt.checkpw(shaPass, dbpasswd)) {
					pstmt = conn.prepareStatement("UPDATE member SET name = ?, address = ?, tel = ? WHERE id = ?");
					pstmt.setString(1, member.getName());
					pstmt.setString(2, member.getAddress());
					pstmt.setString(3, member.getTel());
					pstmt.setString(4, member.getId());
					pstmt.executeUpdate();

					x = 1;	// 회원 정보 수정 처리 성공
				} else {
					x = 0;	// 회원 정보 수정 처리 실패
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try { rs.close(); } catch (SQLException sqle) {}
			if (pstmt != null)
				try { pstmt.close(); } catch (SQLException sqle) {}
			if (conn != null)
				try { conn.close(); } catch (SQLException sqle) { }
		}
		return x;
	}

	// 회원 정보를 삭제하는 메소드
	public int deleteMember(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;

		SHA256 sha = SHA256.getInstance();
		try {
			conn = getConnection();

			String orgPass = passwd;
			String shaPass = sha.getSha256(orgPass);

			pstmt = conn.prepareStatement("SELECT passwd FROM member WHERE id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String dbpasswd = rs.getString("passwd");

				pstmt.close();

				if (BCrypt.checkpw(shaPass, dbpasswd)) {
					pstmt = conn.prepareStatement("DELETE FROM member WHERE id = ?");
					pstmt.setString(1, id);
					pstmt.executeUpdate();

					x = 1;	// 회원 탈퇴 처리 성공
				} else {
					x = 0;	// 회원 탈퇴 처리 실패
				}
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
		return x;
	}
}