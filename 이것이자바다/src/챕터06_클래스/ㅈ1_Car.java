package é��06_Ŭ����;

public class ��1_Car {
	// �ʵ�
	String model;
	int speed;
	
	// ������
	��1_Car(String model){
		this.model = model;
	}
	
	// �޼ҵ�
	void setSpeed(int speed) {
		this.speed = speed;
	}
	
	void run() {
		for (int i = 10; i <= 50 ; i+=10) {
			this.setSpeed(i);
			System.out.println(this.model + "�� �޸��ϴ� (�ü�: " + this.speed + "km/h)");
		}
	}
}
