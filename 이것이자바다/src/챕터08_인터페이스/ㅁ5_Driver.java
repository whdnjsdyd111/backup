package 챕터08_인터페이스;

public class ㅁ5_Driver {
	public void drive(ㅁ4_Vehicle vehicle) {
		if(vehicle instanceof ㅁ4_Bus) {
			ㅁ4_Bus bus = (ㅁ4_Bus) vehicle;
			bus.checkFare();		// Bus 타입으로 강제 타입 변환을 하는 이유
		}
		
		vehicle.run();
	}
}
