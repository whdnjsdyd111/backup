package é��06_Ŭ����;

public class ��3_Car {
	int speed;
	
	void run() {
		System.out.println(speed + "km/h�� �޸��ϴ�.");
	}
	
	public static void main(String[] args) {
		��3_Car car = new ��3_Car();
		car.speed = 60;
		car.run();
	}
}
