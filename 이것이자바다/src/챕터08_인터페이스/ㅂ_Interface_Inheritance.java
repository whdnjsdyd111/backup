package 챕터08_인터페이스;

public class ㅂ_Interface_Inheritance {
	// 인터페이스도 다른 인터페이스를 상속할 수 있다. 인터페이스는 클래스와는 달리 다중 상속을 허용한다.
	// 다음과 같이 extends 키워드 뒤에 상속할 인터페이스들을 나열할 수 있다.
	
	//	public interface 하위인터페이스 extends 상위인터페이스1, 상위인터페이스2 {...}
	
	// 하위 인터페이스를 구현하는 클래스는 하위 인터페이스의 메소드 뿐만 아니라 상위 인터페이스의 모든 추상 메소드에 대한 실체 메소드를 가지고 있어야 한다.
	// 그렇기 때문에 구현 클래스로부터 객체를 생성하고 나서 다음과 같이 하위 및 상위 인터페이스 타입으로 변환이 가능하다.
	
	//	하위인터페이스 변수 = new 구현클래스(...);
	//	상위인터페이스1 변수 = new 구현클래스(...);
	//	상위인터페이스2 변수 = new 구현클래스(...);
	
	// 하위 인터페이스로 타입 변환이 되면 상, 하위 인터페이스에 선언된 모든 메소드를 사용할 수 있으나, 상위 인터페이스로 타입 변환되면 상위 인터페이스에 선언된 메소드만 사용 가능하고
	// 하위 인터페이스에 선언된 메소드는 사용할 수 없다. 예를 들어 아래와 같이 인터페이스가 상속 관계에 있다고 가정하자.
	
	//		interface A					interface B
	//		methodA()					methodB()
	//			↑							↑
	//			└───────────┬───────────────┘
	//						│
	//					interfaceC
	//					methodC()
	
	// InterfaceC 인터페이스 변수는 methodA(), methodB(), methodC()를 모두 호출할 수 있지만, 
	// InterfaceA와 InterfaceB는 각각 methodA()와 methodB()만 호출할 수 있다. 다음 예제를 살펴보자.
}
