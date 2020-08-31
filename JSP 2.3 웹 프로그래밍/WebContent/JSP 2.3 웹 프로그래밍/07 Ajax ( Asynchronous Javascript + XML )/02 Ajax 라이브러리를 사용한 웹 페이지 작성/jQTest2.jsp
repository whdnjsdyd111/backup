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
		$('#b1').click(function() {		// <button id="b1"> 엘리먼트를 클릭하면 자동 실행
			$('#b2').text($('p').text());	// 두번째 버튼의 레이블 변경
		});
		
		$('#b2').click(function() {		// <button id="b2"> 엘리먼트를 클릭하면 자동 실행
			// 이미지 표시
			$("#display").html("<p style='width: 100px; height: 100px; background-color: red;'></p>");
		});
	});
</script>
</head>
<body>
	<p>이미지 표시</p>
	<button id="b1">버튼 레이블 변경</button>
	<div id="display"></div>
	<button id="b2">버튼</button>
</body>
</html>