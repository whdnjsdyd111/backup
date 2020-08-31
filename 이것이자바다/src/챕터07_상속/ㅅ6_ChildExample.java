package 챕터07_상속;

public class ㅅ6_ChildExample {
	public static void main(String[] args) {
		ㅅ6_Parent parent = new ㅅ6_Child();		// 자동 타입 변환
		
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		/*
		parent.field2 = "data2";	불가능
		parent.method3();			불가능
		 */
		
		ㅅ6_Child child = (ㅅ6_Child) parent;		// 강제 타입 변환
		child.field2 = "data2";
		child.method2();
	}
}
