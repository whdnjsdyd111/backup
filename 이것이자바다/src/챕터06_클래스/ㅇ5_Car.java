package é��06_Ŭ����;

public class ��5_Car {
	// �ʵ�
	int speed;
	
	// ������
	
	
	// �޼ҵ�
	int getSpeed() {
		return speed;
	}
	
	void keyTurnOn() {
		System.out.println("Ű�� �����ϴ�.");
	}
	
	void run() {
		for (int i = 0; i <= 50; i+=10) {
			speed = i;
			System.out.println("�޸��ϴ�. (�ü�: " + speed + "km/h)");
		}
	}
}
