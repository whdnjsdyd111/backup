package 챕터06_클래스;

public class ㅂ1_CarExample {
	public static void main(String[] args) {
		
		// 객체 생성
		ㅂ1_Car car = new ㅂ1_Car();
		
		// 필드값 읽기
		System.out.println("제작회사: " + car.company);
		System.out.println("모델명: " + car.model);
		System.out.println("색깔: "  + car.color);
		System.out.println("최고속도: " + car.maxSpeed);
		System.out.println("현재속도: " + car.speed);
		
		// 필드값 변경
		car.speed = 60;
		System.out.println("수정된 현재속도: " + car.speed);
	}

}
