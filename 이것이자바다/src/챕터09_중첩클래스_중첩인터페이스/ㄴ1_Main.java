package é��09_��øŬ����_��ø�������̽�;

public class ��1_Main {
	public static void main(String[] args) {
		��1_A a = new ��1_A();
		
		// �ν��Ͻ� ��� Ŭ���� ��ü ����
		��1_A.B b = a.new B();
		b.field1 = 3;
		b.method1();
		
		// ���� ��� Ŭ���� ����
		��1_A.C c = new ��1_A.C();
		c.field1 = 3;
		c.method1();
		
		��1_A.C.field2 = 3;
		��1_A.C.method2();
		
		// ���� Ŭ����
		a.method();
	}
}
