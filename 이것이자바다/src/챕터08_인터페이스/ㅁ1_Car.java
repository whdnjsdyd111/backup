package é��08_�������̽�;

public class ��1_Car {
	��1_Tire frontLeftTire = new ��1_HankookTire();
	��1_Tire frontRightTire = new ��1_HankookTire();
	��1_Tire backLeftTire = new ��1_HankookTire();
	��1_Tire backRightTire = new ��1_HankookTire();		// �������̽� Ÿ�� �ʵ� ����� �ʱ� ���� ��ü ����
	
	void run() {
		frontLeftTire.roll();
		frontRightTire.roll();
		backLeftTire.roll();
		backRightTire.roll();							// �������̽����� ����� roll() �޼ҵ� ȣ��
	}
}
