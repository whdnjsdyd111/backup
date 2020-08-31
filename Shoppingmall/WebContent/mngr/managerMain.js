/**
 * 
 */

var status = true;

$(function() {
	$("#registProduct").click(function() {	// [상품등록] 버튼 클릭
		window.location.href("/Shoppingmall/mg/bookRegisterForm.do");
	});
	
	$("#updateProduct").click(function() {	// [상품수정/삭제] 버튼 클릭
		window.location.href("/Shoppingmall/mg/bookList.do?book_kind=all");
	});
	
	$("#orderProduct").click(function() {	// [전체구매목록 확인] 버튼 클릭
		window.location.href("/Shoppingmall/mg/orderList.do");
	});
	
	$("#qna").click(function() {	// [상품 QnA 답변] 버튼 클릭
		window.location.href("/Shoppingmall/mg/qnaList.do");
	});
});