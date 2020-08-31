<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../../js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../../../js/jquery.form.min.js"></script>
<script type="text/javascript" src="../../../js/jquery.MetaData.js"></script>
<script type="text/javascript" src="../../../js/jquery.MultiFile.js"></script>
<script type="text/javascript" src="../../../js/jquery.blockUI.js"></script>
<script type="text/javascript" src="multiupload.js"></script>
</head>
<body>
	<form id="upForm1" action="multiUploadPro.jsp"
		method="post" enctype="multipart/form-data">
		<div id="form">
			<ul>
				<li>
					<p class="cau">※ 최대 업로드 파일 수 : 5개</p>
					<input type="file" id="file1" name="file1" class="multi" maxlength="5">
				<li>
					<input type="submit" id="upPro1" value="다중 파일 업로드">
			</ul>
		</div>	
	</form>
	<div id="upResult"></div>
</body>
</html>