package é��14_���ٽ�;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class ��4_FunctionExample2 {
	private static List<��4_Student> list = Arrays.asList(
		new ��4_Student("ȫ�浿", 90, 96),
		new ��4_Student("�ſ��", 95, 93)
	);
	
	public static double avg( ToIntFunction<��4_Student> function ) {
		int sum = 0;
		for(��4_Student student : list) {
			sum += function.applyAsInt(student);
		}
		
		double avg = (double) sum / list.size();
		return avg;
	}
	
	public static void main(String[] args) {
		double englishAvg = avg( t -> t.getEnglishScore() );
		System.out.println("���� ��� ����: " + englishAvg);
		
		double mathAvg = avg( t -> t.getMathScore() );
		System.out.println("���� ��� ����: " + mathAvg);
	}
}
