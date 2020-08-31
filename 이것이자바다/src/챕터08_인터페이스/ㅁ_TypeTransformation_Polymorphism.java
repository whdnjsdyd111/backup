package 챕터08_인터페이스;

public class ㅁ_TypeTransformation_Polymorphism {
	// 우리는 상속에서 타입 변환과 다형성에 대해 알아보았다. 인터페이스도 다형성을 구현하는 기술이 사용된다. 오히려 요즘은 상속보다는 인터페이스를 통해서 다형성을 구현하는 경우가 더 많다.
	// 다형성은 하나의 타입에 대입되는 객체에 따라서 실행 결과가 다양한 형태로 나오는 성질을 말한다. 부모 타입에 어떤 자식 객체를 대입하느냐에 따라 실행 결과가 달라지듯이, 
	// 인터페이스 타입에 어떤 구현 객체를 대입하느냐에 따라 실행 결과가 달라진다. 상속은 같은 종류의 하위 클래스를 만드는 기술이고, 
	// 인터페이스는 사용 방법이 동일한 클래스를 만드는 기술이라는 개념적 차이점은 있지만 둘 다 다형성을 구현하는 기술임은 틀림없다.
	
	// 프로그램을 개발할 때 인터페이스를 사용해서 메소드를 호출하도록 코딩했다면, 구현 객체를 교체하는 것은 매우 손쉽고 빠르게 할 수 있다.
	// 프로그램 소스 코드는 변함이 없는데, 구현 객체를 교체함으로써 프로그램의 실행 결과가 다양해진다. 이것이 인터페이스의 다형성이다.
	// A 클래스를 이용해서 프로그램을 개발한다고 가정해보자. 개발 완료 후, 전체 프로그램을 테스트해보니 A 클래스에 문제가 있어 원하는 실행 결과가 나오지 않는다.
	// 그래서 B 클래스로 바꾸기로 했다. 하지만 B 클래스의 메소드는 A 클래스의 메소드와 이름, 매개 변수가 다르다. 어쩔 수 없이 A 클래스의 메소드가 사용된 곳을 찾아서 B 클래스의 메소드로 변경해야 한다.
	// 만약 A 클래스와 B 클래스의 메소드 선언부(리턴 타입, 메소드명, 매개 변수)가 동일하다면 어떻게 될까?
	// 메소드 호출 방법이 동일하므로 메소드 호출 코드는 수정할 필요 없이 객체 생성 부분만 A 클래스에서 B 클래스로 바꾸기만 하면된다.
	// 문제는 A, B 클래스를 설계할 때 메소드 선언부를 완전히 동일하게 설계할 수 있느냐다. 이 문제를 해결하려면 인터페이스를 작성하고 A, B 클래스는 구현 클래스로 작성하면 된다.
	
	// 예를 들어 다음과 같이 I 인터페이스를 이용해서 프로그램을 개발하였다. I 인터페이스를 구현한 클래스로 처음에는 A 클래스를 선택한다.
	// 개발 완료 후 테스트를 해보니 A 클래스에 문제가 생겨 다른 클래스를 사용해야 한다. 이런 경우 I 인터페이스를 구현한 B 클래스를 만들고 단 한 줄만 수정해서 프로그램을 재실행할 수 있다.
	
	//	[프로그램]
	//
	//	I i = new A();	( x )				interface I {						구현
	//		↓ 수정								void method1();					 ←		A 클래스
	//	I i = new B();							void method2();					 ←		B 클래스
	//										}									구현
	//	i.method1();						
	//	i.method2();	// 수정이 필요 없음		
	
	// 인터페이스는 메소드의 매개 변수로 많이 등장한다. 인터페이스타입으로 매개 변수를 선언하면 메소드 호출 시 매개값으로 여러 가지 종류의 구현 객체를 줄 수 있기 때문에 메소드 시행 결과가 다양하게 나온다.
	// 이것이 인터페이스 매개 변수의 다형성이다. useRemoteControl() 메소드의 매개 변수가 RemoteControl 인터페이스 타입일 경우, 매개값으로 Television 객체 또는 Audio 객체를 선택적으로 줄 수 있다.
	
