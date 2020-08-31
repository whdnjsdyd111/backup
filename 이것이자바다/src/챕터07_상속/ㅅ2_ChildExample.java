package 챕터07_상속;

public class ㅅ2_ChildExample {
	public static void main(String[] args) {
		ㅅ2_Child child = new ㅅ2_Child();
		
		ㅅ2_Parent parent = child;	// 자동 타입 변환
		
		parent.method1();
		parent.method2();			// 재정의된 메소드가 호출됨
//		parent.method3();	호출 불가능
		
		System.out.println(parent == child);
		
	}
}
