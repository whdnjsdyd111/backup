package 챕터09_중첩클래스_중첩인터페이스;

public class Question05_Anonymous {
	Question05_Vehicle field = new Question05_Vehicle() {
		
		@Override
		public void run() {
			System.out.println("자전거가 달립니다.");
		}
	};
	
	void method1() {
		Question05_Vehicle localVar = new Question05_Vehicle() {
			
			@Override
			public void run() {
				System.out.println("승용차가 달립니다.");
			}
		};
		localVar.run();	
	}
	
	void method2(Question05_Vehicle v) {
		v.run();
	}
}
