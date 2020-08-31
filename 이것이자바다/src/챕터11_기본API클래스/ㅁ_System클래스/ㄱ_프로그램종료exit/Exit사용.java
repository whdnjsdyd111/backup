package 챕터11_기본API클래스.ㅁ_System클래스.ㄱ_프로그램종료exit;

public class Exit사용 {
	public static void main(String[] args) {
		// 보안 설정 관리자
		System.setSecurityManager(new SecurityManager() {
			@Override
			public void checkExit(int status) {
				if(status != 5) {
					throw new SecurityException();
				}
			}
		});
		
		for(int i=0; i<10; i++) {
			// i값 출력
			System.out.println(i);
			try {
				// JVM 종료 요청
				System.exit(i);
			} catch(SecurityException e) {}
		}
	}
}
