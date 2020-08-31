package 챕터06_클래스;

public class ㅇ3_CarExample {
	public static void main(String[] args) {
		ㅇ3_Car car = new ㅇ3_Car();
		
		car.setGas(5);	// car 의 setGas() 메소드 호출
		
		boolean gasState = car.isLeftGas();	// car 의 isLeftGas() 메소드 호출
		
		if(gasState) {
			System.out.println("출발합니다");
			car.run();	// car의 run() 메소드 호출
			
		}
		
		if(car.isLeftGas()) {	// car의 isLeftGas() 메소드 호출
			System.out.println("gas를 주입할 필요가 없습니다.");
		} else {
			System.out.println("gas를 주입하세요.");
		}
	}
}