	//	public void useRemoteControl( RemoteControl rc ) { ... }
	//										↑
	//								Television, Audio
	
	// 메소드 호출 시 어떤 구현 객체를 매개값으로 주느냐에 따라서 useRemoteControl() 메소드의 실행 결과는 다르게 나온다.
	
			// Auto Type Transformation ( Promotion )		자동 타입 변환 ( Promotion )
	
	// 구현 객체가 인터페이스 타입으로 변환되는 것은 자동 타입 변환(Promotion)에 해당한다. 자동 타입 변환은 프로그램 실행 도중에 자동적으로 타입 변환이 일어나는 것을 말한다.
	
	//	인터페이스 변수 = 구현객체;		// 자동 타입 변환
	
	// 인터페이스 구현 클래스를 상속해서 자식 클래스를 만들었다면 자식 객체 역시 인터페이스 타입으로 자동 타입 변환시킬 수 있다.
	
	
	//				인터페이스
	//				   A					B b = new B();
	//			↗			↖				C c = new C();
	//		구현 클래스		구현 클래스				D d = new D();
	//		   B		   C				E e = new E();
	//										
	//		   ↑		   ↑				A a1 = b;	(가능)
	//										A a2 = c;	(가능)
	//		자식 클래스		자식 클래스				A a3 = d;	(가능)
	//		   D		   E				A a4 = e;	(가능)
	
	// 자동 타입 변환을 이용하면 필드의 다형성과 매개 변수의 다형성을 구현할 수 없다. 필드와 매개 변수의 타입을 인터페이스로 선언하면 여기에 다양한 구현 객체를 대입해서 실행 결과를 다양하게 만들 수 있다.
	
			// Polymorphism Of Field
	
	// 상속에서는 타이어 클래스 타입에 한국 타이어와 금호 타이어라는 자식 객체를 대입해서 교체할 수 있음을 보여주었지만, 이번엔 타이어가 클래스 타입이 아니고 인터페이스라는 점과 한국 타이어는 자식 클래스가 아니라 구현 클래스라는 점이다.
	// 한국 타이어와 금호 타이어는 공통적으로 타이어 인터페이스를 구현했기 때문에 모두 타이어 인터페이스에 있는 메소드를 가지고 있다. 따라서 인터페이스로 동일하게 사용할 수 있는 교체 가능한 객체에 해당한다.
	
	// 자동차를 설계할 때 다음과 같이 필드 타입으로 타이어 인터페이스를 선언하게 되면 필드값으로 한국 타이어 또는 금호 타이어 객체를 대입할 수 있다.
	// 자동 타입 변환이 일어나기 때문에 아무런 문제가 없다.
	
	//	public class Car { 
	//		Tire frontLeftTire = new HankookTire();
	//		Tire frontRightTire = new HankookTire();
	//		Tire backLeftTire = new HankookTire();
	//		Tire backRightTire = new HankookTire();
	//	}
	
	// Car 객체를 생성한 후, 초기값으로 대입한 구현 객체 대신 다른 구현 객체를 대입할 수도 있다. 이것이 타이어 교체에 해당한다.
	
	//	Car car = new Car();
	//	car.frontLeftTire = new KumhoTire();
	//	car.frontRightTire = new KumhoTire();
	
	// frontLeftTire와 frontRightTire에 어떠한 타이어 구현 객체가 저장되어도 Car 객체는 타이어 인터페이스에 선언된 메소드만 사용하므로 전혀 문제가 되지 않는다.
	// 다음은 Car 객체의 run() 메소드에서 타이어 인터페이스에 선언된 roll() 메소드를 호출한다.
	
	//	void run() {
	//		frontLeftTire.roll();
	//		frontRightTire.roll();
	//		backLeftTire.roll();
	//		backRightTire.roll();
	//	}
	
	// frontLeftTire와 frontRightTire를 교체하기 전에는 HankookTire 객체의 roll() 메소드가 호출되지만, KumhoTire로 교체된 후에는 KumhoTire 객체의 roll() 메소드가 호출된다.
	// Car의 run() 메소드 수정 없이도 다양한 roll() 메소드의 실행 결과를 얻을 수 있게 되는 것이다. 이것이 바로 필드의 다형성이다.
	// 다음 예제들을 살펴보고 CarExample 클래스를 실행해서 필드의 다형성을 이해해보자.
	
