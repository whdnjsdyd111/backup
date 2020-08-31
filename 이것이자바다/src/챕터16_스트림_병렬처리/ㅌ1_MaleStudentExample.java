package é��16_��Ʈ��_����ó��;

import java.util.Arrays;
import java.util.List;

public class ��1_MaleStudentExample {
	public static void main(String[] args) {
		
		List<��1_Student> totalList = Arrays.asList(
				new ��1_Student("ȫ�浿", 10, ��1_Student.Sex.MALE),
				new ��1_Student("�����", 10, ��1_Student.Sex.FEMALE),
				new ��1_Student("�ſ��", 10, ��1_Student.Sex.MALE),
				new ��1_Student("�ڼ���", 10, ��1_Student.Sex.FEMALE)
		);
		
		��2_MaleStudent maleStudent = totalList.parallelStream()
				.filter( s -> s.getSex() == ��1_Student.Sex.MALE)
				.collect( ��2_MaleStudent :: new, ��2_MaleStudent :: accumulate, ��2_MaleStudent :: combine);
		
		maleStudent.getList().stream()
			.forEach( s -> System.out.println(s.getName()) );
	}
}
