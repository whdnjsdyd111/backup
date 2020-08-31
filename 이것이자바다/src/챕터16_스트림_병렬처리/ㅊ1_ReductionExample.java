package 챕터16_스트림_병렬처리;

import java.util.Arrays;
import java.util.List;

public class ㅊ1_ReductionExample {
	public static void main(String[] args) {
		
		List<ㅊ1_Student> list = Arrays.asList(
			new ㅊ1_Student("홍길동", 92),
			new ㅊ1_Student("신용권", 95),
			new ㅊ1_Student("김자바", 88)
		);
		
		int sum1 = list.stream()		// sum() 이용
				.mapToInt(ㅊ1_Student :: getScore)
				.sum();
		
		int sum2 = list.stream()		// reduce(BinaryOperator<Integer> ap) 이용
				.map(ㅊ1_Student :: getScore)
				.reduce( (a, b) -> a + b )
				.get();
		
		int sum3 = list.stream()		// reduce(int identity, IntBinaryOperator) 이용
				.map(ㅊ1_Student :: getScore)
				.reduce(0, (a, b) -> a + b);
		
		System.out.println("sum1 = " + sum1);
		System.out.println("sum2 = " + sum2);
		System.out.println("sum3 = " + sum3);
	}
}
