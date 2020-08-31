package 챕터11_기본API클래스.ㅋ_Arrays.ㄴ_배열항목비교;

import java.util.Arrays;

// Arrays의 equals()와 deepEquals()는 배열 항목을 비교한다. equals()는 1차 항목의 값만 비교하고,
// deepEqauls()는 1차 항목이 서로 다른 배열을 참조할 경우 중첩된 배열의 항목까지 비교한다. 다음 예제는 배열 복사 후 항목을 비교한다.

public class Equals사용 {
	public static void main(String[] args) {
		int[][] original = { {1,2}, {3,4} };
		
		// 얕은 복사 후 비교
		System.out.println("[얕은 복사후 비교]");
		int[][] cloned1 =  Arrays.copyOf(original, original.length);
		System.out.println("배열 번지 비교: " + original.equals(cloned1));
		System.out.println("1차 배열 항목값 비교: " + Arrays.equals(original, cloned1));
		System.out.println("중첩 배열 항목값 비교: " + Arrays.deepEquals(original, cloned1));
		
		// 깊은 복사 후 비교
		System.out.println("\n[깊은 복사후 비교]");
		int[][] cloned2 = Arrays.copyOf(original, original.length);
		cloned2[0] = Arrays.copyOf(original[0], original[0].length);
		cloned2[1] = Arrays.copyOf(original[1], original[1].length);
		System.out.println("배열 번지 비교: " + original.equals(cloned2));
		System.out.println("1차 배열 항목값 비교: " + Arrays.equals(original, cloned2));
		System.out.println("중첩 배열 항목값 비교: " + Arrays.deepEquals(original, cloned2));
	}
	
	//	[얕은 복사]
	
	//	100번지			200번지
	//	original		Cloned1
	//	300	400			300	400
	//	□	□			□	□┐			equals
	//	│	└────────┐	│	 │	
	//	│			 │	│	 │
	//	│	300번지	┌│──┘	 │	400번지
	//	│			│└┐	 	 │
	//	└─>	□	□ <─┘ └──────┴>	□	□	deepEquals
	//		1	2				3	4
	
	
	//	[깊은 복사]
	
	//	original				Cloned2
	//	100		200				300		400	
	//	□		□				□		□		equals
	//	│		│				│		│			
	//	↓		↓				↓		↓
	//	□	□	□	□			□	□	□	□	deepEqauls
	//	1	2	3	4			1	2	3	4
	//	100 번지	200번지			300번지	400번지
	//
	//
	//
	
	
	

}
