package 챕터09_중첩클래스_중첩인터페이스;

public class ㅁ2_AnonymousExample {
	public static void main(String[] args) {
		
		ㅁ2_Anonymous anony = new ㅁ2_Anonymous();
		
		// 익명 객체 필드 사용
		anony.field.turnOn();
		anony.field.turnOff();
		
		// 익명 객체 로컬 변수 사용
		anony.method1();
		
		// 익명 객체 매개값 사용
		anony.method2(
			new ㅁ2_RemoteControl() {
				
				@Override
				public void turnOn() {
					System.out.println("SmartTV를 켭니다.");
				}
				
				@Override
				public void turnOff() {
					System.out.println("SmartTV를 끕니다.");
				}
			}
		);
	}
}
