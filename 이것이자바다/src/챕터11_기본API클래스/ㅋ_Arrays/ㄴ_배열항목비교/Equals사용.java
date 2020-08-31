package é��11_�⺻APIŬ����.��_Arrays.��_�迭�׸��;

import java.util.Arrays;

// Arrays�� equals()�� deepEquals()�� �迭 �׸��� ���Ѵ�. equals()�� 1�� �׸��� ���� ���ϰ�,
// deepEqauls()�� 1�� �׸��� ���� �ٸ� �迭�� ������ ��� ��ø�� �迭�� �׸���� ���Ѵ�. ���� ������ �迭 ���� �� �׸��� ���Ѵ�.

public class Equals��� {
	public static void main(String[] args) {
		int[][] original = { {1,2}, {3,4} };
		
		// ���� ���� �� ��
		System.out.println("[���� ������ ��]");
		int[][] cloned1 =  Arrays.copyOf(original, original.length);
		System.out.println("�迭 ���� ��: " + original.equals(cloned1));
		System.out.println("1�� �迭 �׸� ��: " + Arrays.equals(original, cloned1));
		System.out.println("��ø �迭 �׸� ��: " + Arrays.deepEquals(original, cloned1));
		
		// ���� ���� �� ��
		System.out.println("\n[���� ������ ��]");
		int[][] cloned2 = Arrays.copyOf(original, original.length);
		cloned2[0] = Arrays.copyOf(original[0], original[0].length);
		cloned2[1] = Arrays.copyOf(original[1], original[1].length);
		System.out.println("�迭 ���� ��: " + original.equals(cloned2));
		System.out.println("1�� �迭 �׸� ��: " + Arrays.equals(original, cloned2));
		System.out.println("��ø �迭 �׸� ��: " + Arrays.deepEquals(original, cloned2));
	}
	
	//	[���� ����]
	
	//	100����			200����
	//	original		Cloned1
	//	300	400			300	400
	//	��	��			��	�ত			equals
	//	��	��������������������	��	 ��	
	//	��			 ��	��	 ��
	//	��	300����	����������	 ��	400����
	//	��			������	 	 ��
	//	����>	��	�� <���� ����������������>	��	��	deepEquals
	//		1	2				3	4
	
	
	//	[���� ����]
	
	//	original				Cloned2
	//	100		200				300		400	
	//	��		��				��		��		equals
	//	��		��				��		��			
	//	��		��				��		��
	//	��	��	��	��			��	��	��	��	deepEqauls
	//	1	2	3	4			1	2	3	4
	//	100 ����	200����			300����	400����
	//
	//
	//
	
	
	

}
