<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/Shoppingmall/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Shoppingmall/member/login.js"></script>
</head>
<body>
	<c:if test="${ empty sessionScope.id }">
		<div id="lStatus">
			<ul>
				<li><label for="cid">아이디</label>
					<input id="cid" name="cid" type="email" size="20"
						maxlength="50" placeholder="example@kings.com">
					<label for="cpasswd">비밀번호</label>
					<input id="cpasswd" name="cpasswd" type="password"
						size="20" placeholder="6 ~ 16자 숫자/문자" maxlength="16">
					<button id="uLogin">로그인</button>
					<button id="uRes">회원가입</button>
			</ul>
		</div>
	</c:if>
	<c:if test="${ !empty sessionScope.id }">
		<div id="lStatus">
			<ul>
				<li>${ sessionScope.id }님이 로그인 하셨습니다.
					<div id="info">
						<table>
							<tr height="10">
								<td><button id="uLogout">로그아웃</button></td>
								<td><button id="uUpdate">회원 정보 변경</button></td>
								<td><form id="cartForm" method="post" action="/Shoppingmall/cartList.do">
										<input type="hidden" name="buyer" value="${ sessionScope.id }">
										<input type="hidden" name="cart" value="장바구니">
									</form>
								</td>
								<td><form id="buyForm" method="post" action="/Shoppingmall/buyList.do">
										<input type="hidden" name="buyer" value="${ sessionScope.id }">
										<input type="submit" name="buy" value="구매내역">
									</form>
								</td>
						</table>
					</div>
			</ul>
		</div>
	</c:if>
</body>
</html>