/**
 * 
 */

$(function() {
	$('#conShopping').click(function() {	// [쇼핑계속] 버튼 클릭
		window.location.href("/Shoppingmall/list.do?book_kind=all");
	})
	
	$('#shopMain').click(function() {
		window.location.href('/Shoppingmall/index.do');
	});
});

function editSu(editBtn) {	// [수정] 버튼 클릭
	var rStr = editBtn.name;
	var arr = rStr.split(",");
	var query = "/Shoppingmall/cartUpdateForm.do?cart_id=" + arr[0];
	query += "&buy_count" + arr[1];
	window.location.href(query);
}

function delList(delBtn) {	// [삭제] 버튼 클릭
	var rStr = delBtn.name;
	var query = "/Shoppingmall/deleteCart.do?list=" + rStr;
	window.location.href(query);
}