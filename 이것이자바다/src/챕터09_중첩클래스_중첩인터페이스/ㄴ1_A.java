package é��09_��øŬ����_��ø�������̽�;

/* �ٱ� Ŭ���� */
public class ��1_A {
	��1_A() { System.out.println("A ��ü�� ������"); }
	
	/* �ν��Ͻ� ��� Ŭ���� */
	class B {
		B() {System.out.println("B ��ü�� ������"); }
		int field1;
		void method1() {}
		
		// static int field2;
		// static void method2() {}
	}
	
	/* ���� ��� Ŭ���� */
	static class C {
		C() {System.out.println("C ��ü�� ������"); }
		int field1;
		void method1() {}
		
		static int field2;
		static void method2() {}
	}
	
	/* ���� Ŭ���� */
	void method() {
		class D{
			D() {System.out.println("D ��ü�� ������"); }
			int field1;
			void mrthod1() {}
			
			// static int field2;
			// static void method2() {}
		}
		D d = new D();
		d.field1 = 3;
		d.mrthod1();
	}
}
