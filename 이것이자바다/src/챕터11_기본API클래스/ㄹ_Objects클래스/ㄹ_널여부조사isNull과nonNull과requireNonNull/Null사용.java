package é��11_�⺻APIŬ����.��_ObjectsŬ����.��_�ο�������isNull��nonNull��requireNonNull;

import java.util.Objects;

public class Null��� {
	public static void main(String[] args) {
		String str1 = "ȫ�浿";
		String str2 = null;
		
		System.out.println(Objects.requireNonNull(str1));
		
		try {
			String name = Objects.requireNonNull(str2);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			String name = Objects.requireNonNull(str2, "�̸��� �����ϴ�.");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			String name = Objects.requireNonNull(str2, ()->"�̸��� ���ٴϱ��");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		// 21������ ���� �� ��° �Ű������� ���ٽ��� �־���. ���ٽ��� 14�忡�� �н��Ѵ�.
		// ���ٽ��� �������̽��� ���� ��ü�̹Ƿ� Supplier ���� ��ü�� ���ٽ��� �����ߴ�.
		
		
	}
}
