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
		// [결과] 버튼을 클릭하면 xhrTest3.txt가 <div id="result"> 엘리먼트에 로드
		$('#b1').click(function() {
			$('#result').load("xhrTest3.txt", function(response, stu, xhr){
				if(stu == "success")	// 서버 요청이 성공 시
					alert("로드 성공!");
				if(stu == "error")
					alert("에러 : " + xhr.status + " : " + xhr.stu);
			});
		});
	});
</script>
</head>
<body>
	<button id="b1">결과</button>
	<div id="result"></div>
</body>
</html>