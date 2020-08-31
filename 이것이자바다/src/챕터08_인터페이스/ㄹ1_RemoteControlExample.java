package 챕터08_인터페이스;

public class ㄹ1_RemoteControlExample {
	public static void main(String[] args) {
		
		ㄴ1_RemoteControl rc = null;		// 인터페이스 변수 선언
		
		rc = new ㄷ1_Television();		// Television 객체를 인터페이스 타입에 대입
		rc.turnOn();
		rc.turnOff();					// 인터페이스의 turnOn(), turnOff() 호출
		
		rc = new ㄷ1_Audio();			// Audio 객체를 인터페이스 타입에 대입
		rc.turnOn();
		rc.turnOff();					// 인터페이스의 turnOn(), turnOff() 호출	
		
	}
}
