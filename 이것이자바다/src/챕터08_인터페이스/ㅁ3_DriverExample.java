package é��08_�������̽�;

public class ��3_DriverExample {
	public static void main(String[] args) {
		
		��3_Driver driver = new ��3_Driver();
		
		��3_Bus bus = new ��3_Bus();
		��3_Taxi taxi = new ��3_Taxi();
		
		driver.drive(bus);		// �ڵ� Ÿ�� ��ȯ: Vehicle vehicle = bus;
		driver.drive(taxi);		// �ڵ� Ÿ�� ��ȯ: Vehicle vehicle = taxi;
	}
}
