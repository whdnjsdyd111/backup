<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style type="text/css">
div#displayArea {
	width: 200px;
	height: 200px;
	border: 5px double #6699FF;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('button').click(function() {
			$('#displayArea').html("<p style='width: 100px; height: 100px; background-color: red;'></p>");
		});
	});
</script>
</head>
<body>
	<div id="displayArea">이곳의 내용이 변경</div>
	<button>표시</button>
</body>
</html>