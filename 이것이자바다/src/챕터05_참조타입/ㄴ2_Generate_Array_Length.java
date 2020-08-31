package 챕터05_참조타입;

public class ㄴ2_Generate_Array_Length {
	public static void main(String[] args) {

		// 값을 가지고 있지 않지만, 미리 배열의 길이를 정하여 만들고 싶다면 new 연산자로 다음과 같이 만들 수 있다. 값들은 모두 초기화 된다.

		// 타입[] 변수 = new 타입[길이];

		int[] arr = new int[10];

		// 타입[] 변수 = null;
		// 변수 = new 타입[길이];
		
		int[] arr1 = null;
		arr1 = new int[10];

		// arr1의 값 목록
		// 0 1 2 3 4 5 6 7 8 9
		// 0 0 0 0 0 0 0 0 0 0

		// String 타입일 경우
		// 모두 null 이다.
		
		// 정수와 실수는 모두 0(Long과 Float의 경우 l과 f가 붙음)으로 초기화 되고 boolean은 false, 참조 타입은 모두 null이다.
		
		// 이후에 지정된 배열의 인덱스에 값을 넣을 수 있다.
		
		arr1[0] = 10;
		arr1[1] = 12;

	}
}
