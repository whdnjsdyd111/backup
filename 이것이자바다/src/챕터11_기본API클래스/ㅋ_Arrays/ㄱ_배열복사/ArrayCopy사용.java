package é��11_�⺻APIŬ����.��_Arrays.��_�迭����;

import java.util.Arrays;

public class ArrayCopy��� {
	public static void main(String[] args) {
		char[] arr1 = {'J', 'A', 'V', 'A'};
		
		// ���1
		char[] arr2 = Arrays.copyOf(arr1, arr1.length);
		System.out.println(arr2);
		
		// ���2
		char[] arr3 = Arrays.copyOfRange(arr1, 0, arr1.length);
		System.out.println(arr3);
		
		// ���3
		char[] arr4 = new char[arr1.length];
		System.arraycopy(arr1, 0, arr4, 0, arr1.length);
		System.out.println(arr4);
	}
}
