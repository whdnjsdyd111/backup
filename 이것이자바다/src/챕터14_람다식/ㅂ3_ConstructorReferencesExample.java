package 챕터14_람다식;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ㅂ3_ConstructorReferencesExample {
	public static void main(String[] args) {
		
		Function<String, ㅂ3_Member> function1 = ㅂ3_Member :: new;
		ㅂ3_Member member1 = function1.apply("angel");
		
		BiFunction<String, String, ㅂ3_Member> function2 = ㅂ3_Member :: new;
		ㅂ3_Member member2 = function2.apply("신천사", "angel");
		
	}
}