			//	Managing Implements Objects With Interface Arrays		인터페이스 배열로 구현 객체 관리
	
	// 이전 예제에서는 Car 클래스에서 4개의 타이어 필드를 인터페이스로 각각 선언했지만 다음과 같이 인터페이스 배열로 관리할 수도 있다.
	
	//	Tire[] tires = {
	//		new HankookTire(),
	//		new HankookTire(),
	//		new HankookTire(),
	//		new HankookTire()
	//	};
	
	// frontLeftTire는 tires[0], frontRightTire 는 tires[1], ... 과 같이 인덱스로 표현되므로 대입이나 제어문에서 활요하기 매우 쉽다.
	// 예를 들어 인덱스 1을 이용해서 앞오른쪽 타이어를 KumhoTire로 교체하기 위해 다음과 같이 작성할 수 있다.
	
	//	tires[1] = new KumhoTire();
	
	// tires 배열의 각 항목은 Tire 인터페이스 타입이므로, 구현 객체인 KumhoTire를 대입하면 자동 타입 변환이 발생하기 때문에 아무런 문제가 없다.
	// 구현 객체들을 배열로 관리하면 제어문에서 가장 많이 혜택을 본다. 예를 들어 전체 타이어의 roll() 메소드를 호출하느 Car 클래스의 run() 메소드는 다음과 같이 for문으로 작성할 수 있다.
	
	//	void run() {
	//		for( Tire tire : tires ) {
	//			tire.roll();
	//		}
	//	}
	
	// 다음은 이전 예제에서 작성한 Car 클래스의 타이어 필드를 배열로 나타낸 예제이다.
	
			//	Polymorphism Of Parameter
	
	// 자동 타입 변환은 필드의 값을 대입할 때에도 발생하지만, 주로 메소드를 호출할 때 많이 발생한다. 매개값을 다양화하기 위해서 상속에서는 매개 변수를 부모 타입으로 선언하고 호출할 때에는 자식 객체를 대입했었다.
	// 이번에는 매개 변수를 인터페이스 타입으로 선언하고 호출할 때에는 구현 객체를 대입한다.
	// 예를 들어 다음과 같이 Driver 클래스에는 drive() 메소드가 정의되어 있는데 Vehicle 타입의 매개 변수가 선언되어 있다.
	
	//	public class Driver {
	//		public void drive(Vehicle vehicle) {
	//			vehicle.run();
	//		}
	//	}
	
	// Vehicle을 다음과 같이 인터페이스 타입이라고 가정해보자.
	
	//	public interface Vehicle {
	//		public void run();
	//	}
	
	// 만약 Bus가 구현 클래스라면 다음과 같이 Driver의 drive() 메소드를 호출할 때 Bus 객체를 생성해서 매개값으로 줄 수 있다.
	
	//	Driver driver = new Driver();
	//	Bus bus = new Bus();
	//	driver.drive( bus );	← 자동 타입 변환 발생
	//							Vehicle vehicle = bus;
	
	// drive() 메소드는 Vehicle 타입을 매개 변수로 선언했지만, Vehicle을 구현한 Bus 객체가 매개값으로 사용되면 자동 타입 변환이 발생한다.
	
	//	Vehicle vehicle = bus; 		// 자동 타입 변환
	
	// 매개 변수의 타입이 인터페이스일 경우, 어떠한 구현 객체도 매개값으로 사용할 수 있고, 어떤 구현 객체가 제공되느냐에 다라 메소드의 실행 결과는 다양해질 수 있다. ( 매개 변수의 다형성 )
	
	//				↓ 구현 객체
	//	void run(Vehicle vehicle) {
	//		vehicle.run();		// 구현 객체의 run() 메소드가 실행됨
	//	}
	
	// 다음 예제들을 살펴보고 DriverExample 클래스를 실행해서 매개 변수의 다형성을 이해해보자.
	
			//	Coercion Type Transformation ( Casting )	강제 타입 변환 ( Casting )
	
