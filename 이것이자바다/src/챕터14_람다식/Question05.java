package 챕터14_람다식;

import java.util.function.IntBinaryOperator;

public class Question05 {
	private static int[] scores = { 10, 50, 3 };
	
	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for(int score : scores) {
			result = operator.applyAsInt(result, score);
		}
		return result;
	}
	
	public static void main(String[] args) {
		// 최댓값 얻기
		int max = maxOrMin(
			(a, b) -> {
				if(a <= b)
					a = b;
				return a;
			}
		);
		System.out.println("최댓값: " + max);
		
		// 최소값 얻기
		int min = maxOrMin(
			(a, b) -> {
				if(a >= b)
					a = b;
				return a;
			}
		);
		System.out.println("최소값: " + min);
	}
	
	
}
