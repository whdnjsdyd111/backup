package 챕터07_상속;

public class ㅂ_Protected_AccessModifier {
	// 접근 제한자는 public, protected, default, private와 같이 네 가지가 있는데 이 중 protected는 상속과 관련되어 있다.
	
	//	접근 제한자			적용 대상							접근할 수 없는 클래스
	//	public			클래스, 필드, 생성자, 메소드			없음
	//	protected		필드, 생성자, 메소드					자식 클래스가 아닌 다른 패키지에 소속된 클래스
	//	default			클래스, 필드, 생성자, 메소드			다른 패키지에 소속된 클래스
	//	private			필드, 생성자, 메소드					모든 외부 클래스
	
	// protected는 public과 default 접근 제한의 중간쯤에 해당한다. 같은 패키지에서는 default와 같이 접근 제한이 없지만 다른 패키지서는 자식 클래스만 접근을 허용한다.
	// protected는 필드와 생성자, 메소드 선언에 사용될 수 있다. 다음 예제 ㅂ패키지의 A 클래스를 보면 protected로 선언된 필드, 생성자, 메소드가 있다.
	// 동일한 패키지인 B 클래스는 A 클래스의 protected 필드, 생성자, 메소드에 얼마든지 접근할 수 있다.
	// ㅂ 패키지의 package2의 C 클래스는 A 클래스의 protected 필드, 생성자, 메소드에 접근할 수 없다.
	// 하지만 package2의 D 클래스는 A의 자식 클래스로써 A 클래스의 protected 필드, 생성자, 메소드에 접근할 수 있다.
}
