package é��16_��Ʈ��_����ó��;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ��1_ToListExample {
	public static void main(String[] args) {
		
		List<��1_Student> totalList = Arrays.asList(
			new ��1_Student("ȫ�浿", 10, ��1_Student.Sex.MALE),
			new ��1_Student("�����", 6, ��1_Student.Sex.FEMALE),
			new ��1_Student("�ſ��", 10, ��1_Student.Sex.MALE),
			new ��1_Student("�ڼ���", 6, ��1_Student.Sex.FEMALE)
		);
		
		// ���л��鸸 ���� List ����
		List<��1_Student> maleList = totalList.stream()
				.filter( s -> s.getSex() == ��1_Student.Sex.MALE )
				.collect(Collectors.toList());
		
		maleList.stream()
			.forEach( s -> System.out.println(s.getName()) );
		
		System.out.println();
		
		// ���л��鸸 ���� HashSet ����
		Set<��1_Student> femaleSet = totalList.stream()
				.filter( s -> s.getSex() == ��1_Student.Sex.FEMALE )
				.collect( Collectors.toCollection(HashSet :: new) );
		
		femaleSet.stream()
			.forEach( s -> System.out.println(s.getName()) );
	}
}
