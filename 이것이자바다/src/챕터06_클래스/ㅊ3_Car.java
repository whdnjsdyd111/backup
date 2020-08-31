package 챕터06_클래스;

public class ㅊ3_Car {
	int speed;
	
	void run() {
		System.out.println(speed + "km/h로 달립니다.");
	}
	
	public static void main(String[] args) {
		ㅊ3_Car car = new ㅊ3_Car();
		car.speed = 60;
		car.run();
	}
}
