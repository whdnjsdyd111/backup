package é��07_���;

public class ��5_DriverExample {
	public static void main(String[] args) {
		��5_Driver driver = new ��5_Driver();
		
		��5_Bus bus = new ��5_Bus();
		��5_Taxi taxi = new ��5_Taxi();
		
		driver.drive(bus);		// �ڵ� Ÿ�� ��ȯ: Vehicle vehicle = bus;
		driver.drive(taxi);		// �ڵ� Ÿ�� ��ȯ: Vehicle vehicle = taxi;
		
	}
}
