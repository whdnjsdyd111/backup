package 챕터05_참조타입;

public class ㄷ_Using_Array_Argument {
	public static void main(String[] args) {

		if (args.length != 2) { // 입력된 데이터 개수가 두 개가 아닐 경우
			System.out.println("프로그램 사용법");
			System.out.println("java MainStringArrayArgument num1 num2");
			System.exit(0); // 프로그램 종료
		}

		String str1 = args[0];
		String str2 = args[1];

		int num1 = Integer.parseInt(str1); // 문자열을 숫자로 바꾸는 메소드
		int num2 = Integer.parseInt(str2);

		int result = num1 + num2;

		System.out.println(num1 + " + " + num2 + " = " + result);
	}
}
