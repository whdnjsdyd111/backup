<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/Shoppingmall/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Shoppingmall/mngr/productProcess/booklist.js"></script>
<c:if test="${ empty sessionScope.id }">
	<meta http-equiv="Refresh" content="0; url=/Shoppingmall/mg/managerMain.do">
</c:if>
</head>
<body>
	<div id="listHeader">
		<p>등록된 상품 목록(전체 상품 : ${ count })
		<button id="regist">책 등록</button>
		<button id="bookMain">관리자 메인으로</button>
	</div>
	<div id="books">
		<c:if test="${ count == 0 }">
			<ul>
				<li>등록된 상품이 없습니다.
			</ul>
		</c:if>
		<c:if test="${ count > 0 }">
			<table>
				<tr class="title">
					<td align="center" width="30">번호</td>
					<td align="center" width="30">책분류</td>
					<td align="center" width="100">제목</td>
					<td align="center" width="50">가격</td>
					<td align="center" width="50">수량</td>
					<td align="center" width="70">저자</td>
					<td align="center" width="70">출판사</td>
					<td align="center" width="50">출판일</td>
					<td align="center" width="50">책이미지</td>
					<td align="center" width="30">할인율</td>
					<td align="center" width="70">등록일</td>
					<td align="center" width="50">수정</td>
					<td align="center" width="50">삭제</td>
				</tr>
				
				<c:set var="number" value="${ 0 }" />
				<c:forEach var="book" items="${ bookList }">
					<tr>
						<td align="center" width="50">
							<c:set var="number" value="${ number + 1 }" />
							<c:out value="${ number }" />
						</td>
						<td width="30">${ book.getBook_kind() }</td>
						<td width="100" align="left">${ book.getBook_title() }</td>
						<td width="50" align="right">${ book.getBook_price() }</td>
						<td width="50" align="right">
						<c:if test="${ book.getBook_count() == 0 }">
							<font color="red">일시품절</font>
						</c:if>
						<c:if test="${ book.getBook_count() > 0 }">
							${ book.getBook_count() }
						</c:if>
						</td>
						<td width="70">${ book.getAuthor() }</td>
						<td width="70">${ book.getPublishing_com() }</td>
						<td width="50">${ book.getPublishing_date() }</td>
						<td width="50">${ book.getBook_image() }</td>
						<td width="50">${ book.getDiscount_rate() }</td>
						<td width="50">
							<fmt:formatDate value="${ book.getReg_date() }" pattern="yyyy-MM-dd"/>
						</td>
						<td width="50">
							<button id="edit" name="${ book.getBook_id },${ book.getBook_kind() }" onclick="edit(this)">수정</button>
						</td>
						<td width="50">
							<button id="delete" name="${ book.getBook_id() },${ book.getBook_kind() }" onclick="del(this)">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>