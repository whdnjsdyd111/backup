package é��11_�⺻APIŬ����.��_ObjectŬ����.��_��ü����_clone.��_��������_thinClone;

// ���� ������ ���� ���� Member�� ������ ��, ���� Member�� password �ʵ尪�� �����ϴ��� ���� Member�� password �ʵ尪�� ������� ������ �����ش�.

public class Member��� {
	public static void main(String[] args) {
		// ���� ��ü ����
		Member original = new Member("blue", "ȫ�浿", "12345", 25, true);
		
		// ���� ��ü�� ���� �Ŀ� �н����� ����
		Member cloned = original.getMember();
		cloned.password = "67890"; // ���� ��ü���� �н����� ����
		

		System.out.println("[���� ��ü�� �ʵ尪]");
		System.out.println("id: "+cloned.id);
		System.out.println("name: "+cloned.name);
		System.out.println("password: "+cloned.password);
		System.out.println("age: "+cloned.age);
		System.out.println("adult: "+cloned.adult);
		
		System.out.println("[���� ��ü�� �ʵ尪]");
		System.out.println("id: "+original.id);
		System.out.println("name: "+original.name);
		System.out.println("password: "+original.password); // ���� ��ü�� �н������ ���� ����
		System.out.println("age: "+original.age);
		System.out.println("adult: "+original.adult);
	}
}
