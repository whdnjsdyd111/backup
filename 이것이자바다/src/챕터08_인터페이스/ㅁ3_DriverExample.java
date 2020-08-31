package 챕터08_인터페이스;

public class ㅁ3_DriverExample {
	public static void main(String[] args) {
		
		ㅁ3_Driver driver = new ㅁ3_Driver();
		
		ㅁ3_Bus bus = new ㅁ3_Bus();
		ㅁ3_Taxi taxi = new ㅁ3_Taxi();
		
		driver.drive(bus);		// 자동 타입 변환: Vehicle vehicle = bus;
		driver.drive(taxi);		// 자동 타입 변환: Vehicle vehicle = taxi;
	}
}
