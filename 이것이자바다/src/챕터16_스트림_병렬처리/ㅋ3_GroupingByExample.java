package 챕터16_스트림_병렬처리;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ㅋ3_GroupingByExample {
	public static void main(String[] args) {
		
		List<ㅋ1_Student> totalList = Arrays.asList(
				new ㅋ1_Student("홍길동", 10, ㅋ1_Student.Sex.MALE, ㅋ1_Student.City.Seoul),
				new ㅋ1_Student("김수애", 6, ㅋ1_Student.Sex.FEMALE, ㅋ1_Student.City.Pusan),
				new ㅋ1_Student("신용권", 10, ㅋ1_Student.Sex.MALE, ㅋ1_Student.City.Pusan),
				new ㅋ1_Student("박수미", 6, ㅋ1_Student.Sex.FEMALE, ㅋ1_Student.City.Seoul)
		);
		
		Map<ㅋ1_Student.Sex, List<ㅋ1_Student>> mapBySex = totalList.stream()
				.collect( Collectors.groupingBy( ㅋ1_Student :: getSex ) );
		
		System.out.print("[남학생] ");
		mapBySex.get( ㅋ1_Student.Sex.MALE )
			.forEach( s -> System.out.print(s.getName() + " "));
		
		System.out.println();
		
		System.out.print("[여학생] ");
		mapBySex.get( ㅋ1_Student.Sex.FEMALE )
			.forEach( s -> System.out.print(s.getName() + " "));
		
		System.out.println();
		
		Map<ㅋ1_Student.City, List<String>> mapByCity = totalList.stream()
				.collect(
						Collectors.groupingBy(
								ㅋ1_Student :: getCity,
								Collectors.mapping(ㅋ1_Student :: getName, Collectors.toList())
						)
					);
		
		System.out.print("\n[서울] ");
		mapByCity.get( ㅋ1_Student.City.Seoul )
			.forEach( s -> System.out.print(s + " "));
		
		System.out.print("\n[부산] ");
		mapByCity.get( ㅋ1_Student.City.Pusan )
			.forEach( s -> System.out.print(s + " "));
	}
}
