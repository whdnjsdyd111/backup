package 챕터06_클래스.ㅍ2.package1;

public class A {
	// 필드
	A a1 = new A(true);
	A a2 = new A(1);
	A a3 = new A("문자열");
	
	// 생성자
	public A(boolean b) {}	// public 접근 제한
	A(int b) {}				// default 접근 제한
	private A(String s) {}	// private 접근 제한
	
	// 다음을 보면 A 클래스 내부에서는 A의 모든 생성자를 호출할 수 있음을 볼 수 있다.
}
