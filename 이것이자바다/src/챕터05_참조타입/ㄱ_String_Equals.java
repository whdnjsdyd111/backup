package 챕터05_참조타입;

public class ㄱ_String_Equals {
	public static void main(String[] args) {
		
		String str1 = "조원용";
		String str2 = "조원용";
		
		if(str1 == str2)
			System.out.println("str1과 str2는 번지수가 같음");
		else
			System.out.println("str1과 str2는 번지수가 다름");
		
		if(str1.equals(str2))
			System.out.println("str1과 str2는 문자열이 같음");
		else
			System.out.println("str1과 str2는 문자열이 다름");
		
		String str3 = new String("조원용");
		String str4 = new String("조원용");
		
		if(str3 == str4)
			System.out.println("str3과 str4는 번지수가 같음");
		else
			System.out.println("str3과 str4는 번지수가 다름");
		
		if(str3.equals(str4))
			System.out.println("str3과 str4는 문자열이 같음");
		else
			System.out.println("str3과 str4는 문자열이 다름");
		
		String hobby = "여행";
		
		System.out.println();
		
		hobby = null;	// 참조가 쓰레기값으로 변함
		
		System.out.println(hobby);
		
	}
}
