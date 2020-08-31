package 챕터07_상속;

public class ㅅ_TransformationType_Polymorphism {
	// 다형성은 같은 타입이지만 실행 결과가 다양한 객체를 이용할 수 있는 성질을 말한다.
	// 코드 측면에서 보면 다형성은 하나의 타입에 여러 객체를 대입함으로써 다양한 기능을 이용할 수 있도록 해준다.
	// 즉 부모 타입에 모든 자식 객체가 대입될 수 있다. 이것을 이용하면 객체는 부품화가 가능하다.
	// 예를 들어 자동차를 설계할 때 타이어 클래스 타입을 적용했다면 이 클래스를 상속한 실제 타이어들은 어떤 것이든 상관없이 장착이 가능하다.
	
	// 타입 변환이란 데이터 타입을 다른 데이터 타입으로 변환하는 행위를 말한다. 기본 타입의 변환에 대해 이미 학습을 했는데 클래스 타입도 마찬가지로 타입 변환이 있다.
	// 클래스 타입의 변환은 상속 관계에 있는 클래스 사이에서 발생한다. 자식 타입은 부모 타입으로 자동 타입 변환이 가능하다.
	
	// 예로 Tire 클래스의 자식 클래스인 HonkookTire과 KumhoTire가 있다.
	
	//	public class Car {
	//		Tire t1 = new HankookTire();
	//		Tire t2 = new KumhoTire();
	//	}
	
	// 다음을 보면 자식 클래스를 부모 타입으로 선언하였는데 HankookTire와 KumhoTire는 Tire을 상속했기 때문이다.
	
			// Auto Type Transformation ( Promotion )		자동 타입 변환 ( Promotion )
	
	// 자동 타입 변환(Promotion)은 프로그램 실행 도중에 자동적으로 타입 변환이 일어나는 것을 말한다. 자동 타입 변환은 다음과 같은 조건에서 일어난다.
	
	//	부모클래스 변수 = 자식클래스타입;
	
	// 자동 타입 변환의 개념은 자식의 부모의 특징과 기능을 상속받기 때문에 부모와 동일하게 취급될 수 있다는 것이다.
	// 예를 들어 고양이는 동물의 특징과 기능을 상속받았다. 그래서 "고양이는 동물이다."가 성립한다. Animal과 Cat 클래스가 다음과 같이 상속관계에 있다고 보자.
	
	//	class Animal	{...}
	//	class Cat extends Animal	{...}
	
	// Cat 클래스로부터 Cat 객체를 생성하고 이것을 Animal 변수에 대입하면 자동 타입 변환이 일어난다.
	
	//	Cat cat = new Cat();
	//	Animal animal = cat;		// 	Animal animal = new Cat(); 도 가능
	
	// 위 코드로 생성되는 메모리 상태를 다음과 같이 묘사할 수 있다. cat과 animal 변수는 타입만 다를 뿐, 동일한 Cat 객체를 참조한다.
	
	//		스택(stack) 영역		힙(heap) 영역
	//
	//		cat, animal →		Cat		→	Animal
	//									상속
	
	// animal 변수가 Animal 타입이므로 당연히 부모인 Animal 객체를 참조하는 것이 맞지 않느냐고 생각할 수도 있지만, 사실 그렇지 않다.
	// 다음과 같이 cat과 animal 변수를 == 연산해보면 true가 나오는데, 참조 변수의 == 연산은 참조 주소값이 같을 경우 true를 산출하므로 두 변수가 동일한 객체를 참조하고 있다는 뜻이다.
	
	// cat == animal	// true
	
	// 바로 위의 부모가 아니더라도 상속 계층에서 상위 타입이라면 자동 타입 변환이 일어날 수 있다. 다음을 보고 이해하자.
	
	//		┌────	A	────┐
	//		B				C
	//		↓				↓
	//		D				E
	
	// D 객체는 B와 A 타입으로 자동 변환이 될 수 있고, E 객체는 C와 A타입으로 자동 변환이 될 수 있다. 그러나 D 객체는 C 타입으로 변환될 수 없고,
	// 마찬가지로 E 객체는 B 타입으로 변환될 수 없다. 이유는 상속 관계가 아니기 때문이다.
	// 다음 예제 PromotionExample을 보고 이해하자.
	
	// 부모 타입으로 자동 타입 변환된 이후에는 부모 클래스에 선언된 필드와 메소드만 접근이 가능하다.
	// 비록 변수는 자식 객체를 참조하지만 변수로 접근 가능한 멤버는 부모 클래스 멤버로만 한정된다. 그러나 예외가 있는데, 메소드가 자식 클래스에서 오버라이딩되었다면 자식 클래스의 메소드가 대신 호출된다.
	// 이것은 다형성(Polymorphism)과 관련이 있기 때문에 매우 중요한 성질이므로 잘 알아두어야 한다 다음 예제 Parent와 Child를 살펴보자.
	
