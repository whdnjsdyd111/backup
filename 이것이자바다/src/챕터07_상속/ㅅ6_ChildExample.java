package é��07_���;

public class ��6_ChildExample {
	public static void main(String[] args) {
		��6_Parent parent = new ��6_Child();		// �ڵ� Ÿ�� ��ȯ
		
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		/*
		parent.field2 = "data2";	�Ұ���
		parent.method3();			�Ұ���
		 */
		
		��6_Child child = (��6_Child) parent;		// ���� Ÿ�� ��ȯ
		child.field2 = "data2";
		child.method2();
	}
}
