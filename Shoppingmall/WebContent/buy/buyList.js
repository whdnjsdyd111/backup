/**
 * 
 */

$(function() {
	$('#conShopping').click(function() {	// [쇼핑계속] 버튼 클릭
		window.location.href("/Shoppingmall/list.do?book_kind=all");
	});
	
	$('#shopMain').click(function() {
		window.location.href("/Shoppingmall/index.do");
	});
});