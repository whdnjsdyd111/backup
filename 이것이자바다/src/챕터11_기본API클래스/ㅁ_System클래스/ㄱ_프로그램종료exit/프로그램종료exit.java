package 챕터11_기본API클래스.ㅁ_System클래스.ㄱ_프로그램종료exit;

public class 프로그램종료exit {
	// 경우에 따라서는 강제적으로 JVM을 종료시킬 때도 있다. 이때 System 클래스의 exit() 메소드를 호출하면 된다.
	// exit() 메소드는 현재 실행하고 있는 프로세스를 강제 종료시키는 역할을 한다.
	// exit() 메소드는 int 매개값을 지정하도록 되어 있는데, 이 값을 종료 상태값이라고 한다.
	// 일반적으로 정상 종료일 경우 0으로 지정하고 비정상 종료일 경우 0 이외의 다른 값을 준다.
	
	// System.exit(0);
	
	// 어떤 값을 주더라도 종료가 되는데, 만약 특정 값이 입력되었을 경우에만 종료하고 싶다면 자바의 보안 관리자를 직접 설정해서 종료 상태값을 확인하면 된다.
	// System.exit()가 실행되면 보안 관리자의 checkExit() 메소드가 자동 호출되는데, 
	// 이 메소드에서 종료 상태값을 조사해서 특정 값이 입력되지 않으면 SecurityException을 발생시켜
	// System.exit()를 호출한 곳에서 예외 처리를 할 수 있도록 해준다. checkExit()가 정상적으로 실행되면 JVM은 종료가 된다.
	// 다음은 종료 상태값으로 5가 입력되면 JVM을 종료하도록 보안 관리자를 설정한다.
	
	/*
	System.setSecurityManager(new SecurityManager() {
		@Override
		public void checkExit(int status) {
			if(status != 5) {
				throw new SecurityException();
			}
		}
	});
	*/
}
