package é��07_���;

public class ��4_Car {
	// �ʵ�
	��3_Tire[] tires = {
			new ��3_Tire("�տ���", 6),
			new ��3_Tire("�տ�����", 2),
			new ��3_Tire("�ڿ���", 3),
			new ��3_Tire("�ڿ�����", 4)
	};
	
	// ������
	
	// �޼ҵ�
	int run() {
		System.out.println("[�ڵ����� �޸��ϴ�.]");

		for (int i = 0; i < tires.length; i++) {

			if (tires[i].roll() == false) {

				stop();
				return (i + 1);

			}
		}

		return 0;
	}

	void stop() { // ��ũ ���� �� ����
		System.out.println("[�ڵ����� ����ϴ�.]");
	}
}
