package 챕터09_중첩클래스_중첩인터페이스;

public class ㄷ2_A {
	// 인스턴스 멤버
	int field1;
	void method1() {}
	
	// 정적 멤버
	static int field2;
	static void method2() {}
	
	// 인스턴스 멤버 클래스
	class B {
		void method() {
			field1 = 10;
			method1();
			
			field2 = 10;
			method2();			// 모든 필드와 메소드에 접근할 수 있다.
		}
	}
	
	// 정적 멤버 클래스
	static class C {
		void method() {
			// field1 = 10;
			// method1();
			
			field2 = 10;
			method2();			// 인스턴스 필드와 메소드에 접근 할 수 없다.
		}
	}
}
