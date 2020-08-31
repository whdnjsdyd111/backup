package é��16_��Ʈ��_����ó��;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ��2_ParallelExample {
	public static void main(String[] args) {
		
		
		List<String> list = Arrays.asList(
			"ȫ�浿", "�ſ��", "���ڹ�",
			"���ٽ�", "�ں���"
		);
		
		// ���� ó��
		Stream<String> stream = list.stream();
		stream.forEach(��2_ParallelExample :: print);
		
		System.out.println();
		
		// ���� ó��
		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(��2_ParallelExample :: print);
	}
	
	public static void print(String str) {
		System.out.println(str + " : " + Thread.currentThread().getName());
	}
}
