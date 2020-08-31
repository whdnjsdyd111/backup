package 챕터14_람다식;

public class ㄷ1_MyFunctionalInterfaceExample {
	public static void main(String[] args) {
		ㄷ1_MyFunctionalInterface f1;
		
		f1 = () -> {
			String str = "method call1";
			System.out.println(str);
		};
		f1.method();
		
		f1 = () -> {
			System.out.println("method call2");
		};
		f1.method();
		
		f1 = () -> System.out.println("method call3");	// 실행문이 하나라면 {} 생략 가능
		f1.method();
	}
}
