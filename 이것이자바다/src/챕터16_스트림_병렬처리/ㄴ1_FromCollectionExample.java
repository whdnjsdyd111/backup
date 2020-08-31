package 챕터16_스트림_병렬처리;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ㄴ1_FromCollectionExample {
	public static void main(String[] args) {
		
		List<ㄴ1_Student> list = Arrays.asList(
			new ㄴ1_Student("홍길동", 10),
			new ㄴ1_Student("신용권", 20),
			new ㄴ1_Student("유미선", 30)
		);
		
		Stream<ㄴ1_Student> stream = list.stream();
		stream.forEach( s -> System.out.println(s.getName()) );
	}
}
