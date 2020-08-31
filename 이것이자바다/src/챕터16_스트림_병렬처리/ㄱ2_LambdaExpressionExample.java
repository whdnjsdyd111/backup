package 챕터16_스트림_병렬처리;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ㄱ2_LambdaExpressionExample {
	public static void main(String[] args) {
		
		List<ㄱ2_Student> list = Arrays.asList(
			new ㄱ2_Student("홍길동", 90),
			new ㄱ2_Student("신용권", 92)
		);
				
		Stream<ㄱ2_Student> stream = list.stream();
		stream.forEach( s -> {
			String name = s.getName();
			int score = s.getScore();
			System.out.println(name + " - " + score);
		});
	}
}
