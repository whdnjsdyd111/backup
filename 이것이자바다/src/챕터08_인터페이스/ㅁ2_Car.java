package é��08_�������̽�;

public class ��2_Car {
	��1_Tire[] tires = {
			new ��1_HankookTire(),
			new ��1_HankookTire(),
			new ��1_HankookTire(),
			new ��1_HankookTire()
	};
	
	void run() {
		for(��1_Tire tire : tires) {
			tire.roll();
		}
	}
}
