package é��05_����Ÿ��;

public class ��2_Generate_Array_Length {
	public static void main(String[] args) {

		// ���� ������ ���� ������, �̸� �迭�� ���̸� ���Ͽ� ����� �ʹٸ� new �����ڷ� ������ ���� ���� �� �ִ�. ������ ��� �ʱ�ȭ �ȴ�.

		// Ÿ��[] ���� = new Ÿ��[����];

		int[] arr = new int[10];

		// Ÿ��[] ���� = null;
		// ���� = new Ÿ��[����];
		
		int[] arr1 = null;
		arr1 = new int[10];

		// arr1�� �� ���
		// 0 1 2 3 4 5 6 7 8 9
		// 0 0 0 0 0 0 0 0 0 0

		// String Ÿ���� ���
		// ��� null �̴�.
		
		// ������ �Ǽ��� ��� 0(Long�� Float�� ��� l�� f�� ����)���� �ʱ�ȭ �ǰ� boolean�� false, ���� Ÿ���� ��� null�̴�.
		
		// ���Ŀ� ������ �迭�� �ε����� ���� ���� �� �ִ�.
		
		arr1[0] = 10;
		arr1[1] = 12;

	}
}
