package é��11_�⺻APIŬ����.��_StringŬ����.��_String�޼ҵ�.��_���ڿ�����length;

// length() �޼ҵ�� ���ڿ��� ����(������ ��)�� �����Ѵ�. ���� �ڵ带 ���� �����غ���.

//	String subject = "�ڹ� ���α׷���";
//	int length = subject.length();

// length �������� 8�� ����ȴ�. subject ��ü�� ���ڿ� ���̴� ������ �����ؼ� 8���̱� �����̴�.

//	��	��		��	��	��	��	��
//	0	1	2	3	4	5	6	7
//	����������������������������������������������������������
//			     �� 8����

public class StringLength��� {
	public static void main(String[] args) {
		String ssn = "9806261234567";
		int length = ssn.length();
		
		if(length == 13) {
			System.out.println("�ֹι�ȣ �ڸ����� �½��ϴ�.");
		} else {
			System.out.println("�ֹι�ȣ �ڸ����� Ʋ���ϴ�.");
		}
	}
}
