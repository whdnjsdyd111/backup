package é��05_����Ÿ��;

public class ��_Using_Array_Argument {
	public static void main(String[] args) {

		if (args.length != 2) { // �Էµ� ������ ������ �� ���� �ƴ� ���
			System.out.println("���α׷� ����");
			System.out.println("java MainStringArrayArgument num1 num2");
			System.exit(0); // ���α׷� ����
		}

		String str1 = args[0];
		String str2 = args[1];

		int num1 = Integer.parseInt(str1); // ���ڿ��� ���ڷ� �ٲٴ� �޼ҵ�
		int num2 = Integer.parseInt(str2);

		int result = num1 + num2;

		System.out.println(num1 + " + " + num2 + " = " + result);
	}
}
