package é��05_����Ÿ��;

public class ��_String_Equals {
	public static void main(String[] args) {
		
		String str1 = "������";
		String str2 = "������";
		
		if(str1 == str2)
			System.out.println("str1�� str2�� �������� ����");
		else
			System.out.println("str1�� str2�� �������� �ٸ�");
		
		if(str1.equals(str2))
			System.out.println("str1�� str2�� ���ڿ��� ����");
		else
			System.out.println("str1�� str2�� ���ڿ��� �ٸ�");
		
		String str3 = new String("������");
		String str4 = new String("������");
		
		if(str3 == str4)
			System.out.println("str3�� str4�� �������� ����");
		else
			System.out.println("str3�� str4�� �������� �ٸ�");
		
		if(str3.equals(str4))
			System.out.println("str3�� str4�� ���ڿ��� ����");
		else
			System.out.println("str3�� str4�� ���ڿ��� �ٸ�");
		
		String hobby = "����";
		
		System.out.println();
		
		hobby = null;	// ������ �����Ⱚ���� ����
		
		System.out.println(hobby);
		
	}
}
