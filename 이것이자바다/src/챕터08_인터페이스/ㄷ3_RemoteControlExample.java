package 챕터08_인터페이스;

public class ㄷ3_RemoteControlExample {
	public static void main(String[] args) {
		
		ㄴ1_RemoteControl rc = new ㄴ1_RemoteControl() {
			public void turnOn() { /* 실행문	 */ }
			public void turnOff() { /* 실행문 */ }
			public void setVolume(int volume) { /* 실행문 */ }
		};
		
	}
}
