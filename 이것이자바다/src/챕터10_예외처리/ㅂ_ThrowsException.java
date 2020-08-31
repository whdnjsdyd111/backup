package 챕터10_예외처리;

public class ㅂ_ThrowsException {
	// 메소드 내부에서 예외가 발생할 수 있는 코드를 작성할 때 try - catch 블록으로 예외를 처리하는 것이 기본이지만, 경우에 따라서는 메소드를 호출한 곳으로 예외를 떠넘길 수고 있다.
	// 이때 사용하는 키워드가 throws이다. throws 키워드는 메소드 선언부 끝에 작성되어 메소드에서 처리하지 않은 예외를 호출한 곳으로 떠넘기는 역할을 한다.
	// throws 키워드 뒤에는 떠넘길 예외 클래스를 쉼표로 구분해서 나열해주면 된다.
	
	//	리턴타입 메소드명(매개변수, ...) throws 예외클래스1, 예외클래스2, ... {
	//	}
	
	// 발생할 수 있는 예외는 종류별로 throws 뒤에 나열하는 것이 일반적이지만, 다음과 같이 throws Exception만으로 모든 예외를 간단히 떠넘길 수 있다.
	
	//	리턴타입 메소드명(매개변수, ...) throws Exception {
	//	}
	
	// throws 키워드가 붙어있는 메소드는 반드시 try 블록 내에서 호출되어야 한다. 그리고 catch 블록에서 떠넘겨 받은 예외를 처리해야 한다.
	// 다음 코드는 throws 키워드가 있는 method2()를 method1()에서 호출하는 방법을 보여준다.
	
	//	public void method1() {
	//
	//		try {
	//			method2();
	//		} catch(ClassNotFoundException e) {
	//			// 예외 처리 코드
	//			System.out.println("클래스가 존재하지 않습니다.");
	//		}
	//	}
	//
	//	public void method2() throws ClassNotFoundException {
	//		Class clazz = Class.forName("java.lang.String2");
	//	}
	
	// method1()에서도 try - catch 블록으로 예외를 처리하지 않고 throws 키워드로 다시 예외를 떠넘길 수 있다.
	// 그러면 method1()을 호출하는 곳에서 결국 try - catch 블록을 사용해서 예외를 처리해야 한다.
	
	//	public void method1() throws ClassNotFoundException {
	//		method2();
	//	}
	
	// 자바 API 도큐먼트를 보면 클래스 생성자와 메소드 선언부에 throws 키워드가 붙여있는 것을 흔히 볼 수 있다. 이러한 생성자와 메소드를 사용하고 싶다면 try - catch 블록으로 예외 처리를 해야한다.
	// 아니면 throws를 다시 사용해서 호출한 곳으로 떠넘겨야 한다. 그렇지 않으면 컴파일 오류가 발생한다. 예를 들어 Class의 forName() 메소드를 자바 API 도큐먼트에서 보면 다음과 같다.
	
	//	forName
	//			public static Class<?> forName(String className)
	//											throws ClassNotFoundException
	
	// forName() 메소드 선언부 뒤에 throws ClassNotFoundException 이 붙어 있기 때문에 forName() 메소드를 호출할 때  try - catch 블록으로 예외를 처리하거나,
	// throws로 예외를 떠넘겨야 한다. 다음 예제에서 Class.forName() 메소드를 사용하는 findClass() 메소드는 예외를 떠넘겼고, findClass()를 호출하는 main() 메소드에서
	// try - catch 블록을 사용해서 예외를 처리했다.
	
	// main() 메소드에서도 throws 키워드를 사용해서 예외를 떠넘길 수 있는데, 결국 JVM이 최종적으로 예외 처리를 하게 된다.
	// JVM은 예외의 내용을 콘솔(Console)에 출력하는 것으로 예외 처리를 한다.
	
	//	public static void main(String[] args) throws ClassNotFoundException {
 	//		findClass();
	//	}
	
	// main() 메소드에서 throws Exception을 붙이는 것은 좋지 못한 예외 처리 방법이다.
	// 프로그램 사용자는 프로그램이 알 수 없는 예외 내용을 출력하고 종료되는 것을 좋아하지 않는다. 그렇기 때문에 main()에서 try - catch 블록으로 예외를 최종 처리하는 것이 바람직 하다.
}
