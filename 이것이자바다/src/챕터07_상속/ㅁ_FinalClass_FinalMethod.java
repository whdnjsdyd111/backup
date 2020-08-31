package 챕터07_상속;

public class ㅁ_FinalClass_FinalMethod {
	// final 키워드는 클래스, 필드, 메소드 선언 시에 사용할 수 있다. final 키워드는 해당 선언이 최종 상태이고, 결코 수정될 수 없음을 뜻한다.
	// final 키워드가 클래스, 메소드 선언에 사용될 경우 해석이 조금씩 달라지는데, 
	// 우리는 이미 6장에서 배웠듯 final 필드에 대해 보았듯이 필드 선언 시에 final이 지정되면 초기값 설정 후, 더 이상 값을 변경할 수 없다는 것을 알았다.
	// 클래스와 메소드 선언시에 final 키워드가 지정되면 상속과 관련있다.
	
			//	Not inheritable final Class		상속할 수 없는 final 클래스
	
	// 클래스를 선언할 때 final 키워드를 class 앞에 붙이게 되면 이 클래스는 최종적인 클래스이므로 상속할 수 없는 클래스가 된다.
	// 즉 final 클래스는 부모 클래스가 될 수 없어 자식 클래스를 만들 수 없다는 것이다.
	
	//	public final class 클래스 {...}
	
	// final 클래스의 대표적인 예는 자바 표준 API에서 제공하는 String 클래스이다. String 클래스는 다음과 같이 선언되어 있다.
	
	//	public final class String {...}
	
	// 그래서 다음과 같이 자식 클래스를 만들 수 없다.
	
	//	public NewString (X)extends String {...}
	
	// 다음 예제는 Member 클래스 선언 시 final을 지정함으로써 Member를 상속해서 VeryVeryImportantPerson을 선언할 수 없음을 보여준다.
	
			//	Not Overriding final Method	오버라이딩할 수 없는 final 메소드
	
	// 메소드를 선언할 때 final 키워드를 붙이게 되면 이 메소드는 최종적인 메소드이므로 오버라이딩(Overriding)할 수 없는 메소드가 된다.
	// 즉 부모 클래스를 상속해서 자식 클래스를 선언할 때 부모 클래스에 선언된 final 메소드는 자식 클래스에서 재정의할 수 없다는 것이다.
	
	//	public final 리턴타입 메소드( [매개변수, ...] ) {...}
	
	// 다음 예제는 Car 클래스의 stop() 메소드를 final로 선언해서 Car를 상속한 SportsCar 클래스에서 stop() 메소드를 오버라이딩할 수 없음을 보여준다.
}
