package 챕터11_기본API클래스.ㅅ_String클래스.ㄴ_String메소드.ㄱ_문자추출charAt;

// charAt() 메소드는 매개값으로 주어진 인덱스의 문자를 리턴한다.
// 여기서 인덱스란 0에서부터 "문자열의 길이-1"까지의 번호를 말한다. 다음 코드를 보면서 이해하자.

// String subject = "자바 프로그래밍";
// char charValue = subject.charAt(3);

//	자	바		프	로	그	래	밍
//	0	1	2	3	4	5	6	7

// charAt(3)은 3인덱스 위치에 있는 문자를 말한다. 즉, '프' 문자가 해당된다.
// 다음 예제는 주민등록번호에서 인덱스 7번 문자를 읽어 남자와 여자를 구별한다.

public class StringCharAt사용 {
	public static void main(String[] args) {
		String ssn = "980626-1234567";
		
		char sex = ssn.charAt(7);
		switch(sex) {
		case '1':
		case '3':
			System.out.println("남자 입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자 입니다.");
			break;
		}
	}
}
