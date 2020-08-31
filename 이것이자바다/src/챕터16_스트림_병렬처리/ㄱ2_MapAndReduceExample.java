package 챕터16_스트림_병렬처리;

import java.util.Arrays;
import java.util.List;

public class ㄱ2_MapAndReduceExample {
	public static void main(String[] args) {
		
		List<ㄱ2_Student> list = Arrays.asList(
			new ㄱ2_Student("홍길동", 10),
			new ㄱ2_Student("신용권", 20),
			new ㄱ2_Student("유미선", 30)
		);
		
		double avg = list.stream()
			// 중간 처리 (학생 객체를 점수로 매핑)
			.mapToInt(ㄱ2_Student :: getScore)
			// 최종 처리 (평균 점수)
			.average()
			.getAsDouble();
		
		System.out.println("평균 점수: " +avg);
			
	}
}
