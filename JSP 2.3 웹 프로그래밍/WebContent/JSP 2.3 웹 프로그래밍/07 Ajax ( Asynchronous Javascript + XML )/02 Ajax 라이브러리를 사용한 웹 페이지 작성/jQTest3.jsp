<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	$(function() {
		$('p').mouseenter(function() {
			$(this).text('환영합니다');
		});
		
		$('p').mouseleave(function() {
			$(this).text("돌아와~!");
		});
		
		$('button').dblclick(function() {
			$(this).css('background-color', '#cccccc');
		});
	});
</script>
</head>
<body>
	<p>마우스 포인터</p>
	<button>더블 클릭 해보십시오.</button>
</body>
</html>