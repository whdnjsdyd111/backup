package é��11_�⺻APIŬ����.��_StringŬ����.��_String�޼ҵ�.��_��������charAt;

// charAt() �޼ҵ�� �Ű������� �־��� �ε����� ���ڸ� �����Ѵ�.
// ���⼭ �ε����� 0�������� "���ڿ��� ����-1"������ ��ȣ�� ���Ѵ�. ���� �ڵ带 ���鼭 ��������.

// String subject = "�ڹ� ���α׷���";
// char charValue = subject.charAt(3);

//	��	��		��	��	��	��	��
//	0	1	2	3	4	5	6	7

// charAt(3)�� 3�ε��� ��ġ�� �ִ� ���ڸ� ���Ѵ�. ��, '��' ���ڰ� �ش�ȴ�.
// ���� ������ �ֹε�Ϲ�ȣ���� �ε��� 7�� ���ڸ� �о� ���ڿ� ���ڸ� �����Ѵ�.

public class StringCharAt��� {
	public static void main(String[] args) {
		String ssn = "980626-1234567";
		
		char sex = ssn.charAt(7);
		switch(sex) {
		case '1':
		case '3':
			System.out.println("���� �Դϴ�.");
			break;
		case '2':
		case '4':
			System.out.println("���� �Դϴ�.");
			break;
		}
	}
}
