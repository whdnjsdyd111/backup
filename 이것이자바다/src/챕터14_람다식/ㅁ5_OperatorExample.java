package é��14_���ٽ�;

import java.util.function.IntBinaryOperator;

public class ��5_OperatorExample {
	private static int[] scores = { 92, 95, 87 };
	
	public static int maxOrMin( IntBinaryOperator operator ) {
		
		int result = scores[0];
		for(int score : scores) {
			result = operator.applyAsInt(result, score);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// �ִ밪 ���
		int max = maxOrMin( (a, b) -> {
			if(a >= b)
				return a;
			else
				return b;
		});
		
		System.out.println("�ִ밪: " + max);
		
		// �ּҰ� ���
		int min = maxOrMin( (a, b) -> {
			if(a >= b)
				return b;
			else
			return a;
		});
		
		System.out.println("�ּҰ�: " + min);
	}
}
