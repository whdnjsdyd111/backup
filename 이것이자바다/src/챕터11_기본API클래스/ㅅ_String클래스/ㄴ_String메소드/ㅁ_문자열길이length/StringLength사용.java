package 챕터11_기본API클래스.ㅅ_String클래스.ㄴ_String메소드.ㅁ_문자열길이length;

// length() 메소드는 문자열의 길이(문자의 수)를 리턴한다. 다음 코드를 보며 이해해보자.

//	String subject = "자바 프로그래밍";
//	int length = subject.length();

// length 변수에는 8이 저장된다. subject 객체의 문자열 길이는 공백을 포함해서 8개이기 때문이다.

//	자	바		프	로	그	래	밍
//	0	1	2	3	4	5	6	7
//	└───────────────────────────┘
//			     총 8문자

public class StringLength사용 {
	public static void main(String[] args) {
		String ssn = "9806261234567";
		int length = ssn.length();
		
		if(length == 13) {
			System.out.println("주민번호 자리수가 맞습니다.");
		} else {
			System.out.println("주민번호 자리수가 틀립니다.");
		}
	}
}
