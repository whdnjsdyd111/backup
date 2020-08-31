package 챕터06_클래스.ㅍ2.package1;

public class B {
	// 필드
	A a1 = new A(true);
	A a2 = new A(1);
//	A a3 = new A("문자열");	// private 생성자 접근 불가
	
	// 패키지가 동일한 B 클래스에서는 A 클래스의 private 생성자를 제외하고 다른 생성자를 호출할 수 있다.
}
