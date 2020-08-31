package 챕터10_예외처리;

public class ㄹ_HandlingCodeAccordingToExceptionType {
			// Multiple catch 다중 catch

	// try 블록 내부는 다양한 종류의 예외가 발생할 수 있다. 이 경우, 발생되는 예외별로 예외 처리 코드를 다르게 하려면 어떻게 해야 할까? 이것에 대한 해답은 다중 catch 블록을 작성하는 것이다.
	// catch 블록의 예외 클래스 타입은 try 블록에서 발생된 예외의 종류를 말하는데, try 블록에서 해당 타입의 예외가 발생하면 catch 블록을 실행하도록 되어 있다.
	
	//	try {
	//		ArrayIndexOutOfBoundsException 발생			┐
	//													│
	//		NumberFormatException 발생	(x)				│
	//													│
	//	} catch(ArrayIndexOutOfBoundsException e) {	←───┘
	//		예외 처리1
	//	} catch(NumberFormatException e) {
	//		예외 처리2
	//	}
	
	// catch 블록이 여러 개라 할지라도 단 하나의 catch 블록만 실행한다. 그 이유는 try 블록에서 동시 다발적으로 예외가 발생하지 않고,
	// 허나의 예외가 발생하면 즉시 실행을 멈추고 해당 catch 블록으로 이동하기 때문이다. 그럼 이제 예제를 살펴보자
	
			//	Procedure catch		catch 순서
	
	// 다중 catch 블록을 작성할 때 주의할 점은 상위 예외 클래스가 하위 예외 클래스보다 아래쪽에 위치해야 한다.
	// try 블록에서 예외가 발생했을 때, 예외를 처리해줄 catch 블록은 위에서부터 차례대로 검색된다. 만약 상위 예외 클래스의 catch 블록이 위에 있다면, 하위 예외 클래스의 catch 블록은 실행되지 않는다.
	// 따라서 다음의 코딩은 잘못된 것이다.
	
	//	try {
	//
	//		ArrayIndexOutOfBoundsException 발생			┐
	//													│
	//		NumberFormatException 발생					│
	//													│
	//	} catch(Exception e) {					←───────┘
	//		예외 처리1
	//	} catch(ArrayIndexOutOfBoundsException e) {		// 실행되지 않음
	//		예외 처리2
	//	}
	
	// ArrayIndexOutOfBoundsException과 NumberFormatException은 모두 Exception을 상속받기 때문에 첫 번째 catch 블록만 선택되어 실행된다.
	// 두 번째 catch 블록은 어떤 경우에라도 실행되지 않는다. 위 코드는 다음과 같이 수정해야 한다.
	
	//	try {
	//
	//		ArrayIndexOutOfBoundsException 발생			┐	
	//													│
	//		NumberFormatException 발생					│
	//													│
	//	} catch(ArrayIndexOutOfBoundsException e) {	←───┘
	//		예외 처리1
	//	} catch(Exception e) {		
	//		예외 처리2
	//	}
	
	// try 블록에서 ArrayIndexOutOfBoundsException이 발생하면 첫 번재 catch 블록을 실행하고, 그 밖의 다른 예외가 발생하면 두 번째 catch 블록을 실행한다.
	
			//	Multiple catch		멀티 catch
	
	// 자바 7 부터 하나의 catch 블록에서 여러 개의 예외를 처리할 수 있도록 멀티 catch 기능을 추가했다.
	// 다음은 멀티 catch 블록을 작성하는 방법을 보여준다. catch 괄호() 안에 동일하게 처리하고 싶은 예외를 |로 연결하면 된다.
	
	//	try {
	//	
	//		ArrayIndexOutOfBoundsException 또는 NumberFormatException 발생			┐
	//																			│
	//		다른 Exception 발생														│
	//																			│
	//	} catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {	←───┘
	//		예외 처리1
	//	} catch(Exception e) {
	//		예외 처리2
	// }
}
