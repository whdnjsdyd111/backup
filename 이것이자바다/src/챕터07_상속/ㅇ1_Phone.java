package é��07_���;

public abstract class ��1_Phone {
	//�ʵ�
	public String owner;
	
	// ������
	public ��1_Phone(String owner) {
		this.owner = owner;
	}
	
	// �޼ҵ�
	public void turnOn() {
		System.out.println("�� ������ �մϴ�.");
	}
	
	public void turnOff() {
		System.out.println("�� ������ ���ϴ�.");
	}
}
