package é��09_��øŬ����_��ø�������̽�;

public class ��2_A {
	// �ν��Ͻ� ���
	int field1;
	void method1() {}
	
	// ���� ���
	static int field2;
	static void method2() {}
	
	// �ν��Ͻ� ��� Ŭ����
	class B {
		void method() {
			field1 = 10;
			method1();
			
			field2 = 10;
			method2();			// ��� �ʵ�� �޼ҵ忡 ������ �� �ִ�.
		}
	}
	
	// ���� ��� Ŭ����
	static class C {
		void method() {
			// field1 = 10;
			// method1();
			
			field2 = 10;
			method2();			// �ν��Ͻ� �ʵ�� �޼ҵ忡 ���� �� �� ����.
		}
	}
}
