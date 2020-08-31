package 챕터08_인터페이스;

public interface ㅅ1_MyInterface {
	public void method1();
	
	public default void method2() {
		System.out.println("MyInterface - method2() 실행");
	}
}
