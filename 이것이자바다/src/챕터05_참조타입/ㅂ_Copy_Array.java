package é��05_����Ÿ��;

public class ��_Copy_Array {
	public static void main(String[] args) {
		
		// �迭�� �ѹ� �����ϸ� �ٽô� ũ�⸦ �ø��ų� ���ϼ� ���� ������
		// �� ū ��������� �ʿ��ϴٸ� �� ū �迭�� ����� �ű⿡ ���� �迭 �׸���� �����ؾ� �Ѵ�.
		// �����ϴ� ������� for���� �̿��ϰų� System.arraycopy() �޼ҵ带 �̿��ϸ� �ȴ�.
		
		// for���� �̿��ϴ� ���
		
		int[] oldIntArray = { 1, 2, 3 };
		int[] newIntArray = new int[5];
		
		for (int i = 0; i < oldIntArray.length; i++) {
			newIntArray[i] = oldIntArray[i];
		}
		
		for (int i = 0; i < newIntArray.length; i++) {
			System.out.print(newIntArray[i] + ", ");
		}
		
		System.out.println();
		
		//	oldArray	���� ��		newArray
		//	1 2 3					1 2 3 0 0
		
		// System.arraycopy() �޼ҵ带 �̿��ϴ� ���
		
		// System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
		// src �����迭, srcPos ���� �迭���� ������ �׸��� ���� �ε���, dest �� �迭, destPos �ٿ����� ���� �ε���, length ������ ����
		// ��) System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		
		String[] oldStrArray = { "java", "array", "copy" };
		String[] newStrArray = new String[5];
		
		System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
		
		for (int i = 0; i < newStrArray.length; i++) {
			System.out.print(newStrArray[i] + ", ");
		}
		
		System.out.println();
		
		// ���� Ÿ���� ���, �迭 ���簡 �Ǹ� ����Ǵ� ���� ��ü�� �����̹Ƿ� �� �迭 �׸���� ���� �迭 �׸��� �����ϴ� ��ü�� �����ϴ�.
		
		System.out.println(oldStrArray[0] == newStrArray[0]); // true
		
		// �̰��� ���� ����(shallow copy)��� �Ѵ�. �ݴ�� ���� ����(deep copy)�� �����ϴ� ��ü�� ������ �����ϴ� ���̴�.
		
		// ���� �����ϴ� ���� ����
		
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
