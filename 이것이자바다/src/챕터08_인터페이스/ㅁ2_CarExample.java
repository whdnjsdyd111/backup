package é��08_�������̽�;

public class ��2_CarExample {
	public static void main(String[] args) {
		��2_Car car = new ��2_Car();
		
		car.run();
		
		System.out.println();
		
		car.tires[0] = new ��1_KumhoTire();
		car.tires[1] = new ��1_KumhoTire();
		car.run();
	}
}
