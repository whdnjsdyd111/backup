package 챕터06_클래스;

public class ㅇ5_CarExample {
	public static void main(String[] args) {
		ㅇ5_Car car = new ㅇ5_Car();
		
		car.keyTurnOn();
		car.run();
		int speed = car.getSpeed();
		System.out.println("현재 속도: " + speed + "km/h");
		
		
	}
}
