package 챕터14_람다식;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class ㅁ4_FunctionExample2 {
	private static List<ㅁ4_Student> list = Arrays.asList(
		new ㅁ4_Student("홍길동", 90, 96),
		new ㅁ4_Student("신용권", 95, 93)
	);
	
	public static double avg( ToIntFunction<ㅁ4_Student> function ) {
		int sum = 0;
		for(ㅁ4_Student student : list) {
			sum += function.applyAsInt(student);
		}
		
		double avg = (double) sum / list.size();
		return avg;
	}
	
	public static void main(String[] args) {
		double englishAvg = avg( t -> t.getEnglishScore() );
		System.out.println("영어 평균 점수: " + englishAvg);
		
		double mathAvg = avg( t -> t.getMathScore() );
		System.out.println("수학 평균 점수: " + mathAvg);
	}
}
