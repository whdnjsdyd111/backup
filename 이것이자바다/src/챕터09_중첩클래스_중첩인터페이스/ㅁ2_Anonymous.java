package é��09_��øŬ����_��ø�������̽�;

public class ��2_Anonymous {
	// �ʵ� �ʱⰪ���� ����
	��2_RemoteControl field = new ��2_RemoteControl() {
		
		@Override
		public void turnOn() {
			System.out.println("TV�� �մϴ�.");
		}
		
		@Override
		public void turnOff() {
			System.out.println("TV�� ���ϴ�.");
		}
	};
	
	void method1() {
		// ���� ���������� ����
		��2_RemoteControl localVar = new ��2_RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("Audio�� �մϴ�.");
			}
			
			@Override
			public void turnOff() {
				System.out.println("Audio�� ���ϴ�.");
			}
		};
		
		// ���� ���� ���
		localVar.turnOn();
		localVar.turnOff();
		
	}
	
	void method2(��2_RemoteControl rc) {
		rc.turnOn();
		rc.turnOff();
	}
}
