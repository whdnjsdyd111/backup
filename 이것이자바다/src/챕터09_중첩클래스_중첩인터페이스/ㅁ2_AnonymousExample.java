package é��09_��øŬ����_��ø�������̽�;

public class ��2_AnonymousExample {
	public static void main(String[] args) {
		
		��2_Anonymous anony = new ��2_Anonymous();
		
		// �͸� ��ü �ʵ� ���
		anony.field.turnOn();
		anony.field.turnOff();
		
		// �͸� ��ü ���� ���� ���
		anony.method1();
		
		// �͸� ��ü �Ű��� ���
		anony.method2(
			new ��2_RemoteControl() {
				
				@Override
				public void turnOn() {
					System.out.println("SmartTV�� �մϴ�.");
				}
				
				@Override
				public void turnOff() {
					System.out.println("SmartTV�� ���ϴ�.");
				}
			}
		);
	}
}
