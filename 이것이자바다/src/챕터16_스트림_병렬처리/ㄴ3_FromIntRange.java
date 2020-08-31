package 챕터16_스트림_병렬처리;

import java.util.stream.IntStream;

public class ㄴ3_FromIntRange {
	
	public static int sum = 0;
	
	public static void main(String[] args) {
		
		IntStream stream = IntStream.rangeClosed(1, 100);
		stream.forEach(a -> sum += a);
		System.out.println("총합: " + sum);
	}
}
