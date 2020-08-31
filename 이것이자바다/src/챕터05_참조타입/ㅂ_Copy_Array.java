package 챕터05_참조타입;

public class ㅂ_Copy_Array {
	public static void main(String[] args) {
		
		// 배열은 한번 지정하면 다시는 크기를 늘리거나 줄일수 없기 때문에
		// 더 큰 저장공간이 필요하다면 더 큰 배열을 만들고 거기에 이전 배열 항목들을 복사해야 한다.
		// 복사하는 방법에는 for문을 이용하거나 System.arraycopy() 메소드를 이용하면 된다.
		
		// for문을 이용하는 방법
		
		int[] oldIntArray = { 1, 2, 3 };
		int[] newIntArray = new int[5];
		
		for (int i = 0; i < oldIntArray.length; i++) {
			newIntArray[i] = oldIntArray[i];
		}
		
		for (int i = 0; i < newIntArray.length; i++) {
			System.out.print(newIntArray[i] + ", ");
		}
		
		System.out.println();
		
		//	oldArray	복사 후		newArray
		//	1 2 3					1 2 3 0 0
		
		// System.arraycopy() 메소드를 이용하는 방법
		
		// System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
		// src 원본배열, srcPos 원본 배열에서 복사할 항목의 시작 인덱스, dest 새 배열, destPos 붙여넣을 시작 인덱스, length 복사할 개수
		// 예) System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		
		String[] oldStrArray = { "java", "array", "copy" };
		String[] newStrArray = new String[5];
		
		System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
		
		for (int i = 0; i < newStrArray.length; i++) {
			System.out.print(newStrArray[i] + ", ");
		}
		
		System.out.println();
		
		// 참조 타입일 경우, 배열 복사가 되면 복사되는 값이 객체의 번지이므로 새 배열 항목들은 이전 배열 항목이 참조하는 객체와 동일하다.
		
		System.out.println(oldStrArray[0] == newStrArray[0]); // true
		
		// 이것을 얕은 복사(shallow copy)라고 한다. 반대로 깊은 복사(deep copy)는 참조하는 객체도 별도로 생성하는 것이다.
		
		// 내가 생각하는 깊은 복사
		
		String[] old1 = { "java", "array", "copy" };
		String[] new1 = new String[5];
		
		for (int i = 0; i < old1.length; i++) {
			new1[i] = new String(old1[i]);
		}
		
		for (int i = 0; i < new1.length; i++) {
			System.out.print(new1[i] + ", ");
		}
		
		System.out.println();
		
		System.out.println(new1[0] == old1[0]); // false
	}
}
