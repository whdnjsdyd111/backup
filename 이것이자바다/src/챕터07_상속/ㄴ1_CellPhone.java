package é��07_���;

public class ��1_CellPhone {
	// �ʵ�
	String model;
	String color;
	
	// ������
	
	
	// �޼ҵ�
	void powerOn() { System.out.println("������ �մϴ�."); }
	void powerOff() { System.out.println("������ ���ϴ�."); }
	
	void bell() { System.out.println("���� �︳�ϴ�."); }
	void hangUp() { System.out.println("��ȭ�� �����ϴ�."); }
	
	void sendVoice(String message) { System.out.println("�ڱ�: " + message); }
	void receiveVoice(String message) { System.out.println("����: " + message); }
}
