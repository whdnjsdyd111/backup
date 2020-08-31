package 챕터06_클래스;

public class ㅅ2_KoreanExample {
	public static void main(String[] args) {
		ㅅ2_Korean k1 = new ㅅ2_Korean("조원용", "980626-1111111");
		System.out.println(k1.name);
		System.out.println(k1.ssn);
		
		ㅅ2_Korean k2 = new ㅅ2_Korean("용원조", "111111-980626");
		System.out.println(k2.name);
		System.out.println(k2.ssn);
	}
}
