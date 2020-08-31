package 챕터16_스트림_병렬처리;

import java.util.Arrays;
import java.util.List;

public class ㅌ1_MaleStudentExample {
	public static void main(String[] args) {
		
		List<ㅋ1_Student> totalList = Arrays.asList(
				new ㅋ1_Student("홍길동", 10, ㅋ1_Student.Sex.MALE),
				new ㅋ1_Student("김수애", 10, ㅋ1_Student.Sex.FEMALE),
				new ㅋ1_Student("신용권", 10, ㅋ1_Student.Sex.MALE),
				new ㅋ1_Student("박수미", 10, ㅋ1_Student.Sex.FEMALE)
		);
		
		ㅋ2_MaleStudent maleStudent = totalList.parallelStream()
				.filter( s -> s.getSex() == ㅋ1_Student.Sex.MALE)
				.collect( ㅋ2_MaleStudent :: new, ㅋ2_MaleStudent :: accumulate, ㅋ2_MaleStudent :: combine);
		
		maleStudent.getList().stream()
			.forEach( s -> System.out.println(s.getName()) );
	}
}
