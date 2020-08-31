package é��16_��Ʈ��_����ó��;

import java.util.Arrays;
import java.util.List;

public class ��1_ReductionExample {
	public static void main(String[] args) {
		
		List<��1_Student> list = Arrays.asList(
			new ��1_Student("ȫ�浿", 92),
			new ��1_Student("�ſ��", 95),
			new ��1_Student("���ڹ�", 88)
		);
		
		int sum1 = list.stream()		// sum() �̿�
				.mapToInt(��1_Student :: getScore)
				.sum();
		
		int sum2 = list.stream()		// reduce(BinaryOperator<Integer> ap) �̿�
				.map(��1_Student :: getScore)
				.reduce( (a, b) -> a + b )
				.get();
		
		int sum3 = list.stream()		// reduce(int identity, IntBinaryOperator) �̿�
				.map(��1_Student :: getScore)
				.reduce(0, (a, b) -> a + b);
		
		System.out.println("sum1 = " + sum1);
		System.out.println("sum2 = " + sum2);
		System.out.println("sum3 = " + sum3);
	}
}
