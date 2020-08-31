package 챕터06_클래스;

public class 하1_Service {
	@하1_PrintAnnotation
	public void method1() {
		System.out.println("실행 내용1");
	}
	
	@하1_PrintAnnotation("*")
	public void method2() {
		System.out.println("실행 내용2");
	}
	
	@하1_PrintAnnotation(value = "#", number = 20)
	public void method3() {
		System.out.println("실행 내용3");
	}
	
	// 다음 클래스에 이플렉션을 이용하여 Service에 적용된 어노테이션 정보를 읽고 엘리먼트 값에 따라 출력할 문자와 출력 횟수를 콘솔에 출력한 후,
	// 해당 메소드를 호출한다. method.invoke( new Service())는 Service 객체를 생성하고 생성된 Service 객체의 메소드를 호출하는 코드이다.
}
