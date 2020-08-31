package 챕터11_기본API클래스.ㄹ_Objects클래스.ㅁ_객체문자정보toString;

import java.util.Objects;

public class ToString사용 {
	public static void main(String[] args) {
		String str1 = "홍길동";
		String str2 = null;
		
		System.out.println(Objects.toString(str1));
		System.out.println(Objects.toString(str2));
		System.out.println(Objects.toString(str2, "이름이 없습니다"));
		
		// 첫 번째 매개값이 not null이면 toString()으로 얻은 값을 리턴하고,
		// null 이면 "null"또는 두 번째 매개값인 nullDefault를 리턴한다.
	}
}
