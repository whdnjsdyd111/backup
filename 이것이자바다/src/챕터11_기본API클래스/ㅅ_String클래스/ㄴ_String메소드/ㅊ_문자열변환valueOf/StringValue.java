package é��11_�⺻APIŬ����.��_StringŬ����.��_String�޼ҵ�.��_���ڿ���ȯvalueOf;

// valueOf() �޼ҵ�� �⺻ Ÿ���� ���� ���ڿ��� ��ȯ�ϴ� ����� ������ �ִ�.
// String Ŭ�������� �Ű� ������ Ÿ�Ժ��� valueOf() �޼ҵ尡 ������ ���� �����ε��Ǿ� �ִ�.
//	static String valueOf(boolean b | char c | int i | long l | double d | float f)

public class StringValue {
	public static void main(String[] args) {
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(10.5);
		String str3 = String.valueOf(true);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}
}
