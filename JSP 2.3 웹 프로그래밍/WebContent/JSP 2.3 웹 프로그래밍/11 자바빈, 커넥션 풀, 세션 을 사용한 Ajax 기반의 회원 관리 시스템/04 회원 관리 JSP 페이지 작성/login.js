/**
 * 
 */
var status = true;

$(document).ready(function() {
	// [회원 가입] 버튼을 클릭하면 자동 실행
	$("#register").click(function() {
		// 회원 가압폼 registerForm.jsp 페이지를 
		// id 속성 값이 main_auth인 영역에 로드
		$('#main_auth').load("registerForm.jsp");
	});
	
	// [로그인] 버튼을 클릭하면 자동 실행
	// 압력한 아이디와 비밀번호를 갖고 loginPro.jsp 페이지 실행
	
	$('#login').click(function() {
		checkIt();	// 입력 폼에 입력한 상황 체크
		
		if(status) {
			// 입력된 사용자의 아이디와 비밀번호 알아냄
			var query = {
					id : $('#id').val(),
					passwd : $('#passwd').val()
			}
			
			$.ajax({
				type : "post",
				url : "loginPro.jsp",
				data : query,
				success : function(data) {
					if(data == 1)	// 로그인 성공 시
						$('#main_auth').load('loginForm.jsp');
					else if(data == 0) {	// 비밀번호 틀림
						alert("비밀번호가 맞지 않습니다.");
						$('#passwd').val("");
						$('#passwd').focus();
					} else if(data == -1) {	// 아이디 틀림
						alert("아이디가 맞지 않습니다.");
						$('#id').val("");
						$('#passwd').val("");
						$('#id').focus();
					}
				}
			});
		}
	});
	
	/*-- 인증된 사용자 영역을 처리하는 버튼들 --*/
	// [회원 정보 변경] 버튼을 클릭하면 자동 실행
	$('#update').click(function() {
		// 회원 정보 수정 및 회원 탈퇴를 위한 modify.jsp 페이지 요청
		$('#main_auth').load('modify.jsp');
	});
	
	// [로그아웃] 버튼을 클릭하면 자동 실행
	// logout.jsp 페이지를 실행
	$('#logout').click(function() {
		$.ajax({
			type : "post",
			url : "logout.jsp",
			success : function() {
				$('#main_auth').load('logoutForm.jsp');
			}
		});
	});
});

// 인증되지 않은 사용자 영역에서 사용하는 입력 폼의 입력 값 유무 확인
function checkIt(){
	status = true;
	
	if(!$.trim($('#id').val())) {	// 아이디를 입력하지 않으면 수행
		alert("아이디를 입력하세요");
		$('#id').focus();
		status = false;
		return false;	// 사용자가 서비스를 요청한 시점으로 돌아감
	}
	
	if(!$.trim($('#passwd').val())) {	// 비밀번호를 입력하지 않으면 수행
		alert("비밀번호를 입력하세요");
		$('#passwd').focus();
		status = false;
		return false;
	}
}