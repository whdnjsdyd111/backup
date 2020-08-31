package 챕터10_예외처리;

public class ㅅ_UserDefinedException_CausingException {
	// 프로그램을 개발하다 보면 자바 표준 API에서 제공하는 예외 클래스만으로는 다양한 종류의 예외를 표현할 수 없다.
	// 예를 들어 은행 업무를 처리하는 프로그램에서 잔고보다 더 많은 출금 요청이 들어왔을 경우 오류가 되며, 프로그램은 잔고 부족 예외를 발생시킬 필요가 있다.
	// 그러나 잔고 부족 예외는 자바 표준 API에는 존재하지 않는다. 잔고 부족 예외와 같이 애플리케이션 서비스와 관련된 예외를 애플리케이션 예외(Application Exception)라고 한다.
	// 애플리케이션 예외는 개발자가 직접 정의해서 만들어야 하므로 사용자 정의 예외라고도 한다.
	
			//	Declaration User Defined Exception Class	사용자 정의 예외 클래스 선언
	
	// 사용자 정의 예외 클래스는 컴파일러가 체크하는 일반 예외로 선언할 수 있고, 컴파일러가 체크하지 않는 실행 예외로 선언할 수도 있다.
	// 일반 예외로 선언할 경우 Exception을 상속하면 되고, 실행 예외로 선언할 경우에는 RuntimeException을 상속하면 된다.
	
	//	public class XXXException extends [ Exception | RuntimeException ] {
	//		public XXXException() { }
	// 		public XXXException(String message) { super(message); }
	//	}
	
	// 사용자 정의 예외 클래스 이름은 Exception으로 끝나는 것이 좋다. 사용자 정의 예외 클래스도 필드, 생성자, 메소드 선언들을 포함할 수 있지만 대부분 생성자 선언만을 포함한다.
	// 생성자는 두 개를 선언하느 것이 일반적인데, 하나는 매개 변수가 없는 기본 생성자이고, 다른 하나는 예외 발생 원인(예외 메세지)을 전달하기 위해 String 타입의 매개 변수를 갖는 생성자이다.
	// String 타입의 매개 변수를 갖는 생성자는 상위 클래스의 생성자를 호출하여 예외 메세지를 넘겨준다. 예외 메세지의 용도는 catch {} 블록의 예외 처리 코드에서 이용하기 위해서이다.
	// 다음은 잔고 부족 예외를 사용자 정의 예외 클래스로 선언하는 것이다.
	
			//	Causing Exception	예외 발생시키기
	
	// 사용자 정의 예외 또는 자바 표준 예외를 여러분의 코드에서 발생시키는 방법을 알아보자. 코드에서 예외를 발생시키는 방법은 다음과 같다.
	
	//	throw new XXXException();
	//	throw new XXXException("메세지");
	
	// 예외 객체를 생성할 때는 기본 생성자 또는 예외 메세지를 갖는 생성자 중 어떤 것을 사용해도 된다. 만약 catch 블록에서 예외 메세지가 필요하다면 예외 메세지를 갖는 생성자를 이용해야 한다.
	// 예외 발생 코드를 가지고 있는 메소드는 내부에서 try - catch 블록으로 예외를 처리할 수 있지만, 대부분은 자신을 호출한 곳에서 예외를 처리하도록 throw 키워드로 예외를 떠넘긴다.
	
	//	public void method() throws XXXException {
	//		throw new XXXException("메세지");
	//	}
	
	// 그렇기 때문에 throws 키워드를 포함하고 있는 메소드는 호출한 곳에서 다음과 같이 예외 처리를 해주어야 한다.
	
	//	try {
	//		method();
	//	} catch(XXXException e) {
	//		// 예외 처리
	//	}
	
	// 다음 예제는 은행 계좌 (Account) 클래스를 작성하는 것이다. 출금 (withdraw) 메소드에서 잔고 (balance) 필드와 출금액을 비교해서 잔고가 부족하면 
	// BalanceInsufficientException을 발생시키도록 했다.
	
	
}
