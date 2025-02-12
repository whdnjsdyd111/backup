<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/Shoppingmall/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Shoppingmall/member/modify.js"></script>
<c:if test="${ empty sessionScope.id }">
	<meta http-equiv="Refresh" content="0; url=/Shoppingmall/index.do">
</c:if>
</head>
<body>
	<div id="regForm" class="box">
		<ul>
			<li><p class="center">회원 정보 수정
			<li><label for="id">아이디</label>
				<input id="id" name="id" type="email" size="20"
					maxlength="50" value="${ id }" readonly="readonly" disabled="disabled">
			<li><label for="passwd">비밀번호</label>
				<input id="passwd" name="passwd" type="password"
					size="20" placeholder="6 ~ 16 숫자/문자" maxlength="16">
				<small class="cau">반드시 입력하세요.</small>
			<li><label for="name">이름</label>
				<input id="name" name="name" type="text"
					size="20" maxlength="10" value="${ m.getName() }">
			<li><label for="address">주소</label>
				<input id="address" name="address" type="text"
					size="30" maxlength="50" value="${ m.getAddress() }">
			<li><label for="tel">전화번호</label>
				<input id="tel" name="tel" type="tel"
					size="20" maxlength="20" value="${ m.getTel() }">
			<li class="label2"><button id="modifyProcess">수정</button>
				<button id="cancel">취소</button>
		</ul>
	</div>
</body>
</html>