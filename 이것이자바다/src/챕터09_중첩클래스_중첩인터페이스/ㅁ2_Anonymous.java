package 챕터09_중첩클래스_중첩인터페이스;

public class ㅁ2_Anonymous {
	// 필드 초기값으로 대입
	ㅁ2_RemoteControl field = new ㅁ2_RemoteControl() {
		
		@Override
		public void turnOn() {
			System.out.println("TV를 켭니다.");
		}
		
		@Override
		public void turnOff() {
			System.out.println("TV를 끕니다.");
		}
	};
	
	void method1() {
		// 로컬 변수값으로 대입
		ㅁ2_RemoteControl localVar = new ㅁ2_RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("Audio를 켭니다.");
			}
			
			@Override
			public void turnOff() {
				System.out.println("Audio를 끕니다.");
			}
		};
		
		// 로컬 변수 사용
		localVar.turnOn();
		localVar.turnOff();
		
	}
	
	void method2(ㅁ2_RemoteControl rc) {
		rc.turnOn();
		rc.turnOff();
	}
}