	// 구현 객체가 인터페이스 타입으로 자동 변환하면, 인터페이스에 선언된 메소드만 사용 가능하다는 제약 사항이 따른다.
	// 예를 들어 인터페이스에는 세 개의 메소드가 선언되어 있고, 클래스에느 다섯개의 메소드가 선언되어 있다면, 인터페이스로 호출 가능한 메소드는 세 개뿐이다.
	
	//		RemoteControl				Television
	//
	//		turnOn();					turnOn() { ... }
	//		turnOff();					turnOff() { ... }
	//		setVolume(int volume);		setVolume(int volume) { ... }		
	//									*위 메소드들만 호출 가능*
	//									setTime(...) { ... }
	//									record(...) { ... }
	
	// 하지만 경우에 따라서는 구현 클래스에 선언된 필드와 메소드를 사용해야 할 경우도 발생한다.
	// 이때 강제 타입 변환을 해서 다시 구현 클래스 타입으로 변환한 다음, 구현 클래스의 필드와 메소드를 사용할 수 있다.
	
	//	구현클래스 변수 = (구현클래스) 인터페이스변수;
	
	//		interface Vehicle {									Vehicle vehicle = new Bus();
	//			void run();										
	//		}													vehicle.run();			(가능)
	//															// vehicle.checkFare();	(불가능)
	//				↑ 구현										
	//															Bus bus = (Bus) vehicle;		// 강제 타입 변환
	//		class Bus implements vehicle {						
	//			void run() {...};								bus.run();				(가능)
	//			void checkFare() {...}							bus.checkFare();		(가능)
	//		}
	
			//	Object Type Verification ( instanceof )		객체 타입 확인 ( instanceof )
	
	// 강제 타입 변환은 구현 객체가 인터페이스 타입으로 변환되어 있는 상태에서 가능하다. 그러나 어떤 구현 객체가 변환되어 있는지 알 수 없는 상태에서 무작정 변환을 할 경우 ClassCastException이 발생할 수도 있다.
	// 예를 들어 다음과 같이 Taxi 객체가 인터페이스로 변환되어 있을 경우, Bus 타입으로 강제 타입 변환하면 구현 클래스 타입이 다르므로 ClassCastException이 발생한다.
	
	//	Vehicle vehicle = new Taxi();
	//	Bus bus = (Bus) vehicle;
	
	// 메소드의 매개 변수가 인터페이스로 선언된 경우, 메소드를 호출할 때 다양한 구현 객체들을 매개값으로 지정할 수 있다(매개 변수의 다형성).
	// 어떤 구현 객체가 지정될지 모르는 상황에서 다음과 같이 매개값을 Bus로 강제 타입 변환하면 ClassCastException이 발생할 수 있다.
	
	//	public void drive(Vehicle vehicle) {
	//		Bus bus = (Bus) vehicle;
	//		bus.checkFare();
	//		vehicle.run();
	//	}
	
	// 그렇다면 어떤 구현 객체가 인터페이스 타입으로 변환되었는지 확인하는 방법은 없을까? 우리는 상속에서 객체 타입을 확인하기 위해 instanceof 연산자를 사용했다.
	// instacneof 연산자는 인터페이스 타입에서도 사용할 수 있다. 예를 들어 Vehicle 인터페이스 타입으로 변환된 객체가 Bus인지 확인하려면 다음과 같이 작성하면 된다.
	
	//	if( vehicle instanceof Bus ) {
	//		Bus bus = ( Bus ) vehicle;
	//	}
	
	// 인터페이스 타입으로 자동 변환된 매개값을 메소드 내에서 다시 구현 클래스 타입으로 강제 타입 변환해야 한다면 반드시 매개값이 어떤 객체인지 instanceof 연산자로 확인하고 안전하게 강제 타입 변환을 해야 한다.
	// 다음과 같이 drive() 메소드에서 매개값이 Bus 객체인 경우, Bus의 checkFare() 메소드를 호출해야 한다면 Bus 타입으로 강제 타입 변환해야 한다.
	// Vehicle 인터페이스에는 checkFare() 메소드가 없기 때문이다. 매개값으로 어떤 구현 객체가 대입될지 모르기 때문에 instanceof 연산자로 Bus 타입인지 꼭 확인해야 한다.
}
