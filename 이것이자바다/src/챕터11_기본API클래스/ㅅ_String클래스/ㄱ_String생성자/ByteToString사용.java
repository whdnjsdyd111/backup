package é��11_�⺻APIŬ����.��_StringŬ����.��_String������;

// ������ ����Ʈ �迭�� ���ڿ��� ��ȯ�ϴ� �����̴�.

public class ByteToString��� {
	public static void main(String[] args) {
		byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
		
		String str1 = new String(bytes);
		System.out.println(str1);
		//				         �迭�� 74 ��ġ ������  ������������ 4��
		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);
	}
}
