package é��11_�⺻APIŬ����.��_ObjectsŬ����.��_��ü��������toString;

import java.util.Objects;

public class ToString��� {
	public static void main(String[] args) {
		String str1 = "ȫ�浿";
		String str2 = null;
		
		System.out.println(Objects.toString(str1));
		System.out.println(Objects.toString(str2));
		System.out.println(Objects.toString(str2, "�̸��� �����ϴ�"));
		
		// ù ��° �Ű����� not null�̸� toString()���� ���� ���� �����ϰ�,
		// null �̸� "null"�Ǵ� �� ��° �Ű����� nullDefault�� �����Ѵ�.
	}
}
