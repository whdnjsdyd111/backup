package 챕터16_스트림_병렬처리;

import java.util.Arrays;
import java.util.List;

public class ㄷ1_StreamPipelinesExample {
	public static void main(String[] args) {
		
		List<ㄷ1_Member> list = Arrays.asList(
			new ㄷ1_Member("홍길동", ㄷ1_Member.MALE, 30),	
			new ㄷ1_Member("김나리", ㄷ1_Member.FEMALE, 20),
			new ㄷ1_Member("신용권", ㄷ1_Member.MALE, 45),
			new ㄷ1_Member("박수미", ㄷ1_Member.FEMALE, 27)
		);
		
		double ageAvg = list.stream()
				.filter( m -> m.getSex() == ㄷ1_Member.MALE )
				.mapToInt( ㄷ1_Member :: getAge )
				.average()
				.getAsDouble();
		
		System.out.println("남자 평균 나이: " + ageAvg);
		
	}
}
