package 챕터08_인터페이스;

public class ㅁ4_VehicleExample {
	public static void main(String[] args) {
		
		ㅁ4_Vehicle vehicle = new ㅁ4_Bus();
		
		vehicle.run();
//		vehicle.checkFare(); (x)	// Vehicle 인터페이스에는 checkFare()가 없음
		
		ㅁ4_Bus bus = (ㅁ4_Bus) vehicle;	// 강제 타입 변환
		
		bus.run();
		bus.checkFare();			// Bus 클래스에는 checkFare()가 있음
	}
}
