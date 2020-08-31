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
#result {
	width: 200px;
	height: 200px;
	border: 5px double #6699FF;
}
</style>
<script>
	$(function() {
		$('#btn').click(function() {	// [결과] 버튼을 클릭하면 자동 실행
			// 요청 페이지에 전송할 데이터
			var query = { name: $('#name').val() };
		
			$.ajax({
				type: "POST",
				url: "ex07-03Pro.jsp",	// 요청 페이지
				data: query,	// 전송 데이터
				success: function(data) {		// 요청 페이지를 실행한 결과
					$('#result').html(data);
				}
			});
		
		});
	});
</script>
</head>
<body>
	<form>
		이름 <input type="text" id="name" name="name"><br>
		<button id="btn">처리</button>
		<br>
	</form>
	<div id="result"></div>
</body>
</html>