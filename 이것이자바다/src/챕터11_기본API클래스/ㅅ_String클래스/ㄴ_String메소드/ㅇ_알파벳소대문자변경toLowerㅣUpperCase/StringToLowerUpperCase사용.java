package é��11_�⺻APIŬ����.��_StringŬ����.��_String�޼ҵ�.��_���ĺ��Ҵ빮�ں���toLower��UpperCase;

// ���� ���������� �� ���ڿ��� ��ҹ��ڰ� �ٸ� ��� ��� ���ϴ����� �����ش�.
// equals() �޼ҵ带 ����Ϸ��� ������ toLowerCase()�� toUpperCase()�� ��ҹ��ڸ� ���߾�� ������,
// equalsIgnoreCase() �޼ҵ带 ����ϸ� �� �۾��� �����ȴ�.

public class StringToLowerUpperCase��� {
	public static void main(String[] args) {
		String str1 = "Java Programming";
		String str2 = "JAVA Programming";
		
		System.out.println(str1.equals(str2));
		
		System.out.println(str1.equalsIgnoreCase(str2));
		
		String lowerStr1 = str1.toLowerCase();
		String lowerStr2 = str2.toLowerCase();
		System.out.println(lowerStr1.equals(lowerStr2));
	}
}
