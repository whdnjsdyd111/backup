package 챕터07_상속;

public class ㅅ7_InstanceofExample {
	
	public static void method1(ㅅ7_Parent parent) {
		
		if(parent instanceof ㅅ7_Child) {						// Child 타입으로 변환이 가능한지 확인
			ㅅ7_Child child = (ㅅ7_Child) parent;
			System.out.println("method1 - Child로 변환 성공");
		} else {
			System.out.println("method1 - Child로 변환되지 않음");
		}
		
	}
	
	public static void method2(ㅅ7_Parent parent) {
		ㅅ7_Child child = (ㅅ7_Child) parent;						// ClassCastException이 발생할 가능성 있음
		System.out.println("method2 - Child로 변환 성공");
	}
	
	public static void main(String[] args) {
		ㅅ7_Parent parentA = new ㅅ7_Child();						// Child 객체를 매개값으로 전달
		method1(parentA);
		method2(parentA);
		
		ㅅ7_Parent parentB = new ㅅ7_Parent();					// Parent 객체를 매개값으로 전달
		method1(parentB);
		method2(parentB);	// 예외 발생
	}
}
