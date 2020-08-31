<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>

	<%
		String id = request.getParameter("idt");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String tel = request.getParameter("tel");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbId = "jspid";
			String dbPass = "jsppass";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		
			String sql = "SELECT id, passwd FROM member WHERE id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String rId = rs.getString("id");
				String rPasswd = rs.getString("passwd");
				
				pstmt.close();
				
				if(id.equals(rId) && passwd.equals(rPasswd)) {
					
					sql = "UPDATE member SET name = ?, address = ?, tel = ? WHERE id = ?";
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, name);
					pstmt.setString(2, addr);
					pstmt.setString(3, tel);
					pstmt.setString(4, id);
					
					pstmt.executeUpdate();
					
					out.println("member 테이블의 레코드를 수정했습니다.");
				} else
					out.println("패스워드가 틀렸습니다.");
			} else
				out.println("아이디가 틀렸습니다.");
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			if(rs != null)
				try { rs.close(); } catch(SQLException sqle) {}
			if(pstmt != null)
				try { pstmt.close(); } catch(SQLException sqle) {}
			if(conn != null)
				try { conn.close(); } catch(SQLException sqle) {}
		}
	%>
</body>
</html>