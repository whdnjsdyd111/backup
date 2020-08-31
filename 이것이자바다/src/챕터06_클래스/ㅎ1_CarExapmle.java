package 챕터06_클래스;

public class ㅎ1_CarExapmle {
	public static void main(String[] args) {
		ㅎ1_Car car = new ㅎ1_Car();
		
		// 잘못된 속도 변경
		car.setSpeed(-50);
		
		System.out.println("현재 속도: " + car.getSpeed());
		
		// 올바른 속도 변경
		car.setSpeed(60);
		
		System.out.println("현재 속도: " + car.getSpeed());
		
		// 멈춤
		if(!car.isStop()) {
			car.setStop(true);
		}
		
		System.out.println("현재 속도: " + car.getSpeed());
	}
}
