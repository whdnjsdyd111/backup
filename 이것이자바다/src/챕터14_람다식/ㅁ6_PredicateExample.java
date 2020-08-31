package é��14_���ٽ�;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ��6_PredicateExample {
	private static List<��6_Student> list = Arrays.asList(
		new ��6_Student("ȫ�浿", "����", 90),
		new ��6_Student("�����", "����", 90),
		new ��6_Student("���ڹ�", "����", 95),
		new ��6_Student("���ѳ�", "����", 92)
	);
	
	public static double avg( Predicate<��6_Student> predicate ) {
		int count = 0;
		int sum = 0;
		
		for(��6_Student student : list) {
			if( predicate.test(student) ) {
				count++;
				sum += student.getScore();
			}
		}
		
		return (double) sum / count;
	}
	
	public static void main(String[] args) {
		double maleAvg = avg( t -> t.getSex().equals("����") );
		System.out.println("���� ��� ����: " + maleAvg);
		
		double femaleAvg = avg( t -> t.getSex().equals("����") );
		System.out.println("���� ��� ����: " + femaleAvg);
	}
}
