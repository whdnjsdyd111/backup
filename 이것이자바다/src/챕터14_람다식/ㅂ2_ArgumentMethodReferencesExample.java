package 챕터14_람다식;

import java.util.function.ToIntBiFunction;

public class ㅂ2_ArgumentMethodReferencesExample {
	public static void main(String[] args) {
		ToIntBiFunction<String, String> function;
		
		function = (a, b) -> a.compareToIgnoreCase(b);
		print(function.applyAsInt("Java8", "JAVA8"));
		
		function = (a, b) -> a.compareToIgnoreCase(b);
		print(function.applyAsInt("JAVA8", "JAVA Eight"));
	}
	
	public static void print(int order) {
		if(order < 0) { System.out.println("사전순으로 먼저 옵니다."); }
		else if(order == 0) { System.out.println("동일한 문자입니다."); }
		else { System.out.println("사전순으로 나중에 옵니다."); }
	}
}
