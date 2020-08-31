<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Timestamp"%>
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
		String idt = request.getParameter("idt");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String tel = request.getParameter("tel");
		Timestamp register = new Timestamp(System.currentTimeMillis());
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String str = "";
		
		try {
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbId = "jspid";
			String dbPass = "jsppass";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			
			String sql = "INSERT INTO member VALUES(?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, idt);
			pstmt.setString(2, passwd);
			pstmt.setString(3, name);
			pstmt.setTimestamp(4, register);
			pstmt.setString(5, addr);
			pstmt.setString(6, tel);
			
			pstmt.executeUpdate();
			
			out.println("member 테이블에 새로운 레코드를 추가했습니다.");
			
		} catch(Exception e) {
			e.printStackTrace();
			out.println("member 테이블에 새로운 레코드를 추가에 실패했습니다.");
		} finally {	// 리소스 해제
			if(pstmt != null)
				try { pstmt.close(); } catch(SQLException sqle) {}
			if(conn != null)
				try { conn.close(); } catch(SQLException sqle) {}
		}
	%>
</body>
</html>