package é��08_�������̽�;

public class ��1_CarExample {
	public static void main(String[] args) {
		
		��1_Car car = new ��1_Car();
		
		car.run();
		
		System.out.println();
		
		car.frontLeftTire = new ��1_KumhoTire();
		car.frontRightTire = new ��1_KumhoTire();
		
		car.run();
		
	}
}
