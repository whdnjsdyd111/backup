package é��09_��øŬ����_��ø�������̽�;

public class ��4_Outter {
	String field = "Outter - field";
	
	void method() {
		System.out.println("Outter - method");
	}
	
	class Nested {
		String field = "Nested - field";
		void method() {
			System.out.println("Nested - method");
		}
		
		void print() {
			/* ��ø ��ü ���� */
			System.out.println(this.field);
			this.method();
			
			/* �ٱ� ��ü ���� */
			System.out.println(��4_Outter.this.field);
			��4_Outter.this.method();
		}
	}
}
