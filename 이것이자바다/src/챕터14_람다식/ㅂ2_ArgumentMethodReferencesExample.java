package é��14_���ٽ�;

import java.util.function.ToIntBiFunction;

public class ��2_ArgumentMethodReferencesExample {
	public static void main(String[] args) {
		ToIntBiFunction<String, String> function;
		
		function = (a, b) -> a.compareToIgnoreCase(b);
		print(function.applyAsInt("Java8", "JAVA8"));
		
		function = (a, b) -> a.compareToIgnoreCase(b);
		print(function.applyAsInt("JAVA8", "JAVA Eight"));
	}
	
	public static void print(int order) {
		if(order < 0) { System.out.println("���������� ���� �ɴϴ�."); }
		else if(order == 0) { System.out.println("������ �����Դϴ�."); }
		else { System.out.println("���������� ���߿� �ɴϴ�."); }
	}
}
