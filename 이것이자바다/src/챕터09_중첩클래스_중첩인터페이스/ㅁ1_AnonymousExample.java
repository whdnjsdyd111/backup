package é��09_��øŬ����_��ø�������̽�;

public class ��1_AnonymousExample {
	public static void main(String[] args) {
		
		��1_Anonymous anony = new ��1_Anonymous();
		
		// �͸� ��ü �ʵ� ���
		anony.field.wake();
		
		// �͸� ��ü ���� ���� ���
		anony.method1();
		
		// �͸� ��ü �Ű��� ���
		anony.method2(
			new ��1_Person() {
				void study() {
					System.out.println("�����մϴ�.");
				}
					
				@Override
				void wake() {
					System.out.println("8�ÿ� �Ͼ�ϴ�.");
					study();
				}
			}
		);
		
	}
}