			//	Polymorphism Of Field	필드의 다형성
	
	// 그렇다면 자동 타입 변환이 왜 필요할까? 그것은 다형성을 구현하는 기술적 방법이기 때문이다. 다형성이란 동일한 타입을 사용하지만 다양한 결과가 나오는 성질을 말한다.
	// 주로 필드의 값을 다양화함으로써 실행 결과가 다르게 나오도록 구현하는데, 필드의 타입은 변함이 없지만, 실행 도중에 어떤 객체를 필드로 저장하느냐에 따라 실행 결과가 달라질 수 있다. 이것이 필드의 다형성이다.
	// 자동차를 구성하는 부품은 언제든지 교체할 수 있다. 부품은 고장 날 수도 있고, 보다 더 성능이 좋은 부품으로 교체되기도 한다. 객체 지향 프로그램에서도 마찬가지다.
	// 프로그램은 수많은 객체들이 서로 연결되고 각자의 역할을 하게 되는데, 이 객체들은 다른 객체로 교체될 수 있어야 한다. 예를 들어 자동차 클래스에 포함된 타이어 클래스를 생각해보자.
	// 자동차 클래스를 처음 설계할 때 사용한 타이어 객체는 언제든지 성능이 좋은 다른 타이어 객체로 교체할 수 있어야 한다. 새로 교체되는 타이어 객체는 기존 타이어와 사용 방법은 동일하지만 실행 결과는 더 우수하게 나와야 할 것이다.
	// 이것을 프로그램으로 구현하기 위해서는 상속과 오버라이딩, 그리고 타입 변환을 이용하는 것이다. 부모 클래스를 상속하는 자식 클래스는 부모가 가지고 있는 필드와 메소드를 가지고 있으니 사용 방법이 동일할 것이고,
	// 자식 클래스는 부모의 메소드를 오버라이딩(재정의)해서 메소드의 실행 내용을 변경함으로써 더 우수한 실행 결과가 나오게 할 수 있다. 그리고 자식 타입을 부모 타입으로 변환할 수 있다. 다음 필드이 다형성을 코드로 이해해보자.
	
	//	class Car {
	//		// 필드
	//		Tire frontLeftTire = new Tire();
	//		Tire frontRightTire = new Tire();
	//		Tire backLeftTire = new Tire();
	//		Tire backRightTire = new Tire();
	//	
	//		// 메소드
	//		void run() {...}
	//	}
	
	// Car 클래스는 4개의 Tire 필드를 가지고 있다. Car 클래스로부터 Car 객체를 생성하면 4개의 Tire 필드에 각각 하나씩 Tire 객체가 들어가게 된다. 그런데, frontRightTire와 backLeftTire를
	// HankookTire와 KumhoTire로 교체할 필요성이 생겼다. 이러한 경우 다음과 같은 코드를 사용해서 교체할 수 있다.
	
	//	Car car = new Car();
	//	car.frontRightTire = new HankookTire();
	//	car.backLeftTire = new KumhoTire();
	//	car.run();
	
	// Tire 클래스 타입인 frontRightTire와 backLeftTire는 원래 Tire 객체가 저장되어야 하지만, Tire의 자식 객체가 저장되어도 문제가 없다.
	// 왜냐하면 자식 타입은 부모 타입으로 자동 타입 변환되기 때문이다. frontRightTire와 backLeftTire에 Tire 자식 객체가 저장되어도 Car 객체는 Tire 클래스에 선언된 필드와 메소드만 사용하므로 전혀 문제가 되지 않는다.
	// HankookTire와 KumhoTire는 부모인 Tire의 필드와 메소드를 가지고 있기 때문이다. Car 객체에 run() 메소드가 있고, run() 메소드는 각 Tire 객체의 roll() 메소드를 다음과 같이 호출한다고 가정해보자.
	
	//	void run() {
	//		frontLeftTire.roll();
	//		frontRightTire.roll();
	//		backLeftTire.roll();
	//		backRightTire.roll();
	//	}
	
	// frontRightTire와 backLeftTire를 교체하기 전에는 Tire 객체의 roll() 메소드가 호출되지만, HankookTire와 KumhoTire로 교체된 후에는 
	// HankookTire와 KumhoTire 객체의 roll() 메소드가 호출된다. 만약 HankookTire와 KumhoTire가 roll() 메소드를 재정의 했다면 재정의된 roll() 메소드가 호출된다.
	// 이 성질은 이미 살펴보았는데 이와 같이 자동 타입 변환을 이용해서 Tire 필드값을 교체함으로써 Car의 run() 메소드 수정 없이도 다양한 roll() 메소드의 실행 결과를 얻게 된다. 이것이 바로 필드의 다형성이다.
	
