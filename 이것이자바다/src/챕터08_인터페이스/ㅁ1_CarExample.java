package 챕터08_인터페이스;

public class ㅁ1_CarExample {
	public static void main(String[] args) {
		
		ㅁ1_Car car = new ㅁ1_Car();
		
		car.run();
		
		System.out.println();
		
		car.frontLeftTire = new ㅁ1_KumhoTire();
		car.frontRightTire = new ㅁ1_KumhoTire();
		
		car.run();
		
	}
}
