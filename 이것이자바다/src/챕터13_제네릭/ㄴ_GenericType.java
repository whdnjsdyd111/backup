package 챕터13_제네릭;

public class ㄴ_GenericType {
	// 제네릭 타입은 타입을 파라미터로 가지는 클래스와 인터페이스를 말한다.
	// 제네릭 타입은 클래스 또는 인터페이스 이름 뒤에 "<>" 부호가 붙고, 사이에 타입 파라미터가 위치한다. 아래 코드에서 타입 파라미터의 이름은 T이다.
	
	//	public class 클래스명<T> { ... }
	//	public interface 인터페이스명<T> { ... }
	
	// 타입 파라미터는 변수명과 동일한 규칙에 따라 작성할 수 있지만, 일반적으로 대문자 알파벳 한 글자로 표현한다.
	// 제네릭 타입을 실제 코드에서 사용하려면 타입 파라미터에 구체적인 타입을 지정해야 한다. 그렇다면 왜 이런 타입 파라미터를 사용해야 할까? 그 이유를 알기 위해 다음 Box 클래스를 살펴보자.
	
	//	public class Box {
	//		private Object object;
	//		public void set(Object object) { this.object = object; }
	//		public Object get() { return object; }
	//	}
	
	// Box 클래스의 필드 타입이 Object인데, Object 타입으로 선언한 이유는 필드에 모든 종류의 객체를 저장하고 싶어서이다. Object 클래스는 모든 자바 클래스의 최상위 조상(부모) 클래스이다.
	// 따라서 자식 객체는 부모 타입에 대입할 수 있다는 성질 때문에 모든 자바 객체는 Object 타입으로 자동 타입 변환되어 저장된다.
	
	//	Object object = 자바의 모든 객체;
	
	// set() 메소드는 매개 변수 타입으로 Object를 사용함으로써 매개값으로 자바의 모든 객체를 받을 수 있게 했고, 받은 ㅁ개값을 Object 필드에 저장시킨다.
	// 반대로 get() 메소드는 Object 필드에 저장된 객체를 Object 타입으로 리턴한다. 만약 필드에 저장된 원래 타입의 객체를 얻으려면 다음과 같이 강제 타입 변환을 해야한다.
	
	//	Box box = new Box();
	//	box.set("hellp");					// String 타입을 Object 타입으로 자동 타입 변환해서 저장
	//	String str = (String) box.get();	// Object 타입을 String 타입으로 강제 타입 변환해서 얻음
	
	// 그럼 예제로 살펴보자.
	
	// 예제와 같이 Object 타입을 사용하면 모든 종류의 자바 객체를 저장할 수 있다는 장점은 있지만, 저장할 때 타입 변환이 발생하고, 읽어올 때에도 타입 변환이 발생한다.
	// 이러한 타입이 빈번해지면 전체 프로그램 성능에 좋지 못한 결과를 가져올 수 있다. 그렇다면 모든 종류의 객체를 저장하면서 타입 변환이 발생하지 않도록 하는 방법이 없을까?
	// 해결책은 제네릭에 있다. 다음은 제네릭을 이용해서 Box 클래스를 수정한 것이다.
	
	//	public class Box<T> {
	//		private T t;
	//		public T get() { return t; }
	//		public void set(T t) { this.t = t; }
	//	}
	
	// 타입 파라미터 T를 사용해서 Object 타입을 모두 T로 대체했다. T는 Box 클래스로 객체를 생성할 때 구체적인 타입으로 변경된다. 예를 들어 다음과 같이 Box 객체를 생성했다고 가정해보자.
	
	//	Box<String> box = new Box<String>();
	
	// 타입 파라미터 T는 String 타입으로 변경되어 Box 클래스의 내부는 다음과 같이 자동으로 재구성된다.
	
	//	public class Box<String> {
	//		private String t;
	//		public void set(String t) { this.t = t; }
	//		public String get() { return t; }
	//	}
	
	// 필드 타입이 String으로 변경되었고, set() 메소드도 String 타입만 매개값으로 받을 수 있게 변경되었다.
	// 그리고 get() 메소드 역시 String 타입으로 리턴하도록 변경되었다. 그래서 다음 코드를 보면 저장할 때 읽어올 때 전혀 타입 변환이 발생하지 않는다.
	
	//	Box<String> box = new Box<String>();
	//	box.set("hello");
	//	String str = box.get();
	
	// 이번에는 다음과 같이 Box 객체를 생성했다고 가정해보자. Integer는 int 값에 대한 객체 타입으로 자바에서 제공하는 표준 API이다.
	
	//	Box<Integer> box = new Box<Integer>();
	
	// 타입 파라미터 T는 Integer 타입으로 변경되어 Box 클래스는 내부적으로 다음과 같이 자동적으로 재구성된다.
	
	//	public class Box<Integer> {
	//		private Integer t;
	//		public void set(Integer t) { this.t = t; }
	//		public Integer get() { return t; }
	//	}
	
	// 필드 타입이 Integer로 변경되었고, set() 메소드도 Integer 타입만 매개값으로 받을 수 있게 변경되었다.
	// 그리고 get() 메소드 역시 Integer 타입으로 리턴하도록 변경되었다. 그래서 다음 코드를 보면 저장할 때와 읽어올 때 전혀 타입 변환이 발생하지 않는다.
		
	//	Box<Integer> box = new Box<Integer>();
	//	box.set(6);				// 자동 Boxing
	//	int value = box.get();	// 자동 UnBoxing
	
	// 이와 같이 제네릭은 클래스를 설계할 때 구체적인 타입을 명시하지 않고, 타입 파라미터로 대체했다가 실제 클래스가 사용될 때 구체적인 타입을 지정함으로써 타입 변환을 최소화시킨다.
	
	
}
