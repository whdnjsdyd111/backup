package 챕터16_스트림_병렬처리;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ㅋ1_ToListExample {
	public static void main(String[] args) {
		
		List<ㅋ1_Student> totalList = Arrays.asList(
			new ㅋ1_Student("홍길동", 10, ㅋ1_Student.Sex.MALE),
			new ㅋ1_Student("김수애", 6, ㅋ1_Student.Sex.FEMALE),
			new ㅋ1_Student("신용권", 10, ㅋ1_Student.Sex.MALE),
			new ㅋ1_Student("박수미", 6, ㅋ1_Student.Sex.FEMALE)
		);
		
		// 남학생들만 묶어 List 생성
		List<ㅋ1_Student> maleList = totalList.stream()
				.filter( s -> s.getSex() == ㅋ1_Student.Sex.MALE )
				.collect(Collectors.toList());
		
		maleList.stream()
			.forEach( s -> System.out.println(s.getName()) );
		
		System.out.println();
		
		// 여학생들만 묶어 HashSet 생성
		Set<ㅋ1_Student> femaleSet = totalList.stream()
				.filter( s -> s.getSex() == ㅋ1_Student.Sex.FEMALE )
				.collect( Collectors.toCollection(HashSet :: new) );
		
		femaleSet.stream()
			.forEach( s -> System.out.println(s.getName()) );
	}
}
