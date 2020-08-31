package 챕터11_기본API클래스.ㅅ_String클래스.ㄴ_String메소드.ㅅ_문자열잘래내기substring;

public class 문자열잘라내기 {
	// substring() 메소드는 주어진 인덱스에서 문자열을 추출한다. substring() 메소드는 매개값의 수에 따라 두 가지 형태로 사용된다.
	// substring(int beginIndex, int endIndex)는 주어진 시작과 끝 인덱스 사이의 문자열을 추출하고,
	// substring(int beginIndex)는 주어진 인덱스부터 끝까지 문자열을 추출한다.
	
	//	String ssn = "980626-1234567";
	//	String firstNum = ssn.substring(0, 6);
	//	String secondNum = ssn.substring(7);
	
	// 상기 코드에서 firstNum 변수값은 "980626"이고, secondNum 변수값은 "1234567"이다. 이해를 돕기위해 그림을 보자.
	
	//	9	8	0	6	2	6	-	1	2	3	4	5	6	7
	//	0	1	2	3	4	5	6	7	8	9	10	11	12	13
	
	// ssn.substring(0, 6)은 인덱스 0(포함)~6(제외) 사이의 문자열을 추출한 것이고,
	// substring(7)은 인덱스 7부터 문자열을 추출한다.
	
	public static void main(String[] args) {
		String ssn = "980626-1234567";
		
		String firstNum = ssn.substring(0, 6);
		System.out.println(firstNum);
		
		String secondNum = ssn.substring(7);
		System.out.println(secondNum);
		
		
	}
}
