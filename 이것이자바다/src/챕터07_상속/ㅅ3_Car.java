package é��07_���;

public class ��3_Car {
	// �ʵ�
	��3_Tire frontLeftTire = new  ��3_Tire("�տ���", 6);
	��3_Tire frontRightTire = new  ��3_Tire("�տ�����", 2);
	��3_Tire backLeftTire = new  ��3_Tire("�ڿ���", 6);
	��3_Tire backRightTire = new  ��3_Tire("�ڿ�����", 6);		// 4���� Ÿ�̾�
	
	// ������
	
	// �޼ҵ�
	int run() {
		System.out.println("[�ڵ����� �޸��ϴ�.]");
		
		if(frontLeftTire.roll() == false) { stop(); return 1; }		// ��� Ÿ�̾ 1ȸ ȸ����Ű�� ����
		if(frontRightTire.roll() == false) { stop(); return 2; }	// �� Tire ��ü�� roll() �޼ҵ带 ȣ���Ѵ�.
		if(backLeftTire.roll() == false) { stop(); return 3; }		// false�� �����ϴ� roll()�� ���� ��� stop() �޼ҵ带 ȣ���ϰ� 
		if(backRightTire.roll() == false) { stop(); return 4;}		// �ش� Ÿ�̾� ��ȣ�� �����Ѵ�.
		
		return 0;
	}
	
	void stop() {		// ��ũ ���� �� ����
		System.out.println("[�ڵ����� ����ϴ�.]");
	}
}
