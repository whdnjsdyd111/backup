package 챕터07_상속;

public class ㅇ2_AnimalExample {
	public static void main(String[] args) {
		
		// 객체 선언
		
		ㅇ2_Dog dog = new ㅇ2_Dog();
		ㅇ2_Cat cat = new ㅇ2_Cat();
		dog.sound();
		cat.sound();
		
		System.out.println("---------------");
		
		// 변수의 자동 타입 변환
		
		ㅇ2_Animal animal = null;
		
		animal = new ㅇ2_Dog();
		animal.sound();
		animal = new ㅇ2_Cat();
		animal.sound();
		
		System.out.println("---------------");
		
		// 메소드의 다형성
		animalSound(new ㅇ2_Dog());		// 자동 타입 변환
		animalSound(new ㅇ2_Cat());		// 자동 타입 변환
	}									//	↓
	
	public static void animalSound(ㅇ2_Animal animal) {
		animal.sound();		// 재정의된 메소드 호출
	}
}
