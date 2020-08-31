/**
 * 
 */

$(function() {
	$("regist").click(function() {	// [책등록] 버튼 클릭
		window.location.href("/Shoppingmall/mg/bookRegisterForm.do");
	});
	
	$("#bookMain").click(function() {	// [관리자 메인으로] 버튼 클릭
		window.loaction.href("/Shoppingmall/mg/managerMain.do");
	});
});

// [수정] 버튼을 클릭하면 자동 실행
function edit(editBtn) {
	var rStr = editBtn.name;
	var arr = rStr.split(",");
	var query = "/Shoppingmall/mg/bookUpdateForm.do?book_id=" + arr[0];
	query += "&book_kind=" + arr[1];
	window.loaction.href(query);
}

// [삭제] 버튼을 클릭하면 자동 실행
function del(delBtn) {
	var rStr = delBtn.name;
	var arr = rStr.split(",");
	var query = "/Shoppingmall/mg/bookDeletePro.do?book_id=" + arr[0];
	query += "&book_kind=" + arr[1];
	window.location.href(query);
}