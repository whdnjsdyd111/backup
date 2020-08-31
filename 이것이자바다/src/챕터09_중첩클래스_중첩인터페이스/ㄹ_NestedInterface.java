package 챕터09_중첩클래스_중첩인터페이스;

public class ㄹ_NestedInterface {
	// 중첩 인터페이스는 클래스의 멤버로 선언된 인터페이스를 말한다. 인터페이스를 클래스 내부에 선언하는 이유는 해당 클래스와 긴밀한 관계를 맺는 구현 클래스를 만들기 위해서이다.
	// 특히 UI 프로그래밍에서 이벤트를 처리할 목적으로 많이 활용한다.
	
	//	class A {
	//		interface I {
	//			void method();
	//		}
	//	}
	
	// 예를 들어 Button을 클릭했을 때 이벤트를 처리하는 객체를 받고 싶다고 가정해보자. 그렇다고 아무 객체나 받으면 안 되고,
	// Button 내부에 선언된 중첩 인터페이스를 구현한 객체만 받아야 한다면 다음과 같이 Button 클래스를 선언하면 된다.
	
	// 다음 예제를 살펴보자.
	
	// Button을 살펴보면 중첩 인터페이스(OnClickListener) 타입으로 필드(listener)를 선언하고 Setter 메소드(setOnClickListener())로 구현 객체를 받아 필드에 대입한다.
	// 버튼 이벤트가 발생했을 때 (touch() 메소드가 실행했을 때) 인터페이스를 통해 구현 객체의 메소드를 호출(listener.onClick())한다. 이 다음 예제는 OnClickListener를 구현한 두 개의 클래스륿 보여준다.
}
