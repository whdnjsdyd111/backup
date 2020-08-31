package 챕터08_인터페이스;

public class ㅂ1_ImplementationC implements ㅂ1_InterfaceC {
	@Override
	public void methodA() {
		System.out.println("ImplementationC - methodA() 실행");
	}
	
	@Override
	public void methodB() {
		System.out.println("ImplementationC - methodB() 실행");
	}
	
	@Override
	public void methodC() {
		System.out.println("ImplementationC - methodC() 실행");
	}
}
