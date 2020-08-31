<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSTL sql 태그 예제 - query</h3>
	
	<sql:query var="rs" dataSource="jdbc/jsptest">
		SELECT * FROM member
	</sql:query>
	
	<table>
		<tr class="label2"><%-- 필드명 출력 --%>
			<c:forEach var="columnName" items="${ rs.columnNames }">
				<th><c:out value="${ columnName }" /></th>
			</c:forEach>
		</tr>
		<c:forEach var="row" items="${ rs.rowsByIndex }"> <%-- 레코드의 수만큼 반복한다. --%>
			<tr>
				<c:forEach var="column" items="${ row }" varStatus="i">
					<td>
						<c:if test="${ column != null }">
							<c:out value="${ column }" />
						</c:if>	<%-- 해당 필드값이 null이면 --%>
						<c:if test="${ column == null }">
							&nbsp;
						</c:if>
					</td>	
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>