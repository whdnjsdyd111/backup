package 챕터11_기본API클래스.ㅅ_String클래스.ㄴ_String메소드.ㄴ_문자열비교equals;

public class 문자열비교 {
	// 기본 타입(byte, char, short, int, long, float, double, boolean) 변수의 값을 비교할 때에는 == 연산자를 이용한다.
	// 그러나 문자열을 비교할 때에는 == 연산자를 사용하면 원하지 않는 결과가 나올 수 있다. 다음 코드를 보며 이해하자.
	
	//	String strVar1 = new String("신민철");
	// 	String strVar2 = "신민철";
	//	String strVar3 = "신민철";
	
	// 자바는 문자열 리터럴이 동일하다면 동일한 String 객체를 참조하도록 되어있다. 그래서 strVar2와 strVar3은 동일한 String 객체를 참조한다.
	// 그러나 strVar1은 new 연산자로 생성된 다른 String 객체를 참조한다.
	
	//	스택 영역						힙 영역
	//
	//	strVar1 ───────────────────>신민철
	//	strVar2 ┐
	//	strVar3	┴──────────────────>신민철
	
	// 이 경우 변수 strVar1과 strVar2의 == 연산은 false를 산출하고 strVar2와 strVar3의 == 연산은 true를 산출한다.
	// == 연산자는 각 변수에 저장된 번지를 비교하기 때문에 이러한 결과가 나온다.
	
	//	strVar1.equals(strVar2) ─> true
	//	strVar2.equals(strVar3) ─> true
	
	// 원래 equals()는 Object의 번지 비교 메소드이지만, String 클래스가 오버라이디애서 문자열을 비교하도록 변경했다.
}
