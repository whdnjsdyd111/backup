package 챕터08_인터페이스;

public class ㅁ2_CarExample {
	public static void main(String[] args) {
		ㅁ2_Car car = new ㅁ2_Car();
		
		car.run();
		
		System.out.println();
		
		car.tires[0] = new ㅁ1_KumhoTire();
		car.tires[1] = new ㅁ1_KumhoTire();
		car.run();
	}
}
