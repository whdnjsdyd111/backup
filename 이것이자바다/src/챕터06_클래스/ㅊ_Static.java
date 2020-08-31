package 챕터06_클래스;

public class ㅊ_Static {
	// 정적( static )은 '고정된' 이란 의미를 가지고 있다. 정적 멤버는 클래스에 고정된 멤버로서 객체를 생성하지 않고 사용할 수 있는 필드와 메소드이다.
	// 이들은 각각 정적 필드, 정적 메소드라고 부른다. 정적 멤버는 객체(인스턴스)에 소속된 멤버가 아니라 클래스에 소속된 멤버이기 때문에 클래스 멤버라고도 한다.
	
			// Declaration Static Member	정적 멤버 선언
	
	// 정적 필드와 정적 메소드를 선언하는 방법은 필드와 메소드 선언 시 static 키워드를 추가적으로 붙이면 된다.
	
	//	public class 클래스 {
	//		// 정적 필드
	//		static 타입 필드 [= 초기값];
	//
	//		// 정적 메소드
	//		static 리턴 타입 메소드 (매개변수, ...) {...}
	//	}
	
	// 정적 필드와 정적 메소드는 클래스에 고정된 멤버이므로 클래스 로더가 클래스(바이트 코드)를 로딩해서 메소드 메모리 영역에서 적재할 때 클래스별로 관리된다.
	// 필드를 선언할 때 인스턴스 필드로 선언할 것인가, 아니면 정적 필드로 선언할 것인가의 판단 기준은 객체마다 가지고 있어야 할 데이터라면 인스턴스 필드로 선언하고,
	// 객체마다 가지고 있을 필요성 없는 공용적인 데이터라면 정적 필드로 선언하는 것이 좋다. 예로 한 클래스에서 원의 넓이나 둘레를 구할 때 필요한 파이는 변하지 않는 공용 데이터이므로 정적 필드가 적절하다.
	// 그러나 객체별로 색깔이 다르다면 색깔은 인스턴스 필드로 선언해야 한다.
	
	//	public class Calculator {
	//		String color;					// 개체마다 색깔이 다를 수 있음
	//		static double pi = 3.14159		// 파이는 변하지 않음
	//	}
	
	// 메소드의 판단 기준은 인스턴스 필드를 이용해서 실행해야 한다면 인스턴스 메소드로 선언하고, 인스턴스 필드를 이용하지 않는다면 정적 메소드로 선언한다.
	// 예를 들어 덧셈, 뺄셈 기능은 인스턴스 필드를 이용하기 보단 외부에서 주어진 매개값들을 가지고 덧셈과 뺄셈을 수행하므로 정적 메소드로 선언하는 것이 좋다.
	// 하지만 색깔과 같은 인스턴스 필드를 사용하는 메소드는 인스턴스 메소드로 선언해야 한다.
	
	//	public class Calculator {
	//		String color;
	//		void setColor(String color) { this.color = color; }
	//		static int plus(int x, int y) { return x + y; }
	//		static int minus(int x, int y) { return x - y; }
	
			// Using Static Member		정적 멤버 사용
	
	// 클래스가 메모리로 로딩되면 정적 멤버를 바로 사용할 수 있는데, 클래스 이름과 함께 도트(.) 연산자로 접근한다.
	
	//	클래스.필드;
	//	클래스.메소드(매개값, ...);
	
	//	public class Calculator {
	//		static double pi = 3.14;
	//		static int plus(int x, int y) {...}
	//		static int minus(int x, int y) {...}
	//	}
	
	// 이와 같이 클래스가 선언되어 있다면 다음과 같이 사용할 수 있다.
	
	//	double result1 = 10 * 10 * Calculator.pi;
	//	int result2 = Calculator.plus(10, 5);
	//	int result3 = Calculator.minus(10, 5);
	
	// 정적 필드와 정적 메소드는 원칙적으로는 클래스 이름으로 접근해야 하지만 다음과 같이 객체 참조 변수로도 접근이 가능하다.
	
	//	Calculator cal = new Calculaotr();
	//	double result1 = 10 * 10 * Calculator.pi;
	//	int result2 = cal.plus(10, 5);
	//	int result3 = cal.minus(10, 5);
	
	// 하지만 정적 요소는 클래스 이름으로 접근하는 것이 좋다. 이클립스에서는 정적 멤버를 클래스 이름으로 접근하지 않고 객체 참조 변수로 접근 했을경우, 경고 표시가 뜬다.
	// 예제 Calculator 를 살펴보자.
	
			// Static Initialization Block 	정적 초기화 블록
	
	// 정적 필드는 다음과 같이 필드 선언과 동시에 초기값을 주는 것이 보통이다.
	
	//	static double pi = 3.14159;
	
