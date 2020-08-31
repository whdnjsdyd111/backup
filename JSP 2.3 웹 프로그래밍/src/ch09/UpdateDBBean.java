package ch09;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UpdateDBBean {
	private static UpdateDBBean instance = new UpdateDBBean();

	public static UpdateDBBean getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jsptest");
		return ds.getConnection();
	}

	public List<UpdateDataBean> getMembers() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<UpdateDataBean> memberList = null;
		int x = 0;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("SELECT COUNT(*) FROM member");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
			pstmt.close();
			rs.close();

			pstmt = conn.prepareStatement("SELECT id, passwd FROM member");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				memberList = new ArrayList<UpdateDataBean>(x);
				do {
					UpdateDataBean member = new UpdateDataBean();
					member.setId(rs.getString("id"));
					member.setPasswd(rs.getString("passwd"));
					memberList.add(member);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException3) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException localSQLException4) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException localSQLException5) {
				}

		}
		return memberList;
	}

	public void updateMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		SHA256 sha = SHA256.getInstance();
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("SELECT id, passwd FROM member");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String orgPass = rs.getString("passwd");

				String shaPass = sha.getSha256(orgPass);

				String bcPass = BCrypt.hashpw(shaPass, BCrypt.gensalt());

				pstmt = conn.prepareStatement("UPDATE member SET passwd = ? WHERE id = ?");

				pstmt.setString(1, bcPass);
				pstmt.setString(2, id);
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException localSQLException3) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException localSQLException4) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException localSQLException5) {
				}
		}
	}
}