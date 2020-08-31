package 챕터11_기본API클래스.ㅅ_String클래스.ㄴ_String메소드.ㅂ_문자열대치replace;

public class 문자열대치 {
	// replace() 메소드는 첫 번째 매개값인 문자열을 찾아 두 번째 매개값인 문자열로 대치한 새로운 문자열을 생성하고 리턴한다. 다음 코드를 보면서 이해하자.
	
	//	String oldStr = "자바 프로그래밍";
	// 	String newStr = oldStr.replace("자바", "JAVA");
	
	// String 객체의 문자열은 변경이 불가한 특성을 갖기 때문에 replace() 메소드가 리턴하는 문자열은 원래의 문자열의 수정본이 아니라 완전히 새로운 문자열이다.
	// 따라서 newStr 변수는 다음 그림과 같이 새로 생성된 "JAVA 프로그래밍" 문자열을 참조한다.
	
	//	스택 영역				힙 영역
	//
	//	oldStr	───────────>"자바 프로그래밍"
	//
	//	newStr	───────────>"JAVA 프로그래밍"
	
}