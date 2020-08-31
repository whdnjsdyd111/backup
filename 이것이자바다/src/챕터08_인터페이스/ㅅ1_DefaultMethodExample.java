package 챕터08_인터페이스;

public class ㅅ1_DefaultMethodExample {
	public static void main(String[] args) {
		ㅅ1_MyInterface mi1 = new ㅅ1_MyClassA();
		mi1.method1();
		mi1.method2();
		
		System.out.println();
		
		ㅅ1_MyInterface mi2 = new ㅅ1_MyClassB();
		mi2.method1();
		mi2.method2();
	}
}
