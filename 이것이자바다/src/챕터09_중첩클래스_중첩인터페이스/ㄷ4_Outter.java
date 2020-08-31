package Ã©ÅÍ09_ÁßÃ¸Å¬·¡½º_ÁßÃ¸ÀÎÅÍÆäÀÌ½º;

public class ¤§4_Outter {
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
			/* ÁßÃ¸ °´Ã¼ ÂüÁ¶ */
			System.out.println(this.field);
			this.method();
			
			/* ¹Ù±ù °´Ã¼ ÂüÁ¶ */
			System.out.println(¤§4_Outter.this.field);
			¤§4_Outter.this.method();
		}
	}
}
