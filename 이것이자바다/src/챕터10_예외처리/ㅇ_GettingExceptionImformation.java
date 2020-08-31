package 챕터10_예외처리;

public class ㅇ_GettingExceptionImformation {
	// try 블록에서 예외가 발생되면 예외 객체는 catch 블록의 매개 변수에서 참조하게 되므로 매개 변수를 이용하면 예외 객체의 정보를 알 수 있다.
	// 모든 예외 객체는 Exception 클래스를 상속하기 때문에 Exception이 가지고 있는 메소드들을 모든 예외 객체에서 호출할 수 있다.
	// 그중에서도 가장 많이 사용되는 메소드는 getMessage()와 printStackTrace()이다. 
	// 예외를 발생시킬 때 다음과 같이 String 타입의 메세지를 갖는 생성자를 이용하였다면, 메세지는 자동적으로 예외 객체 내부에 저장된다.
	
	//	throw new XXXException("예외 메세지");
	
	// 예외 메세지의 내용에는 왜 예외가 발생했는지에 대한 간단한 설명이 포함된다. 좀 더 상세한 원인을 세분화하기 위해 예외 코드를 포함하기도 하는데,
	// 예를 들어 데이터베이스에서 발생한 오류들은 예외 코드가 예외 메세지로 전달된다. 이와 같은 예외 메세지는 다음과 같이 catch 블록에서 getMessage() 메소드의 리턴값으로 얻을 수 있다.
	
	//	} catch(Exception e) {
	//		String message = e.getMessage();
	//	}
	
	// printStackTrace()는 메소드 이름에서도 알 수 있듯이 예외 발생 코드를 추적해서 모두 콘솔에 출력한다. 
	// 어떤 예외가 어디에서 발생했는지 상세하게 출력해주기 때문에 프로그램을 테스트하면서 오류를 찾을 때 활용된다.
	
	//	try {
	//
	//			예외 객체 생성
	//				↓
	//	} catch(예외클래스 e) {
	//		// 예외가 가지고 있는 Message 얻기
	//		String message = e.getMessage();
	//
	//		// 예외의 발생 결로를 추적
	//		e.printStackTrace
	//	}
	
	// 다음 예제 AccountExample 클래스는 Account 클래스를 이용해서 예금과 출금을 한다. 출금할 때 withdraw() 메소드를 사용하므로 예외 처리가 꼭 필요하다.
	// 예외 처리 코드에서 BalanceInsufficientException 객체의 getMessage() 메소드와 printStackTrace() 메소드로 예외에 대한 정보를 얻어내고 있다.
	
	// AccountExample 클래스를 실행하면 콘솔에서 위와 같은 결과를 볼 수 있다 "잔고 부족: 20000 모자람"은 getMessage() 메소드의 리턴값을 출력한 것이다.
	// printStackTrace() 메소드에 의해 출력된 내용을 보면 Account.java 19라인에서 최초로 예외가 발생되어 AccountExample.java 14 라인의 메소드 호출 위치로 예외가 떠넘겨졌음을 볼 수 있다.
}
