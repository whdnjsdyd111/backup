package é��03_������;

public class ��_Compare {
	public static void main(String[] args) {
		float v1 = 0.1f;
		double v2 = 0.1;

		System.out.println(v1 == v2);
		System.out.println(v1 == (float) v2);

		System.out.println((int) (v1 * 10) == (int) (v2 * 10));

		// float �� 0.1�� �ٻ��̱� ������ float�� �ٸ� Ÿ������ ��ȯ���� ���ϰų� ���� float���� ��ȯ�� �ʿ䰡 �ִ�.
	}
}
