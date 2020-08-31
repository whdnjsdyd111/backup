package 챕터03_연산자;

public class ㄷ_String_Connect {
	public static void main(String[] args) {
		String First = "JDK" + 3 + 3.0;
		String Second = 3 + 3.0 + "JDK";
		
		// 께산되는 순서를 잘 보아야 한다.
		
		System.out.println(First);
		System.out.println(Second);
	}
}
