package é��06_Ŭ����;

public class ��3_CarExample {
	public static void main(String[] args) {
		��3_Car car = new ��3_Car();
		
		car.setGas(5);	// car �� setGas() �޼ҵ� ȣ��
		
		boolean gasState = car.isLeftGas();	// car �� isLeftGas() �޼ҵ� ȣ��
		
		if(gasState) {
			System.out.println("����մϴ�");
			car.run();	// car�� run() �޼ҵ� ȣ��
			
		}
		
		if(car.isLeftGas()) {	// car�� isLeftGas() �޼ҵ� ȣ��
			System.out.println("gas�� ������ �ʿ䰡 �����ϴ�.");
		} else {
			System.out.println("gas�� �����ϼ���.");
		}
	}
}
