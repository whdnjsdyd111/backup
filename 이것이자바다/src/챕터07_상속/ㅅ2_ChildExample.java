package é��07_���;

public class ��2_ChildExample {
	public static void main(String[] args) {
		��2_Child child = new ��2_Child();
		
		��2_Parent parent = child;	// �ڵ� Ÿ�� ��ȯ
		
		parent.method1();
		parent.method2();			// �����ǵ� �޼ҵ尡 ȣ���
//		parent.method3();	ȣ�� �Ұ���
		
		System.out.println(parent == child);
		
	}
}
