package 챕터08_인터페이스;

public class ㅂ1_Example {
	public static void main(String[] args) {
		
		ㅂ1_ImplementationC impl = new ㅂ1_ImplementationC();
		
		ㅂ1_InterfaceA ia = impl;
		ia.methodA();				// A만 호출 가능
		
		System.out.println();
		
		ㅂ1_InterfaceB ib = impl;
		ib.methodB();				// B만 호출 가능
		
		System.out.println();
		
		ㅂ1_InterfaceC ic = impl;
		ic.methodA();
		ic.methodB();
		ic.methodC();				// 모두 호출 가능
	}
}
