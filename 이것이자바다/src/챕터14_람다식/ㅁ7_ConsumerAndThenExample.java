package Ã©ÅÍ14_¶÷´Ù½Ä;

import java.util.function.Consumer;

public class ¤±7_ConsumerAndThenExample {
	public static void main(String[] args) {
		
		Consumer<¤±7_Member> consumerA = (m) -> {
			System.out.println("consumerA: " + m.getName());
		};
		
		Consumer<¤±7_Member> consumerB = (m) -> {
			System.out.println("consumerB: " + m.getId());
		};
		
		Consumer<¤±7_Member> consumerAB = consumerA.andThen(consumerB);
		consumerAB.accept(new ¤±7_Member("È«±æµ¿", "hong", null));
	}
}
