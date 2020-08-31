/**
 * 
 */

$(function() {
	$('#regist').click(function() {
		var book_kind = $('#book_kind').val();
		var book_id = $('book_id').val();
		
		var query = {
			qna_content : $('#qna_content').val(),
			qna_write : $('#qna_write').val(),
			book_title : $('#book_title').val(),
			book_id : book_id,
			qora : $('#qora').val()
		};
		
		$.ajax({
			type : "post",
			url : "/Shoppingmall/qnaPro.do",
			data : query,
			success : function(data) {
				var str1 = "<p id='ck'>";
				var loc = data.indexOf(str1);
				var len = str1.length;
				var check = data.substr(loc + len, 1);
				
				if(check == "1") {
					alert("QnA가 등록되었습니다.");
					var query = "/Shoppingmall/bookContent.do?book_id=" + book_id;
					query += "&book_kind=" + book_kind;
					window.location.href(query);
				} else
					alert("QnA 등록 실패");
			}
		});
	});
	
	$('#cancel').click(function() {	// [취소] 버튼 클릭
		var book_kind = $('#book_kind').val();
		var book_id = $('#book_id').val();
		var query = "/Shoppingmall/bookContent.do?book_id=" + book_id;
		query += "&book_kind=" + book_kind;
		window.location.href(query);
	});
});