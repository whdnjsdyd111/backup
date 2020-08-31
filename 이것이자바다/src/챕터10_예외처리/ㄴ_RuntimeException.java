package 챕터10_예외처리;

public class ㄴ_RuntimeException {
	// 실행 예외는 자바 컴파일러가 체크를 하지 않기 때문에 오로지 개발자의 경험에 의해서 예외 처리 코드를 삽입해야 한다.
	// 만약 개발자가 실행 예외에 대해 예외 처리 코드를 넣지 않았을 경우, 해당 예외가 발생하면 프로그램은 곧바로 종료된다.
	// 자바 프로그램 개발 경력이 풍부하다면 언제, 어떤 실행 예외가 발생하는지 쉽게 알 수 있지만, 이제 시작하는 개발자라면 지금부터 설명하는 몇 가지 실행 예외를 잘 익혀두길 바란다.
	// 자바 프로그램에서 자주 발생되는 실행 예외이므로 언제 발생되고, 어떤 오류 메세지가 출력되는지 잘 알아둘 필요가 있다.
	
			//	NullPointerException
	
	// 자바 프로그램에서 가장 빈번하게 발생하는 실행 예외는 java.lang.NullPointerException일 것이다.
	// 이것은 객체 참조가 없는 상태, 즉 null 값을 작는 참조 변수로 객체 접근 연산자인 도트(.)를 사용했을 때 발생한다.
	// 객체가 없는 상태에서 객체를 사용하려 했으니 예외가 발생하는 것이다.
	
	// 프로그램에서 예외가 발생하면 예외 메세지가 Console 뷰에 출력되면서 프로그램이 종료된다. Console 뷰에 출력되는 내용에는 어떤 예외가 어떤 소스의 몇 번째 코드에서 발생했느지에 대한 정보가 들어있다.
	// 위 예제의 경우 NullPointerXceptionExample.java 소스의 4번째 코드에서 발생했음을 알 수 있다.
	// Console 뷰에서 밑줄 처리된 NullPointerExceptionExample.jvava:4를 마우ㅠ스로 클릭하면 소스 편집기는 정확히 NullPointerException.java의 4번째 줄을 하이라이팅해준다.
	
			//	ArrayIndexOutOfBoundsException
	
	// 배열에서 인덱스 범위를 초과하여 사용할 경우 실행 예외인 java.lang.ArrayIndexOutOfBoundsException이 발생한다.
	// 예를 들어 길이가 3인 int[] arr = new int[3] 배열을 선언했다면, 배열 항목을 지정하기 위해 arr[0] ~ arr[2]를 사용할 수 있다.
	// 하지만 arr[3]을 사용하면 인덱스 범위를 초과했기 때문에 ArrayIndexOutOfBoundsException이 발생한다.
	
	// 예제를 실행하면 3라인에서 ArrayIndexOutOfBoundsException이 발생한다. 그 이유는 두 개의 실해 매개값을 주지 않았기 때문에 args[0], args[1]과 같이 인덱스를 사용할 수 없다.
	
	// 명령 프롬프트에서 args에 값을 준다면 ArrayIndexOutOfBoundsException이 발생하지 않는 좋은 프로그램이 된다.
	// 배열값을 읽기 전에 배열의 길이를 먼저 조사하는 것이다. 살행 매개값이 부족하거나 없을 경우 조건문을 이용해서 사용자에개 실행 방법을 알려준다.
	
			//	NumberFormatException
	
	// 프로그램을 개발하다 보면 문자열로 되어 있는 데이터를 숫자로 변경하는 경우가 자주 발생한다. 문자열을 숫가로 변환하는 방법은 여러 가지가 있지만 가장 많이 사용되는 코드는 다음과 같다.
	
	//		변환 타입		메소드면(매개 변수)					설명
	//		int			Integer.parseInt(String s)		주어진 문자열을 정수로 뱐환해서 리턴
	//		double		Double.parseDouble(String s)	주어진 문자열을 실수로 변환해서 리턴
	
	// Integer와 Double은 포장 (Wrapper) 클래스라고 하는데, 11장에서 자세히 설명된다. 이 클래스의 정적 메소드인 parseXXX() 메소드를 이용하면 문자열을 숫자로 변환할 수 있다.
	// 이 메소드들은 매개값인 문자열이 숫자로 변환될 수 있다면 숫자를 리턴하지만, 숫자로 변환될 수 없는 문자가 포함되어 있다면 java.lang.NumberFormatException을 발생시킨다.
	
			//	ClassCastException
	
	// 타입 변환(Casting)은 상위 클래스와 하위 클래스 간에 발생하고 구현 클래스와 인터페이스간에도 발생한다. 이러한 관계가 아니라면 클래스는 다른 클래스로 타입 변환할 수 없다.
	// 억지로 타입 변환을 시도할 경우 ClassCastException이 발생한다. 예를 들어 다음과 같이 상속 관계와 구현 관계가 있다고 가정해보자.
	
	//			Animal : 추상클래스					RemoteControl : 인터페이스
	//			┌───────┴───┐						┌───────┴───────┐
	//			↓			↓						↓				↓
	//		Dog				Cat						Television		Audio
	
	// 다음은 올바른 타입 변환을 보여준다. Animal 타입 변수에 대입된 객체가 Dog이므로 다시 Dog 타입으로 변환하느 것은 아무런 문제가 없다.
	// 마찬가지로 RemoteControl 타입 변수에 대입된 객체가 Television이므로 다시 Television 타입으로 변환하는 것은 아무런 문제가 없다.
	
	//	Animal animal = new Dog();		|	RemoteControl rc = new Television();
	//	Dog dog = (Dog) animal;			|	Television tv = (Television) rc;
	
	// 그러나 다음과 같이 타입 변환을 하면 ClassCastException이 발생한다. 대입된 객체가 아닌 다른 클래스 타입으로 타입 변환했기 때문이다.
	
	//	Animal animal = new Dog();		|	RemoteControl rc = new Television();
	//	Cat cat = (Cat) animal;			|	Audio audio = (Audio) rc;
	
	// ClassCastException을 발생시키지 않으려면 타입 변환 전에 타입 변환이 가능한지 instanceof 연산자로 확인하는 것이 좋다.
	// instanceof 연산의 결과가 true이면 좌항 객체를 우항 타입으로 변환이 가능하다는 뜻이다.
	
	//	Animal animal = new Dog();				|	Remocon rc = new Audio();
	//	if(animal instanceof Dog) {				|	if(rc instanceof Television) {
	//		Dog dog = (Dog) animal;				|		Television tv = (Television) rc;
	//	} else if(animal instanceof Cat) {		|	} else if(rc instanceof Audio) {
	//		Cat cat = (Cat) animal;				|		Audio audio = (Audio) rc;
	//	}										|	}
	
	
}
