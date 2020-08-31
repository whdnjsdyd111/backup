package 챕터16_스트림_병렬처리;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ㅋ4_GroupingAndReductionExample {
	public static void main(String[] args) {
		
		List<ㅋ1_Student> totalList = Arrays.asList(
				new ㅋ1_Student("홍길동", 10, ㅋ1_Student.Sex.MALE),
				new ㅋ1_Student("김수애", 12, ㅋ1_Student.Sex.FEMALE),
				new ㅋ1_Student("신용권", 10, ㅋ1_Student.Sex.MALE),
				new ㅋ1_Student("박수미", 12, ㅋ1_Student.Sex.FEMALE)
		);
		
		// 성별로 평균 점수를 저장하는 Map 얻기
		Map<ㅋ1_Student.Sex, Double> mapBySex = totalList.stream()
				.collect(
					Collectors.groupingBy(
							ㅋ1_Student :: getSex,
							Collectors.averagingDouble(ㅋ1_Student :: getScore)
					)
				);
				
		System.out.println("남학생 평균 점수: " + mapBySex.get(ㅋ1_Student.Sex.MALE));
		System.out.println("여학생 평균 점수: " + mapBySex.get(ㅋ1_Student.Sex.FEMALE));
		
		// 성별을 쉼표로 구분한 이름을 저장하는 Map 얻기
		Map<ㅋ1_Student.Sex, String> mapByName = totalList.stream()
				.collect(
					Collectors.groupingBy(
						ㅋ1_Student :: getSex,
						Collectors.mapping(
								ㅋ1_Student :: getName,
								Collectors.joining(","))
					)
				);
		
		System.out.println("남학생 전체 이름: " + mapByName.get(ㅋ1_Student.Sex.MALE));
		System.out.println("여학생 전체 이름: " + mapByName.get(ㅋ1_Student.Sex.FEMALE));
	}
}
