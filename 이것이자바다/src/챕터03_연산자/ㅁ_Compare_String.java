package 챕터03_연산자;

public class ㅁ_Compare_String {
	public static void main(String[] args) {
		
		String str1 = "조원용";
		String str2 = "조원용";
		String str3 = new String("조원용");
		String str4 = "조원용";
		
		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
		System.out.println(str4 == str1);
		
		// 문자열끼리 == 연산자를 사용하면 번지를 비교한다.
		// str1 과 str2 는 같은 "조원용" 번지를 참조하는데 new String으로 새로운 번지를 참조
		System.out.println();
		
		boolean bool1 = str1.equals(str2);
		boolean bool2 = str1.equals(str3);

		System.out.println(bool1);
		System.out.println(bool2);

		// 하지만 equals 메소드를 사용하여 문자열이 같은지 비교해준다.
	}
}
