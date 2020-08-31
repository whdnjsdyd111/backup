/**
 * 
 */

$(function() {
	// [로그인] 버튼을 클릭하면 자동 실행
	$("#login").click(function() {
		var query = {
			id : $('#id').val(),
			passwd : $('#passwd').val()
		};
		
		$.ajax({
			type: "POST",
			url : "/Shoppingmall/mg/managerLoginPro.do",
			data : query,
			success : function(data) {
				window.location.href("/Shoppingmall/mg/managerMain.do");
			}	
		});
		
	});
});