package é��08_�������̽�;

public class ��1_Example {
	public static void main(String[] args) {
		
		��1_ImplementationC impl = new ��1_ImplementationC();
		
		��1_InterfaceA ia = impl;
		ia.methodA();				// A�� ȣ�� ����
		
		System.out.println();
		
		��1_InterfaceB ib = impl;
		ib.methodB();				// B�� ȣ�� ����
		
		System.out.println();
		
		��1_InterfaceC ic = impl;
		ic.methodA();
		ic.methodB();
		ic.methodC();				// ��� ȣ�� ����
	}
}
