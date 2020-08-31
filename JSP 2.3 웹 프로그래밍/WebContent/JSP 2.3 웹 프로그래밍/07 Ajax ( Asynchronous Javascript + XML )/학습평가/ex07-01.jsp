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
<script type="text/javascript">
	$(function() {
		$('button').click(function() {
			var id = $('#id').val();
			var passwd = $('#passwd').val();

			$('#result').val("아이디: " + id + '\n' +
					"비밀번호: " + passwd);
		});
	});
</script>
</head>
<body>
	<p>아이디와 비밀번호 입력
	<form>
		아이디 <input name="id" id="id"><br> 비밀번호<input
			name="passwd" id="passwd"><br> 결과<br>
		<button type="button">확인</button>
		<textarea rows="10" cols="10" id="result"></textarea>
	</form>
</body>
</html>