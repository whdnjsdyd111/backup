package 챕터11_기본API클래스.ㅊ_정규표현식과Pattern클래스.ㄴ_Pattern클래스;

import java.util.regex.Pattern;

// 정규 표현식으로 문자열을 검증하는 방법을 알아보자. 문자열을 정규 표현식으로 검증하는 기능은 
// java.util.regex.Pattern 클래스의 정적 메소드인 matches() 메소드가 제공한다.
// 첫 번째 매개값은 정규 표현식이고, 두 번째 매개값은 검증할 문자열이다. 검증 후 결과가 boolean 타입으로 리턴된다. 다음 예제는 전화번호와 이메일을 검증하는 코드이다

public class Pattern사용 {
	public static void main(String[] args) {
		String regExp = "(02|010)-\\d{3,4}-\\d{4}"; // 역슬래쉬 \가 특수한 용도로 사용한다는 의미로 \\로 두 개를 사용한다.
		String data = "010-123-4567";
		boolean result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("정규식과 일치합니다.");
		} else {
			System.out.println("정규식과 일치하지 않습니다.");
		}
		
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		data = "angel@naver.com";
		result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("정규식과 일치합니다.");
		} else {
			System.out.println("정규식과 일치하지 않습니다.");
		}
	}
}
