package é��08_�������̽�;

public class ��1_DefaultMethodExample {
	public static void main(String[] args) {
		��1_MyInterface mi1 = new ��1_MyClassA();
		mi1.method1();
		mi1.method2();
		
		System.out.println();
		
		��1_MyInterface mi2 = new ��1_MyClassB();
		mi2.method1();
		mi2.method2();
	}
}
