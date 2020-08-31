package 챕터16_스트림_병렬처리;

import java.util.Arrays;
import java.util.List;

public class ㅁ2_MapExample {
	public static void main(String[] args) {
		
		List<ㅁ2_Student> list = Arrays.asList(
			new ㅁ2_Student("홍길동", 10),
			new ㅁ2_Student("신용권", 20),
			new ㅁ2_Student("유미선", 30)
		);
		
		list.stream()
			.mapToInt(ㅁ2_Student :: getScore)
			.forEach( score -> System.out.println(score) );
	}
}
