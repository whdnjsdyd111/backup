package 챕터08_인터페이스;

public class ㄹ_Using_Interface {
	// 인터페이스로 구현 객체를 사용하려면 다음과 같이 인터페이스 변수를 선언하고 구현 객체를 대입해야한다.
	// 인터페이스 변수는 참조 타입이기 때문에 구현 객체가 대입될 경우 구현 객체의 번지를 저장한다
	
	//	인터페이스 변수;
	//	변수 = 구현객체			|		인터페이스 변수 = 구현객체;
	
	// 예를 들어 RemoteControl 인터페이스로 구현 객체인 Television과  Audio를 사용하려면 다음과 같이 RemoteControl 타입 변수 rc를 선언하고 구현 객체를 대입해야한다.
	
	//	RemoteControl rc;
	//	rc = new Television();
	// 	rc = new Audio();
	
	//	개발 코드에서 인터페이스는 클래스의 필드, 생성자 또는 메소드의 매개 변수, 생성자 또는 메소드의 로컬 변수로 선언될 수 있다.
	
	//	public class 클래스 {
	//		// 필드
	//		RemoteControl rc = new Television();
	//
	//		// 생성자
	//		class(RemoteControl rc) {
	//			this.rc = rc;
	//		}
	//
	//		// 메소드
	//		void methodA() {
	//			// 로컬 변수
	//			RemoteControl rc = new Audio();
	//		}
	//
	//		void methodB(RemoteControl rc) { ... }
	//	}
	
			//	Using Abstract Method	추상 메소드 사용
	
	// 구현 객체가 인터페이스 타입에 대입 되면 인터페이스에 선언된 추상 메소드를 개발 코드에서 호출할 수 있게 된다.
	// 개발 코드에서 RemoteControl의 변수 rc로 turnOn() 또는 turnOff() 메소드를 호출하면 구현 객체의 turnOn()과 turnOff() 메소드가 자동 실행된다.
	
	//	RemoteControl rc = new Television();
	//	rc.turnOn();		// Television의 turnOn() 실행
	//	rc.turnOff();		// Television의 turnOff() 실행
	
			//	Using Default Method	디폴트 메소드 사용
	
	// 디폴트 메소드는 인터페이스에 선언되지만, 인터페이스에서 바로 사용할 수 없다. 디폴트 메소드는 추상 메소드가 아닌 인스턴스 메소드이므로 구현 객체가 있어야 사용할 수 있다.
	// 예를 들어 RemoteControl 인터페이스는 setMute()라는 디폴트 메소드를 가지고 있지만, 이 메소드를 다음과 같이 호출할 수 없다.
	
	//	RemoteControl.setMute(true);
	
	// setMute() 메소드를 호출하려면 RemoteControl의 구현 객체가 필요한데, 다음과 같이 Television 객체를 인터페이스 변수에 대입하고 나서 setMute()를 호출할 수 있다.
	// 비록 setMute()가 Television에 선언되지 않았지만 Television 객체강 ㅓㅄ다면 setMute()도 호출할 수 없다.
	
	//	RemoteControl rc = new Television()
	//	rc.setMute(true);
	
	// 디폴트 메소드는 인터페이스의 모든 구현 객체가 가지고 있는 기본 메소드라고 생각하면 된다. 그러나 어떤 구현 객체는 디폴트 메소드의 내용이 맞지 않아 수정이 필요할 수도 있다.
	// 구현 클래스를 작성할 때 디폴트 메소드를 재정의해서 자신에게 맞게 수정하면 디폴트 메ㅗ드가 호출될 때 자신을 재정의한 메소드가 호출된다.
	// 다음 예제를 보면 Audio는 디폴트 메소드를 재정의했다. Television과 Audio 중 어떤 객체가 인터페이스에 대입되느냐에 따라서 setMute() 디폴트 메소드의 실행 결과는 달라진다.
	
			// Using Static Method
	
	// 인터페이스의 정적 메소드는 인터페이스로 바로 호출이 가능하다. 다음 예제는 RemoteControl의 changeBattery() 정적 메소드를 호출하다.

}
