package é��03_������;

public class ��_Compare_String {
	public static void main(String[] args) {
		
		String str1 = "������";
		String str2 = "������";
		String str3 = new String("������");
		String str4 = "������";
		
		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
		System.out.println(str4 == str1);
		
		// ���ڿ����� == �����ڸ� ����ϸ� ������ ���Ѵ�.
		// str1 �� str2 �� ���� "������" ������ �����ϴµ� new String���� ���ο� ������ ����
		System.out.println();
		
		boolean bool1 = str1.equals(str2);
		boolean bool2 = str1.equals(str3);

		System.out.println(bool1);
		System.out.println(bool2);

		// ������ equals �޼ҵ带 ����Ͽ� ���ڿ��� ������ �����ش�.
	}
}
