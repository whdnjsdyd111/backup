package é��05_����Ÿ��;

public class ��1_Name {
	public static void main(String[] args) {
		
		// name() �޼ҵ�� ���� ��ü�� ������ �ִ� ���ڿ��� �����Ѵ�.
		// �Ʒ� �ڵ�� today�� �����ϴ� ���� ��ü���� name() �޼ҵ带 ȣ���Ͽ� ���ڿ��� ����.
		// name() �޼ҵ�� ���� ��ü ������ ���ڿ��� "SUNDAY"�� �����ϰ� name ������ �����Ѵ�.
		
		��_Week today = ��_Week.SUNDAY;
		String name = today.name();
		
		System.out.println(name);
		
	}
}
