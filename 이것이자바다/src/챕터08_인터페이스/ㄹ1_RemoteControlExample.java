package é��08_�������̽�;

public class ��1_RemoteControlExample {
	public static void main(String[] args) {
		
		��1_RemoteControl rc = null;		// �������̽� ���� ����
		
		rc = new ��1_Television();		// Television ��ü�� �������̽� Ÿ�Կ� ����
		rc.turnOn();
		rc.turnOff();					// �������̽��� turnOn(), turnOff() ȣ��
		
		rc = new ��1_Audio();			// Audio ��ü�� �������̽� Ÿ�Կ� ����
		rc.turnOn();
		rc.turnOff();					// �������̽��� turnOn(), turnOff() ȣ��	
		
	}
}
