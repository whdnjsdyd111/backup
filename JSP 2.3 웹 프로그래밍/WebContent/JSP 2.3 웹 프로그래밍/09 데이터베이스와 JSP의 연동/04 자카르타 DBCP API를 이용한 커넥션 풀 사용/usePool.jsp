<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*, javax.naming.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr class="label" align="center">
			<td>아이디
			<td>비밀번호
			<td>이름
			<td>가입일자
			<td>주소
			<td>전화번호 <%
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					Context context = new InitialContext();
					DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jsptest");
					conn = ds.getConnection();
					
					String sql = "SELECT * FROM member";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						String id = rs.getString("id");
						String passwd = rs.getString("passwd");
						String name = rs.getString("name");
						Timestamp register = rs.getTimestamp("reg_date");
						String address = rs.getString("address");
						String tel = rs.getString("tel");
			%>
		<tr align="center">
			<td><%= id %>
			<td><%= passwd %>
			<td><%= name %>
			<td><%= register.toString() %>
			<td><%= address %>
			<td><%= tel %> <% 
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
			%>
	</table>
</body>
</html>