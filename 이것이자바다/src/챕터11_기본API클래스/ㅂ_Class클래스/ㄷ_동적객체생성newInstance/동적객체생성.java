package 챕터11_기본API클래스.ㅂ_Class클래스.ㄷ_동적객체생성newInstance;

public class 동적객체생성 {
	// Class 객체를 이용하면 new 연산자를 사용하지 않아도 동적으로 객체를 생성할 수 있다.
	// 이 방법은 코드 작성 시에 클래스 이름을 결정할 수 없고, 런타임 시에 클래스 이름이 결정되는 경우에 매우 유용하게 사용된다.
	// 다음 코드처럼 Class.forName() 메소드로 Class 객체를 얻은 다음 newInstance() 메소드를 호출하면 Object 타입의 객체를 얻을 수 있다.
	
	//	try {
	//		Class clazz = Class.forName("런타입 시 결정되는 클래스 이름");
	//		Object obj = clazz.newInstance();
	//	} catch(ClassNotFoundException e) {
	//	} catch(InstantiationException e) {
	//	} catch(IllegalAccessException e) {
	//	}
	
	// newInstance() 메소드는 기본 생성자를 호출해서 객체를 생성하기 때문에 반드시 클래스에 기본 생성자가 존재해야 한다.
	// 만약 매개 변수가 있는 생성자를 호출하고 싶다면 리플렉션으로 Constructor 객체를 얻어 newInsctance() 메소드를 호출하면 된다.
	// newInstance() 메소드는 두 가지 예외가 발생할 수 있는데,
	// InstantiationException 예외는 해당 클래스가 추상 클래스이거나 인터페이스일 경우에 발생하고,
	// IllegalAccessException 예외는 클래스나 생성자가 접근 제한자로 인해 접근할 수 없을 경우에 발생한다. 따라서 예외 처리 코드가 필요하다.
	
	// newInstance() 메소드의 리턴 타입은 Object이므로 이것을 원래 클래스 타입으로 변환해야만 메소드를 사용할 수 있다.
	// 그렇게 하기 위해서는 강제 타입 변환을 해야하는데, 클래스 타입을 모르는 상태이므로 변환 할 수가 없다. 이 문제를 해결하려면 인터페이스 사용이 필요하다.
	// 예를 들어 Action 인터페이스와 구현 클래스인 SendAction, ReceiveAction이 있다고 가정해보자.
	
	//									<<interface>> -execute() 메소드
	//									   Action		
	//					구현									구현
	//			┌────────────────────────────┴──────────────────────────────┐															|
	//			|															|
	//		SendAction													ReceiveAction
	//		- execute()													- execute()
	//		     실체 메소드													      실체 메소드
	
	// Class.forName() 메소드의 매개값으로 "SendAction" 또는 "ReceiveAction"을 주면 Class 객체가 만들어지고,
	// Class 객체의 newInstance() 메소드로 Object 객체를 얻을 수 있다.
	// 얻어진 객체는 모두 Action 인터페이스를 구현하고 있기 때문에 다음과 같이 Action 인터페이스 타입으로 변환이 가능하다.
	// 그런 다음, Action 인터페이스의 execute() 메소드를 호출하면, 개별 클래스의 실체 메소드인 execute() 메소드가 실행된다.
	
	//	Class clazz = Class.forName("SendAction" 또는 "ReceiveAction");
	//	Action action = (Action) clazz.Instance();
	//	action.execute(); <───────────────────────────────────SendAction 또는 ReceiveAction의 execute()가 실행됨
	
	// Class.forName() 메소드의 매개값으로 "SendAction" 문자열을 주었다면 SendAction 클래스의 execute() 메소드가 호출되고,
	//                       매개값으로 "ReceiveAction" 문자열을 주었다면 ReceiveAction 클래스의 execute() 메소드가 호출된다.
	
	//						┌─────> SendAction의 execute() 호출
	//	action.execute(); ──┤
	//						└─────> ReceiveAction의 execute() 호출
	
}
