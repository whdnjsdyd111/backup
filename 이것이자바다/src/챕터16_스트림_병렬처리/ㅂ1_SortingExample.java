package é��16_��Ʈ��_����ó��;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class ��1_SortingExample {
	public static void main(String[] args) {
		
		// ���� ���
		IntStream intStream = Arrays.stream(new int[] { 5, 3, 2, 1, 4 });
		intStream
			.sorted()
			.forEach(n -> System.out.print(n + ", ") );
		System.out.println();
		
		// ��ü ���
		List<��1_Student> list = Arrays.asList(
			new ��1_Student("ȫ�浿", 30),
			new ��1_Student("�ſ��", 10),
			new ��1_Student("���̼�", 20)
		);
		
		list.stream()
			.sorted()
			.forEach(s -> System.out.print(s.getScore() + ", ") );
		
		System.out.println();
		
		list.stream()
			.sorted( Comparator.reverseOrder() )
			.forEach( s -> System.out.print(s.getScore() + ", ") );
	}
}
