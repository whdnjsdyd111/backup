package 챕터06_클래스;

public class ㅈ_InstanceAndThis {
	
	// 인스턴스 멤버란 객체를 생성한 후 사용할 수 있는 필드와 메소드를 말하는데, 이들을 각각 인스턴스 필드, 인스턴스 메소드라 부른다.
	
	//	public class Car {
	//		// 필드
	//		int gas;
	//
	//		// 메소드
	//		void setSpeed(int speed) {...}
	//	}
	
	// gas 필드와 setSpeed() 메소드는 인스턴스 멤버이기 때문에 외부 클래스에서 사용하기 위해서는 우선 Car객체를 생성하고 참조변수 car1 또는 car2로 접근해야 한다.
	
	//	Car car1 = new Car();
	//	car1.gas = 10;
	//	car1.setSpeed(60);
	//
	//	Car car2 = new Car();
	//	car2.gas = 10;
	//	car2.setSpeed(60);
	
	// 위 코드는 시행된 후 각각 인스턴스 필드 gas는 객체마다 따로 존재하고, 인스턴스 메소드인 setSpeed는 객체마다 존재하지 않고, 메소드 영역에 저장되고 공유된다.
	// 객체 외부에서 인스턴스 멤버에 접근하기 위해 참조 변수를 사용하는 것과 마찬가지로 객체 내부에서도 인스턴스 멤버에 접근하기 위해 this를 사용할 수 있다.
	// 생성자와 메소드의 매개 변수 이름이 필드와 동일한 경우, 인스턴스 멤버인 필드임을 명시하고자 할 때 사용한다. 다음은 매개 변수 model의 값을 필드 model에 저장한다.
	
	//	Car(String model) {
	//		this.model = model;
	//	}
	//
	//	void setModel(String model) {
	//		this.model = model;
	//	}
	
	// 예제 Car을 살펴보자.
}