	// 근데 계산이 필요한 초기화 작업이 있을 수 있다. 인스턴스 필드는 생성자에서 초기화 하지만, 정적 필드는 객체 생성 없이도 사용해야 하므로 생성자에서 초기화 작업을 할 수 없다.
	// 생성자는 객체 생성 시에만 실행되기 때문이다. 그러면 정적 필드를 위한 초기화 작업은 어디에서 해야할까? 자바는 정적 필드의 복잡한 초기화 작업을 위해서 정적 블록(static block)을 제공한다.
	
	//	static {
	//		...
	//	}
	
	// 정적 블록은 클래스가 메모리로 로딩될 때 자동적으로 실행된다. 정적 블록은 클래스 네부에 여러개가 선언되어도 상관없다. 클래스가 메모리로 로딩될 때 선언된 순서대로 실행된다.
	// 다음 예제 Television을 살펴보자.
	
			// Caution Points For Declare Static Method And Block 정적 메소드와 블록 선언 시 주의할 점
	
	// 정적 메소드와 정적 블록을 선언할 때 주의할 점은 객체가 없어도 실행된다는 특징 때문에, 이들 내부에 인스턴스 필드나 인스턴스 메소드를 사용할 수 없다.
	// 또한 객체 자신의 참조인 this 키워드도 사용이 불가능하다. 그래서 다음 코드는 컴파일 오루가 발생한다.
	
	//	public calss 클래스이름 {
	//		// 인스턴스 필드와 메소드
	//		int field;
	//		void method1() { ... }
	//
	//		// 정적 필드와 메소드
	//		static int field2;
	//		static void method2() { ... }
	//
	//		// 정적 블록
	//		static {
	//			field1 = 10;		// 컴파일 에러
	//			method1();			// 컴파일 에러
	//			field2 = 10;
	//			method2();
	//		}
	//
	//		// 정적 메소드
	//		static void method3 {
	//			this.field1 = 10;	// 컴파일 에러
	//			this.method1();		// 컴파일 에러
	//			field2 = 10;
	//			method2();
	//		}
	//	}
	
	// 정적 메소드와 정적 블록에서 인스턴스 멤버를 사용하고 싶다면 다음과 같이 객체를 먼저 생성하고 참조 변수로 접근해야 한다.
	
	//	static void method3() {
	//		클래스이름 obj = new 클래스이름();
	//		obj.field1 = 10;
	//		obj.method1();
	//	}
	
	// main() 메소드도 동일한 규칙이 적용된다. main() 메소드도 정적(static) 메소드이므로 객체 생성없이 인스턴스 필드와 인스턴스 메소드를 main() 메소드에서 바로 사용할 수 없다.
	// 다음은 잘못 코딩한 것이다.
	
	//	public class Car {
	//		int speed;
	//
	//		void run() {...}
	//
	//		public static void  main(String[] args) {
	//			speed = 60;	// 컴파일 에러
	//			run();		// 컴파일 에러
	//		}
	//	}
	
	// main() 메소드를 올바르게 수정하면 다음과 같다.
	
	//	public static void main(String[] args) {
	//		Car car = new Car();
	//		car.speed = 60;
	//		car.run();
	//	}
	
	// 예제 Car을 실행해보자.
	
			// Singleton	싱글톤
	
	// 가끔 전체 프로그램에서 단 하나의 객체만 만들도록 보장해야 하는 경우가 있는데, 단 하나만 생성된다고 해서 이 객체를 싱글톤(Singleton)이라고 한다.
	// 싱글톤을 만들려면 클래스 외부에서 new 연산자로 생성자를 호출할 수없도록 막아야 한다. 생성자를 호출한 만큼 객체가 생성되기 때문이다.
	// 생성자를 외부에서 호출할 수 없도록 하려면 생성자 앞에 private 접근 제한자를 붙여주면 된다. 그리고 자신의 타입인 정적 필드를 하나 선언하고 자신의 객체를 생성해 초기화 한다.
	// 참고로 클래스 내부에서는 new 연산자로 생성자 호출이 가능하다. 정적 필드도 private 접근 제한자를 붙여 외부에서 필드값을 변경하지 못하도록 막는다.
	// 대신 외부에서 호출할 수 있는 정적 메소드인 getInstance()를 선언하고 정적 필드에서 참조하고 있는 자신의 객체를 리턴해준다. 다음은 싱글톤을 만드는 코드이다.
	
	//	public class 클래스 {
	//		// 정적 필드
	//		private static 클래스 singleton = new 클래스();
	//
	//		// 생성자
	//		private 클래스() {}
	//
	//		// 정적 메소드
	//		static 클래스 getInstance() {
	//			return singleton;
	//		}
	//	}
	
	// 외부에서 객체를 얻는 유일한 방법은 getInstance() 메소드를 호출하는 방법이다. getInstance() 메소드는 단 하나의 객체만 리턴하기 때문에 아래코드 변수1과 변수2는 동일한 객체이다.
	
	//	클래스 변수1 = 클래스.getInstance();
	//	클래스 변수2 = 클래스.getInstance();
	
	// 다음 예제 Singleton을 살펴보자.
}
