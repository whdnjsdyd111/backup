package é��08_�������̽�;

public class ��2_RemoteControlExample {
	public static void main(String[] args) {
		
		��1_RemoteControl rc = null;
		
		rc = new ��1_Television();
		rc.turnOn();
		rc.setMute(true);
		
		System.out.println();
		
		rc = new ��2_Audio();
		rc.turnOn();
		rc.setMute(true);
		
	}
}
