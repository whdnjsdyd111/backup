package 챕터08_인터페이스;

public class ㅁ2_Car {
	ㅁ1_Tire[] tires = {
			new ㅁ1_HankookTire(),
			new ㅁ1_HankookTire(),
			new ㅁ1_HankookTire(),
			new ㅁ1_HankookTire()
	};
	
	void run() {
		for(ㅁ1_Tire tire : tires) {
			tire.roll();
		}
	}
}
