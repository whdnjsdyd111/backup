package 챕터06_클래스;

public class ㅅ3_Car {
	// 필드
	
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	ㅅ3_Car() {
		
	}
	
	ㅅ3_Car(String model){
		this.model = model;
	}
	
	ㅅ3_Car(String model, String color){
		this.model = model;
		this.color = color;
	}
	
	ㅅ3_Car(String model, String color, int maxSpeed){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
