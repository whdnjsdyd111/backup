package 챕터11_기본API클래스.ㅅ_String클래스.ㄴ_String메소드.ㅊ_문자열변환valueOf;

// valueOf() 메소드는 기본 타입의 값을 문자열로 변환하는 기능을 가지고 있다.
// String 클래스에는 매개 변수의 타입별로 valueOf() 메소드가 다음과 같이 오버로딩되어 있다.
//	static String valueOf(boolean b | char c | int i | long l | double d | float f)

public class StringValue {
	public static void main(String[] args) {
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(10.5);
		String str3 = String.valueOf(true);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}
}
