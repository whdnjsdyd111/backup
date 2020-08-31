/**

 * 
 */

$(function() {
	$('#update').click(function() {	// [수정] 버튼 클릭
		var qna_id = $('#qna_id').val();
		var query = {
			qna_content : $('#uRContent').val(),
			qna_id : $('#qna_id').val()
		}
		
		$.ajax({
			type : "POST",
			url : "/Shoppingmall/mg/qnaReplyUpdatePro.do",
			data : query,
			success : function(data) {
				window.location.href("/Shoppingmall/mg/qnaList.do");
			}
		});
	});
	
	$('#cancel').click(function() {
		window.location.href("/Shoppingmall/mg/qnaList.do");
	})
});