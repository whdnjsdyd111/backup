package 챕터08_인터페이스;

public class ㅁ1_Car {
	ㅁ1_Tire frontLeftTire = new ㅁ1_HankookTire();
	ㅁ1_Tire frontRightTire = new ㅁ1_HankookTire();
	ㅁ1_Tire backLeftTire = new ㅁ1_HankookTire();
	ㅁ1_Tire backRightTire = new ㅁ1_HankookTire();		// 인터페이스 타입 필드 선언과 초기 구현 객체 대입
	
	void run() {
		frontLeftTire.roll();
		frontRightTire.roll();
		backLeftTire.roll();
		backRightTire.roll();							// 인터페이스에서 설명된 roll() 메소드 호출
	}
}
