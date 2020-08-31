package é��16_��Ʈ��_����ó��;

import java.util.Arrays;
import java.util.List;

public class ��1_StreamPipelinesExample {
	public static void main(String[] args) {
		
		List<��1_Member> list = Arrays.asList(
			new ��1_Member("ȫ�浿", ��1_Member.MALE, 30),	
			new ��1_Member("�質��", ��1_Member.FEMALE, 20),
			new ��1_Member("�ſ��", ��1_Member.MALE, 45),
			new ��1_Member("�ڼ���", ��1_Member.FEMALE, 27)
		);
		
		double ageAvg = list.stream()
				.filter( m -> m.getSex() == ��1_Member.MALE )
				.mapToInt( ��1_Member :: getAge )
				.average()
				.getAsDouble();
		
		System.out.println("���� ��� ����: " + ageAvg);
		
	}
}
