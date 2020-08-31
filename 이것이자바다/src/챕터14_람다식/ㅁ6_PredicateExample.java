package 챕터14_람다식;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ㅁ6_PredicateExample {
	private static List<ㅁ6_Student> list = Arrays.asList(
		new ㅁ6_Student("홍길동", "남자", 90),
		new ㅁ6_Student("김순희", "여자", 90),
		new ㅁ6_Student("김자바", "남자", 95),
		new ㅁ6_Student("박한나", "여자", 92)
	);
	
	public static double avg( Predicate<ㅁ6_Student> predicate ) {
		int count = 0;
		int sum = 0;
		
		for(ㅁ6_Student student : list) {
			if( predicate.test(student) ) {
				count++;
				sum += student.getScore();
			}
		}
		
		return (double) sum / count;
	}
	
	public static void main(String[] args) {
		double maleAvg = avg( t -> t.getSex().equals("남자") );
		System.out.println("남자 평균 점수: " + maleAvg);
		
		double femaleAvg = avg( t -> t.getSex().equals("여자") );
		System.out.println("여자 평균 점수: " + femaleAvg);
	}
}
