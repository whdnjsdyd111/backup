package é��16_��Ʈ��_����ó��;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ��4_GroupingAndReductionExample {
	public static void main(String[] args) {
		
		List<��1_Student> totalList = Arrays.asList(
				new ��1_Student("ȫ�浿", 10, ��1_Student.Sex.MALE),
				new ��1_Student("�����", 12, ��1_Student.Sex.FEMALE),
				new ��1_Student("�ſ��", 10, ��1_Student.Sex.MALE),
				new ��1_Student("�ڼ���", 12, ��1_Student.Sex.FEMALE)
		);
		
		// ������ ��� ������ �����ϴ� Map ���
		Map<��1_Student.Sex, Double> mapBySex = totalList.stream()
				.collect(
					Collectors.groupingBy(
							��1_Student :: getSex,
							Collectors.averagingDouble(��1_Student :: getScore)
					)
				);
				
		System.out.println("���л� ��� ����: " + mapBySex.get(��1_Student.Sex.MALE));
		System.out.println("���л� ��� ����: " + mapBySex.get(��1_Student.Sex.FEMALE));
		
		// ������ ��ǥ�� ������ �̸��� �����ϴ� Map ���
		Map<��1_Student.Sex, String> mapByName = totalList.stream()
				.collect(
					Collectors.groupingBy(
						��1_Student :: getSex,
						Collectors.mapping(
								��1_Student :: getName,
								Collectors.joining(","))
					)
				);
		
		System.out.println("���л� ��ü �̸�: " + mapByName.get(��1_Student.Sex.MALE));
		System.out.println("���л� ��ü �̸�: " + mapByName.get(��1_Student.Sex.FEMALE));
	}
}
