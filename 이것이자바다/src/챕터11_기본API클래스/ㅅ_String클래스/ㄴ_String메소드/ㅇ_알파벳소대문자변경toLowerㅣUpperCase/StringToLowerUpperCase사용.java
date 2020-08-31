package 챕터11_기본API클래스.ㅅ_String클래스.ㄴ_String메소드.ㅇ_알파벳소대문자변경toLowerㅣUpperCase;

// 다음 예제에서는 두 문자열이 대소문자가 다를 경우 어떻게 비교하는지를 버여준다.
// equals() 메소드를 사용하려면 사전에 toLowerCase()와 toUpperCase()로 대소문자를 맞추어야 하지만,
// equalsIgnoreCase() 메소드를 사용하면 이 작업이 생략된다.

public class StringToLowerUpperCase사용 {
	public static void main(String[] args) {
		String str1 = "Java Programming";
		String str2 = "JAVA Programming";
		
		System.out.println(str1.equals(str2));
		
		System.out.println(str1.equalsIgnoreCase(str2));
		
		String lowerStr1 = str1.toLowerCase();
		String lowerStr2 = str2.toLowerCase();
		System.out.println(lowerStr1.equals(lowerStr2));
	}
}
