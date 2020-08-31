package 챕터11_기본API클래스.ㅅ_String클래스.ㄴ_String메소드.ㅇ_알파벳소대문자변경toLowerㅣUpperCase;

public class 알파벳소대문자변경 {
	// toLowerCase() 메소드는 문자열을 모두 소문자로 바꾼 새로운 문자열을 생성한 후 리턴한다.
	// 반대로 toUpperCase() 메소드는 문자열을 모두 대문자로 바꾼 새로운 문자열을 생성한 후 리턴한다. 다음 코드를 보면서 이해하자.
	
	//	String original = "Java Programming"
	//	String lowerCase = original.toLowerCase();
	//	String upperCase = original.toUpperCase();
	
	// lowerCase 변수는 새로 생성된 "java programming" 문자열을 참조하고
	// upperCase 변수는 새로 생성된 "JAVA PROGRAMMING" 문자열을 참조한다.
	// 원래 "Java Programming" 문자열이 변경된 것은 아니다.
	
	//	스택 영역				힙 영역
	//	original ──────────>Java Programming
	//
	//	lowerCase ─────────>java programming
	//
	//	upperCase ─────────>JAVA PROGRAMMING
	
	// toLowerCase()와 toUpperCase() 메소드는 영어로 된 두 문자열을 대소문자와 관계없이 비교할 때 주로 이용된다.
	
}