	// 예제를 살펴보면서 이해하자. Tire 클래스에는 최대 회전수(maxRotation), 누적 회전수(accumulatedRotation), 타이어의 위치(location)가 있다.
	// 최대 회전수는 타이어의 수명, 누적 회전수는 1번 회전할 때마다 1씩 증가되는 필드, 타이어의 위치는 앞왼,앞오른,뒤왼,뒤오른쪽을 구분하는 필드이다.
	// Tire 클래스의 생성자는 타이어의 위치와 최대 회전수를 매개값으로 받아 각각의 필드에 저장한다. roll() 메소드는 타이어를 1회전시키는 메소드로 1번 실행할 때마다 누적 회전수를 1씩 증가시킨다.
	// 그런 다음 누적 회전수가 최대 회전수보다 작을 때에는 남은 회전수를 출력하고, 최대 회전수가 되면 펑크를 출력시킨다. roll() 메소드의 리턴 타입은 boolean인데, 정상 회천하면 true를 펑크 나면 false를 리턴한다.
	
			//	Manage Objects In One Array		하나의 배열로 객체 관리
	
	// 이전 예제에서 Car 클래스에 4개의 타이어 객체를 4개의 필드로 각각 저장했다. 우리는 동일한 타입의 값들은 배열로 관리하는 것이 유리하다는 것을 알고 있다.
	// 그렇다면 타이어 객체들도 타이어 배열로 관리하는 것이 코드를 깔끔하게 만들어줄 것이다.
	
	//	class Car {
	//		Tire frontLeftTire = new Tire("앞왼쪽", 6);
	//		Tire frontRightTire = new Tire("앞오른쪽", 2);		
	//		Tire backLeftTire = new Tire("뒤왼쪽", 3);
	//		Tire backRightTire = new Tire("뒤오른쪽", 4);
	//	}
	//					↓
		//
	//	class Car {
	//		Tire[] tires = {
	//			new Tire("앞왼쪽", 6),
	//			new Tire("앞오른쪽", 2),
	//			new Tire("뒤왼쪽", 3),
	//			new Tire("뒤오른쪽", 4)
	//		};
	//	}
	
	// frontLeftTire는 tires[0], frontRightTire는 tires[1], backLeftTire는 [2], backRightTire는 [3]과 같이 인덱스로 표현되므로 대입이나 제어문에서 활용하기 매우 쉽다.
	// 예를 들어 인덱스 1을 이용해서 앞오른쪽 타이어를 KumhoTire로 교체하기 위해 다음과 같이 작성할 수 있다.
	
	//	tires[1] = new KumhoTire("앞오른쪽", 13);
	
	// tire 배열의 각 항목은 Tire 타입이므로 자식 객체인 KumhoTire를 대입하면 자동 타입 변환이 발생하기 때문에 아무런 문제가 없다. 배열의 타입은 Tire이지만 실제 저장 항목이 Tire의 자식 객체라면 모두 가능하다.
	// 상속 관계에 있는 객체들은 배열로 관리하면 제어문에서 가장 많이 혜택을 본다. 전체 타이어의 roll() 메소드를 호출하는 Car 클래스의 run() 메소드는 다음과 같이 for문을 작성할 수 있다.
	
	//	int run() {
	//		System.out.println("[자동차가 달립니다.]");
	//		for(int i = 0; i < tires.langth; i++) {
	//
	//			if( tires[i].roll() == false){
	//
	//			stop();
	//			return (i + 1);
	//
	//			}
	//		}
	//
	//		return 0;
	//	}
	
	// 다음은 이전 예제에서 작성한 Car 클래스의 타이어 필드를 배열로 수정한 전체 내용을 보여준다.
	
			// Polymorphism Of Parameter	매개 변수의 다형성
	
	// 자동 타입 변환은 필드의 값을 대입할 때에도 발생하지만, 주로 메소드를 호출할 때 많이 발생한다.
	// 메소드를 호출할 때에는 매개 변수의 타입과 동일한 매개값을 지정하는 것이 정석이지만, 매개값을 다양화하기 위해 매개 변수의 변수에 자식 타입 객체를 지정할 수도 있다.
	// 예를 들어 다음과 같이 Driver라는 클래스가 있다. Driver 클래스에는 drive() 메소드가 정의되어 있는데 Vehicle 타입의 매개 변수가 선언되어 있다.
	
	//	class Driver {
	//		void drive(Vehicle vehicle) {
	//			vehicle.run();
	//		}
	//	}
	
	// drive 메소드를 정상저긍로 호출한다면 다음과 같을 것이다.
	
	//	Driver driver = new Driver();
	//	Vehicle vehicle = new Vehicle();
	//	driver.drive(vehicle);
	
	// 만약 Vehicle의 자식 클래스인 Bus 객체를 drive() 메소드의 매개값으로 넘겨준다면 어떻게 될까?
	
