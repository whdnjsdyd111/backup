package é��14_���ٽ�;

public class ��1_MyFunctionalInterfaceExample {
	public static void main(String[] args) {
		��1_MyFunctionalInterface f1;
		
		f1 = () -> {
			String str = "method call1";
			System.out.println(str);
		};
		f1.method();
		
		f1 = () -> {
			System.out.println("method call2");
		};
		f1.method();
		
		f1 = () -> System.out.println("method call3");	// ���๮�� �ϳ���� {} ���� ����
		f1.method();
	}
}
