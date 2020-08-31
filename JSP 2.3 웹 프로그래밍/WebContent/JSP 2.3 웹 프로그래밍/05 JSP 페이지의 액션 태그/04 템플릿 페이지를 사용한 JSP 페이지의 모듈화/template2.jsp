<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<link rel="stylesheet" href="template.css" />
</head>
<body>
	<% String contentPage = request.getParameter("CONTENTPAGE"); %>

	<header>
		<jsp:include page="top.jsp" flush="false" />
	</header>
	<div id="content">
		<section id="areaSub">
			<jsp:include page="left.jsp" flush="false"></jsp:include>
		</section>
		<section id="areaMain">
			<jsp:include page="<%= contentPage %>" flush="false"></jsp:include>
		</section>
	</div>
	<footer>
		<jsp:include page="bottom.jsp" flush="false"></jsp:include>
	</footer>
</body>
</html>