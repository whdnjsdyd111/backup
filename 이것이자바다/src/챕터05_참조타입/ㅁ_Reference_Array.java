package é��05_����Ÿ��;

public class ��_Reference_Array {
	public static void main(String[] args) {

		String[] str = new String[3];

		str[0] = "Java";
		str[1] = "Java";
		str[2] = new String("Java");

		System.out.println(str[0] == str[1]); // 0�� 1 �ε����� ���� ���� ������ �ϰ� �ִ�.
		System.out.println(str[0] == str[2]); // �׷��� 0,1 �� 2�� ���� �ٸ� ������ �ϰ� �ִ�.
		System.out.println(str[0].equals(str[1])); // ������ ���ڿ��� ����.

	}
}
