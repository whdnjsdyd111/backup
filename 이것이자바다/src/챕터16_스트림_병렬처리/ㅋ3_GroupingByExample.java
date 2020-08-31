package é��16_��Ʈ��_����ó��;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ��3_GroupingByExample {
	public static void main(String[] args) {
		
		List<��1_Student> totalList = Arrays.asList(
				new ��1_Student("ȫ�浿", 10, ��1_Student.Sex.MALE, ��1_Student.City.Seoul),
				new ��1_Student("�����", 6, ��1_Student.Sex.FEMALE, ��1_Student.City.Pusan),
				new ��1_Student("�ſ��", 10, ��1_Student.Sex.MALE, ��1_Student.City.Pusan),
				new ��1_Student("�ڼ���", 6, ��1_Student.Sex.FEMALE, ��1_Student.City.Seoul)
		);
		
		Map<��1_Student.Sex, List<��1_Student>> mapBySex = totalList.stream()
				.collect( Collectors.groupingBy( ��1_Student :: getSex ) );
		
		System.out.print("[���л�] ");
		mapBySex.get( ��1_Student.Sex.MALE )
			.forEach( s -> System.out.print(s.getName() + " "));
		
		System.out.println();
		
		System.out.print("[���л�] ");
		mapBySex.get( ��1_Student.Sex.FEMALE )
			.forEach( s -> System.out.print(s.getName() + " "));
		
		System.out.println();
		
		Map<��1_Student.City, List<String>> mapByCity = totalList.stream()
				.collect(
						Collectors.groupingBy(
								��1_Student :: getCity,
								Collectors.mapping(��1_Student :: getName, Collectors.toList())
						)
					);
		
		System.out.print("\n[����] ");
		mapByCity.get( ��1_Student.City.Seoul )
			.forEach( s -> System.out.print(s + " "));
		
		System.out.print("\n[�λ�] ");
		mapByCity.get( ��1_Student.City.Pusan )
			.forEach( s -> System.out.print(s + " "));
	}
}