	//	Driver driver = new Driver();
	//
	//	Bus bus = new Bus();
	//	
	//	driver.drive( bus );
	//				   ↓
	//				자동 타입 변환 발생
	//				Vehicle vehicle = bus;
	
	// drive() 메소드는 Vehicle 타입을 매개 변수로 선언했지만, Vehicle을 상속받는 Bus 객체가 매개값으로 사용되면 자동 타입 변환이 발생한다.
	
	//	Vehicle vehicle = bus; 		자동 타입 변환
	
	// 우리는 여기서 매우 중요한 것을 하나 알게 되었다. 매개 변수의 타입이 클래스일 경우, 해당 클래스의 객체뿐만 아니라 자식 객체까지도 매개값으로 사용할 수 있다는 것이다.
	// 매개값으로 어떤 자식 객체가 제공되느냐에 따라 메소드의 실행 결과는 다양해질 수 있다.( 매개 변수의 다형성 ). 
	// 자식 객체가 부모의 메소드를 재정의(오버라이딩)했다면 메소드 내부에서 오버라이딩된 메소드를 호출함으로써 메소드의 실행 결과는 다양해진다.
	
	//	void drive(Vehicle vehicle) {	// 매개 변수로 자식 객체를 넣는다면
	//		vehicle.run();				// 자식 객체가 재정의한 run() 메소드 실행
	//	}
	
	// 다음 예제를 Vehicle과 Bus를 살펴보자.
	
			//	Coercion Type Transformation ( Casting )	강제 타입 변환 ( Casting )
	
	// 강제 타입 변환(Casting)은 부모 타입을 자식 타입으로 변환하는 것을 말한다. 그렇다고 해서 모든 부모 타입을 자식 클래스 타입으로 강제 타입 변환할 수 있는 것은 아니다.
	// 자식 타입이 부모 타입으로 자동 변환 후, 다시 자식 타입으로 변환할 때 강제 타입 변환을 사용할 수 있다.
	
	//	자식클래스 변수 = ( 자식클래스 ) 부모클래스타입;
	//								↑
	//						자식 타입이 부모 타입으로 변환된 상태
	
	// 자식 타입이 부모 타입으로 자동 변환하면, 부모 타입에 선언된 필드와 메소드만 사용 가능하다는 제약 사항이 따른다.
	// 만약 자식 타입에 선언된 필드와 메소드를 꼭 사용해야 한다면 강제 타입 변환을 해서 다시 자식 타입으로 변환한 다음 자식 타입의 필드와 메소드를 사용하면 된다.
	
	// 다음 예제 Parent와 Child를 살펴보자.
	
			//	Object Type Verification ( instanceof )		객체 타입 확인 ( instanceof )
	
	// 강제 타입 변환은 자식 타입이 부모 타입으로 변환되어 있는 상태에서만 가능하기 때문에 다음과 같이 부모 타입의 변수가 부모 객체를 참조할 경우 자식 타입으로 변환할 수 없다.
	
	//	Parent parent = new Parent();
	//	Child child = ( Child ) parent;		// 강제 타입 변환을 할 수 없다.
	
	// 그렇다면 부모 변수가 참조하는 객체가 부모 객체인지 자식 객체인지 확인하는 방법은 없을까?
	// 어떤 객체가 어떤 클래스의 인스턴스인지 확인하려면 instanceof 연산자를 사용할 수 있다.
	// instanceof 연산자의 좌항은 객체가 오고, 우항은 타입이 오는데, 좌항의 객체가 우항의 인스턴스이면 즉 우항의 타입으로 객체가 생성되었다면 true를 산출하고 그렇지 않으면 false를 산출한다.
	
	//	boolean	reuslt = 좌항(객체) instanceof 우항(타입)
	
	// instanceof 연산자는 매개값의 타입을 조사할 때 주로 사용된다.
	// 메소드 내에서 강제 타입 변환이 필요할 경우 반드시 매개값이 어떤 객체인지 instanceof 연산자로 확인하고 안전하게 강제 타입 변환을 해야 한다.
	
	//	public void method(Parent parent) {
	//		if(parent instanceof Child) {
	//			Child child = (Child) parent;
	//		}
	//	}
	
	// 만약 타입을 확인하지 않고 강제 타입 변환을 시도한다면 ClassCastException 예외가 발생할 수 있다. 다음 예제를 보자.
	// InstanceofExample 클래스에서 method1()과 method2()는 모두 Parent 타입의 매개값을 받고록 선언했다.
	
	// 예제의 method1() 메소드와 같이 강제 타입 변환을 하기전에 instanceof 연산자로 변환시킬 타입의 객체인지 조사해서 잘못된 매개갑승로 인해 프로그램이 종료되는 것을 막아야 한다.
	
}
