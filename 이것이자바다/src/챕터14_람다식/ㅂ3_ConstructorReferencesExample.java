package é��14_���ٽ�;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ��3_ConstructorReferencesExample {
	public static void main(String[] args) {
		
		Function<String, ��3_Member> function1 = ��3_Member :: new;
		��3_Member member1 = function1.apply("angel");
		
		BiFunction<String, String, ��3_Member> function2 = ��3_Member :: new;
		��3_Member member2 = function2.apply("��õ��", "angel");
		
	}
}
