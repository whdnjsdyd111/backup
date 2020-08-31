package é��16_��Ʈ��_����ó��;

import java.util.Arrays;

public class ��1_LoopingExample {
	public static void main(String[] args) {
		
		int[] intArray = { 1, 2, 3, 4, 5 };
		
		System.out.println("[ peek()�� �������� ȣ���� ��� ]");
		Arrays.stream(intArray)
			.filter( a -> a % 2 == 0)
			.peek( n -> System.out.println(n) );	// �������� ����
		
		System.out.println();
		
		System.out.println("[ ���� ó�� �޼ҵ带 �������� ȣ���� ��� ]");
		int total = Arrays.stream(intArray)
			.filter( a -> a % 2 == 0)
			.peek( n -> System.out.println(n) )		// ������
			.sum();									// ���� �޼ҵ�
		System.out.println("����: " + total);		
		
		System.out.println();
		
		System.out.println("[ forEach()�� �������� ȣ���� ��� ]");
		Arrays.stream(intArray)
			.filter( a -> a % 2 == 0)
			.forEach(n -> System.out.println(n) );	// ���� �޼ҵ�� ������
	}
}
