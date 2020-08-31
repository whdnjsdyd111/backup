<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../../js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../../../js/jquery.form.min.js"></script>
<script type="text/javascript" src="multiupload.js"></script>
</head>
<body>
	<form id="upForm1" action="multiUploadPro.jsp"
		method="post" enctype="multipart/form-data">
		<div id="form">
			<ul>
				<li>
					<p class="cau">※ 파일선택기에서 ctrl, shift 키를 눌러 파일을 다중 선택 하십시오.</p>
					<label for="file1">파일선택</label>
					<input type="file" id="file1" name="file1" multiple="multiple">
				<li>
					<input type="submit" id="upPro1" value="다중 파일 업로드">
			</ul>
		</div>
	</form>
	<div id="upResult"></div>
</body>
</html>