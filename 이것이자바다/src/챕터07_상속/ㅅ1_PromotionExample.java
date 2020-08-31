package 챕터07_상속;

				class A {}

class B extends A {}		class C extends A {}
class D extends B {} 		class E extends C {}

public class ㅅ1_PromotionExample {
	public static void main(String[] args) {
		
		B b = new B();
		C c	= new C();
		D d = new D();
		E e = new E();
		
		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;
		
		B b1 = d;
		C c1 = e;
		
//		B b3 = e;
//		C c2 = d;		컴파일 에러
	}
}
