package é��08_�������̽�;

public class ��1_Television implements ��1_RemoteControl{
	// �ʵ�
	private int volume;
	
	// turnOn() �߻� �޼ҵ��� ��ü �޼ҵ�
	public void turnOn() {
		System.out.println("TV�� �մϴ�.");
	}
	
	// turnOff() �߻� �޼ҵ��� ��ü �޼ҵ�
	public void turnOff() {
		System.out.println("TV�� ���ϴ�.");
	}
	
	// setVolume() �߻� �޼ҵ��� ��ü �޼ҵ�
	public void setVolume(int volume) {
		if( volume > MAX_VOLUME ) {
			this.volume = MAX_VOLUME;
		} else if ( volume < MIN_VOLUME) {
			this.volume = MIN_VOLUME;					// �������̽� ����� �̿��ؼ� volume �ʵ��� ���� ����
		} else {
			this.volume = volume;
		}
		
		System.out.println("���� TV ����: " + volume);
	}
}
