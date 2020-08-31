package 챕터07_상속;

public class ㅅ3_Car {
	// 필드
	ㅅ3_Tire frontLeftTire = new  ㅅ3_Tire("앞왼쪽", 6);
	ㅅ3_Tire frontRightTire = new  ㅅ3_Tire("앞오른쪽", 2);
	ㅅ3_Tire backLeftTire = new  ㅅ3_Tire("뒤왼쪽", 6);
	ㅅ3_Tire backRightTire = new  ㅅ3_Tire("뒤오른쪽", 6);		// 4개의 타이어
	
	// 생성자
	
	// 메소드
	int run() {
		System.out.println("[자동차가 달립니다.]");
		
		if(frontLeftTire.roll() == false) { stop(); return 1; }		// 모든 타이어를 1회 회전시키기 위해
		if(frontRightTire.roll() == false) { stop(); return 2; }	// 각 Tire 객체의 roll() 메소드를 호출한다.
		if(backLeftTire.roll() == false) { stop(); return 3; }		// false를 리턴하는 roll()이 있을 경우 stop() 메소드를 호출하고 
		if(backRightTire.roll() == false) { stop(); return 4;}		// 해당 타이어 번호를 리턴한다.
		
		return 0;
	}
	
	void stop() {		// 펑크 났을 때 실행
		System.out.println("[자동차가 멈춥니다.]");
	}
}
