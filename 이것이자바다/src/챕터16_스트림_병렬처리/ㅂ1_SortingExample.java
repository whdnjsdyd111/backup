package 챕터16_스트림_병렬처리;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class ㅂ1_SortingExample {
	public static void main(String[] args) {
		
		// 숫자 요소
		IntStream intStream = Arrays.stream(new int[] { 5, 3, 2, 1, 4 });
		intStream
			.sorted()
			.forEach(n -> System.out.print(n + ", ") );
		System.out.println();
		
		// 객체 요소
		List<ㅂ1_Student> list = Arrays.asList(
			new ㅂ1_Student("홍길동", 30),
			new ㅂ1_Student("신용권", 10),
			new ㅂ1_Student("유미선", 20)
		);
		
		list.stream()
			.sorted()
			.forEach(s -> System.out.print(s.getScore() + ", ") );
		
		System.out.println();
		
		list.stream()
			.sorted( Comparator.reverseOrder() )
			.forEach( s -> System.out.print(s.getScore() + ", ") );
	}
}
