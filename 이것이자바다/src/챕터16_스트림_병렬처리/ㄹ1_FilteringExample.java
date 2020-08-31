package 챕터16_스트림_병렬처리;

import java.util.Arrays;
import java.util.List;

public class ㄹ1_FilteringExample {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("홍길동", "신용권", "김자바", "신용권", "신민철");
		
		list.stream()
			.distinct()			// 중복 제거
			.forEach( n -> System.out.println(n) );
		System.out.println();
		
		list.stream()
			.filter( n -> n.startsWith("신") )		// 필터링
			.forEach( n -> System.out.println(n) );
		System.out.println();
		
		list.stream()
			.distinct()								// 중복 제거 후 필터링
			.filter( n -> n.startsWith("신") )
			.forEach( n -> System.out.println(n) );
		System.out.println();
	}
}
