package é��07_���;

public class ��7_InstanceofExample {
	
	public static void method1(��7_Parent parent) {
		
		if(parent instanceof ��7_Child) {						// Child Ÿ������ ��ȯ�� �������� Ȯ��
			��7_Child child = (��7_Child) parent;
			System.out.println("method1 - Child�� ��ȯ ����");
		} else {
			System.out.println("method1 - Child�� ��ȯ���� ����");
		}
		
	}
	
	public static void method2(��7_Parent parent) {
		��7_Child child = (��7_Child) parent;						// ClassCastException�� �߻��� ���ɼ� ����
		System.out.println("method2 - Child�� ��ȯ ����");
	}
	
	public static void main(String[] args) {
		��7_Parent parentA = new ��7_Child();						// Child ��ü�� �Ű������� ����
		method1(parentA);
		method2(parentA);
		
		��7_Parent parentB = new ��7_Parent();					// Parent ��ü�� �Ű������� ����
		method1(parentB);
		method2(parentB);	// ���� �߻�
	}
}
