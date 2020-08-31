package 챕터05_참조타입;

public class ㄴ1_Generate_Array_Ways {
	public static void main(String[] args) {

		// 타입[] 변수;

		int[] Array;

		// Array = { 값1, 값2, 값3 }; 컴파일 에러

		// 변수 = new 타입[] { 값1, 값2, 값3, ... };

		Array = new int[] { 1, 2, 3 }; // 배열을 추가할 수 없으므로 새로운 참조를 만들어 배열을 지정해야 한다.

		String[] str = null;

		str = new String[] { "값1", "값2", "값3" };

	}
}
