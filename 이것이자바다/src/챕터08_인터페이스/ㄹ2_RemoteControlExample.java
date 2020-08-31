package 챕터08_인터페이스;

public class ㄹ2_RemoteControlExample {
	public static void main(String[] args) {
		
		ㄴ1_RemoteControl rc = null;
		
		rc = new ㄷ1_Television();
		rc.turnOn();
		rc.setMute(true);
		
		System.out.println();
		
		rc = new ㄹ2_Audio();
		rc.turnOn();
		rc.setMute(true);
		
	}
}
