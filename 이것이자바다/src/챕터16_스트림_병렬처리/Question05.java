package 챕터16_스트림_병렬처리;

import java.util.Arrays;
import java.util.List;

public class Question05 {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList(
			"This is a java book",
			"Lambda Expression",
			"Java8 supports lambda exression"
		);
		
		list.stream()
			.filter( s -> s.toLowerCase().contains("java"))
			.forEach( s -> System.out.println(s) );
		
	}
}
