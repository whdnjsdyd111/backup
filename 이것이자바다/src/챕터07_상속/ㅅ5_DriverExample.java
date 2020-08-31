package 챕터07_상속;

public class ㅅ5_DriverExample {
	public static void main(String[] args) {
		ㅅ5_Driver driver = new ㅅ5_Driver();
		
		ㅅ5_Bus bus = new ㅅ5_Bus();
		ㅅ5_Taxi taxi = new ㅅ5_Taxi();
		
		driver.drive(bus);		// 자동 타입 변환: Vehicle vehicle = bus;
		driver.drive(taxi);		// 자동 타입 변환: Vehicle vehicle = taxi;
		
	}
}
