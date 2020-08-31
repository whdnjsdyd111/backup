/**
 * 
 */

$(function() {
	$('#insertCart').click(function() {	// [장바구니에 담기] 버튼 클릭
		var buyer = $('#buyer').val();
		var book_kind = $('#book_kind').val();
		
		var query = {
			book_id : $('#book_id').val(),
			buy_count : $('#buy_count').val(),
			book_image : $('#book_iamge').val(),
			book_title : $('#book_title').val(),
			book_price : $('#book_price').val(),
			buyer : buyer
		};
		
		$.ajax({
			type : "POST",
			url : "/Shoppingmall/insertCart.do",
			data : query,
			success : function(data) {
				alert("장바구니에 담겼습니다.");
			}
		});
	});
	
	$('#list').click(function() {	// [목록으로] 버튼 클릭
		window.location.href("/Shoppingmall/list.do?book_kind=all");
	});
	
	$('#shopMain').click(function() {
		window.location.href('/Shoppingmall/index.do');
	});
	
	$('#writeQna').click(function() {
		var book_id = $('#book_id').val();
		var book_kind = $('#book_kind').val();
		
		var query = "/Shoppingmall/qnaForm.do?book_id=" + book_id;
		query += "&book_kind=" + book_kind;
		
		window.location.href(query);
	});
});

function edit(editBtn) {	// [수정] 버튼 클릭
	var rStr = editBtn.name;
	var arr = rStr.split(",");
	var query = "/Shoppingmall/qnaUpdateForm.do?qna_id=" + arr[0];
	query += "&book_kind=" + arr[1];
	window.location.href(query);
}

function del(delBtn) {	// [삭제] 버튼 클릭
	var rStr = delBtn.name;
	var arr = rStr.split(",");
	
	var query = {
		qna_id : arr[0]
	};
	
	$.ajax({
		type : "POST",
		url : "/Shoppingmall/qnaDeletePro.do",
		data : query,
		success : function(data) {
			var str1 = "<p id='ck'>";
			var loc = data.indexOf(str1);
			var len = str1.length;
			var check = data.substr(loc + len, 1);
			
			if(check == "1") {
				alert("QnA가 삭제 되었습니다.");
				var query = "/Shoppingmall/bookContent.do?book_id=" + arr[1];
				query += "&book_kind=" + arr[2];
				window.location.href(query);
			} else	// 사용할 수 있는 아이디
				alert("QnA가 삭제 실패");
		}
	});
}