package é��16_��Ʈ��_����ó��;

import java.util.stream.IntStream;

public class ��3_FromIntRange {
	
	public static int sum = 0;
	
	public static void main(String[] args) {
		
		IntStream stream = IntStream.rangeClosed(1, 100);
		stream.forEach(a -> sum += a);
		System.out.println("����: " + sum);
	}
}
