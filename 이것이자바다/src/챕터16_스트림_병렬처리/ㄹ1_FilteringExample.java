package é��16_��Ʈ��_����ó��;

import java.util.Arrays;
import java.util.List;

public class ��1_FilteringExample {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("ȫ�浿", "�ſ��", "���ڹ�", "�ſ��", "�Ź�ö");
		
		list.stream()
			.distinct()			// �ߺ� ����
			.forEach( n -> System.out.println(n) );
		System.out.println();
		
		list.stream()
			.filter( n -> n.startsWith("��") )		// ���͸�
			.forEach( n -> System.out.println(n) );
		System.out.println();
		
		list.stream()
			.distinct()								// �ߺ� ���� �� ���͸�
			.filter( n -> n.startsWith("��") )
			.forEach( n -> System.out.println(n) );
		System.out.println();
	}
}
