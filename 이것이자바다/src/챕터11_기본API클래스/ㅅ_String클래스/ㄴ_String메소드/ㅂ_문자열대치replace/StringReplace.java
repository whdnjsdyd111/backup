package 챕터11_기본API클래스.ㅅ_String클래스.ㄴ_String메소드.ㅂ_문자열대치replace;

public class StringReplace {
	public static void main(String[] args) {
		String oldStr = "자바는 객체지향언어 입니다. 자바는 풍부한 API를 지원합니다.";
		String newStr = oldStr.replace("자바", "JAVA");
		System.out.println(oldStr);
		System.out.println(newStr);
	}
}
