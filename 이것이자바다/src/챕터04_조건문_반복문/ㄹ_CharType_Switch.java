package é��04_���ǹ�_�ݺ���;

public class ��_CharType_Switch {
	public static void main(String[] args) {
		char grade = 'B';

		switch (grade) {
		case 'A':
		case 'a':
			System.out.println("��� ���");
			break;
		case 'B':
		case 'b':
			System.out.println("�Ϲ� ���");
			break;
		default:
			System.out.println("��������");
		}

	}
}
