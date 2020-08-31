package 챕터09_중첩클래스_중첩인터페이스;

public class ㄴ1_Main {
	public static void main(String[] args) {
		ㄴ1_A a = new ㄴ1_A();
		
		// 인스턴스 멤버 클래스 객체 생성
		ㄴ1_A.B b = a.new B();
		b.field1 = 3;
		b.method1();
		
		// 정적 멤버 클래스 생성
		ㄴ1_A.C c = new ㄴ1_A.C();
		c.field1 = 3;
		c.method1();
		
		ㄴ1_A.C.field2 = 3;
		ㄴ1_A.C.method2();
		
		// 로컬 클래스
		a.method();
	}
}
