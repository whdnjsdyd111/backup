package 챕터08_인터페이스;

public interface ㅅ2_ChildInterface2 extends ㅅ2_ParentInterface {
	@Override
	public default void method2() { /* 실행문 */ }
	
	public void method3();
}
