package 챕터08_인터페이스;

public class ㅅ_DefaultMethod_InterfaceExtension {
	// 디폴트 메소드은 인터페이스에 선언된 인스턴스 메소드이기 때문에 구현 객체가 있어야 사용할 수 있다.
	// 선언은 인터페이스에서 하고, 사용은 구현 객체를 통해 한다는 것이 어색해 보인다.
	// 디폴트 메소드는 모든 구현 객체에서 공유하는 기본 메소드처럼 보이지만, 사실은 인터페이스 에서 디폴트 메소드를 허용한 다른 이유가 있다.
	
			// 	Necessity Of Default Method		디폴트 메소드의 필요성
	
	// 인터페이스에서 디폴트 메소드를 허용한 이유는 기존 인터페이스를 확장해서 새로운 기능을 추가하기 위해서이다.
	// 기존 인터페이스의 이름과 추상 메소드의 변경 없이 디폴트 메소드만 추가할 수 있기 때문에 이전에 개발한 구현 클래스를 그대로 사용할 수 있으면서 새롭게 개발하는 클래스는 디폴트 메소드를 활용할 수 있다.
	
	// 아래를 보고 이해하자. 기존에 myInterface라는 인터페이스와 이를 구현한 ClassA라는 클래스가 있다. 시간이 흘러 MyInterface에 기능을 추가해야할 필요성이 생겼다.
	// 그래서 MyInterface에 추상 메소드를 추가했는데, ClassA에 문제가 발생한다. 그 이유는 추가된 추상 메소드에 대한 실체 메소드가 ClassA에 없기 때문이다.
	// ClassA를 수정할 여건이 안된다면 결국 MyInterface에 추상 메소드를 추가할 수 없다. 그래서 MyInterface에 디폴트 메소드를 선언한다.
	// 디폴트 메소드는 추상 메소드가 아니기 때문에 구현 클래스에서 실체 메소드를 작성할 필요가 없다. 따라서 ClassA는 아무런 문제없이 계속 사용이 가능하다.
	
	//					MyInterface		-	method1()					// 기존 추상 메소드
	//						↑			-	default method2() {...}		// 디폴트 메소드 추가
	//			↗					↖
	//	기존 구현 클래스				새로운 구현 클래스
	//	(그대로 사용 가능)			(디폴트 메소드를 활용)
	//
	//	ClassA					ClassB
	//	- method1() {...}		- method1() {...}
	//							- method2() {...}

	// 수정된 MyInterface를 구현한 새로운 클래스인 ClassB는 method1()의 내용은 반드시 채워야 하지만, 디폴트 메소드인 method2()는 yInterface에 정의된 것을 사용해도 되고,
	// 필요에 따라 재정의해서 사용할 수도 있다. 다음 예제는 지금까지 설명한 것을 코드로 표현했다.
	
			//	Interface Inheritance Having Default Method		디폴트 메소드가 있는 인터페이스 상속
	
	// 인터페이스 간에도 상속이 있다는 것을 이미 학습했었다. 부모 인터페이스에 디폴트 메소드가 정의되어 있을 경우, 자식 인터페이스에서 디폴트 메소드를 활용하는 방법은 다음 세 가지가 있다.
	
	//	-	디폴트 메소드를 단순히 상속만 받는다.
	//	-	디폴트 메소드를 재정의(Overriding)해서 실행 내용을 변경한다.
	//	-	디폴트 메소드를 추상 메소드로 재선언한다.
	
	// 다음 예제들을 바로 살펴보자.추상 메소드와 디폴트 메소드가 선언된 ParentInterface가 있다고 가정하자.
	// 그리고 ChildInterface1은 ParentInterface를 상속하고 자신의 추상 메소드인 method3()을 선언한다.
	// 이런 경우 ChildInterface1 인터페이스를 구현하는 클래스는 method1()과 method3()의 실체 메소드를 가지고 있어야 하며 ParentInterface의 method2()를 호출할 수 있다.
	
	//	ChildInterface1 ci1 = new ChildInterface1() {
	//		@Override
	//		public void method1() { // 실행문 }
	//		@Override
	//		public void method3() { // 실행문 }
	//	};
	//
	//	ci1.method1();
	//	ci1.method2();		// ParentInterface의 method2() 호출
	//	ci1.method3();
	
	// 다음 ChildInterface2는 ParentInterface를 상속하고 ParentInterface의 디폴트 메소드인 method2()를 재정의한다. 그리고 자신의 추상 메소드인 method3()을 선언한다.
	// 이 경우도 ChildInterface2 인터페이스를 구현하는 클래스는 method1()과 method3()의 실체 메소드를 가지고 있어야하며, ChildInterface2에서 재정의한 method2()를 호출할 수 있다.
	
	//	ChildInterface2 ci2 = new ChildInterface2() {
	//		@Override
	//		public void method1() { // 실행문 }
	//		@Override
	//		public void method3() { // 실행문 }
	//	};
	//
	//	ci2.method1();
	//	ci2.method2();		// ChildInterface2의 method2() 호출
	//	ci2.method3();
	
	// 다음은 ChildInterface3은 ParentInterface를 상속하고 ParentInterface의 디폴트 메소드인 method2()를 추상 메소드로 재선언한다. 그리고 자신의 추상 메소드인 method3()을 선언한다.
	// 이 경우 ChildInterface3 인터페이스를 구현하는 클래스는 method1()과 method2(), method3()의 실체 메소드를 모두 가지고 있어야 한다.
	
	//	ChildInterface3 ci3 = new ChildInterface3() {
	//		@Override
	//		public void method1() { /* 실행문 */ }
	//		@Override
	//		public void method2() { /* 실행문 */ }
	//		@Override
	//		public void method3() { /* 실행문 */ }
	//	};
	//
	//	ci3.method1();
	//	ci3.method2();		// ChildInterface3의 method2() 호출
	//	ci3.method3();
}
