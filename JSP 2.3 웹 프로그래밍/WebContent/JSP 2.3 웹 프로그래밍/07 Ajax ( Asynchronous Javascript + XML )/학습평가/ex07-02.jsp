<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#btn').click(function() {
			$('#div').load('ex07-01.jsp');
		});
	});
</script>
</head>
<body>
	<button type="button" id="btn">로드</button>
	<div id="div"></div>
</body>
</html>