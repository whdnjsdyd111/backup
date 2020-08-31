package é��08_�������̽�;

public class ��4_SmartTelevision implements ��1_RemoteControl, ��4_Searchable{
	private int volume;
	
	// RemoteControl�� �߻� �޼ҵ��
	
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
	
	// Searchable�� �߻� �޼ҵ�
	
	// search() �߻� �޼ҵ��� ��ü �޼ҵ�
	public void search(String url) {
		System.out.println(url + "�� �˻��մϴ�.");
	}
}
