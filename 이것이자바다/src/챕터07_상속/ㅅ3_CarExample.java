package é��07_���;

public class ��3_CarExample {
	public static void main(String[] args) {
		��3_Car car = new ��3_Car();
		
		for (int i = 0; i <= 5; i++) {
			int problemLocation = car.run();
			
			switch(problemLocation) {
			
			case 1:
				System.out.println("�տ��� HankookTire�� ��ü");
				car.frontLeftTire = new ��3_HankookTire("�տ���", 15);
				break;
				
			case 2:
				System.out.println("�տ����� KumhoTire�� ��ü");
				car.frontRightTire = new ��3_KumhoTire("�տ�����", 13);
				break;
				
			case 3:
				System.out.println("�ڿ��� HankookTire�� ��ü");
				car.backLeftTire = new ��3_HankookTire("�ڿ���", 14);
				break;
				
			case 4:
				System.out.println("�ڿ����� KumhoTire�� ��ü");
				car.backRightTire = new ��3_KumhoTire("�ڿ�����", 17);
				break;
			}
			
			System.out.println("-------------------------");
		}
	}
}
