package 챕터11_기본API클래스.ㅋ_Arrays.ㄱ_배열복사;

import java.util.Arrays;

public class ArrayCopy사용 {
	public static void main(String[] args) {
		char[] arr1 = {'J', 'A', 'V', 'A'};
		
		// 방법1
		char[] arr2 = Arrays.copyOf(arr1, arr1.length);
		System.out.println(arr2);
		
		// 방법2
		char[] arr3 = Arrays.copyOfRange(arr1, 0, arr1.length);
		System.out.println(arr3);
		
		// 방법3
		char[] arr4 = new char[arr1.length];
		System.arraycopy(arr1, 0, arr4, 0, arr1.length);
		System.out.println(arr4);
	}
}
