package é��14_���ٽ�;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class ��4_FunctionExample1 {
	private static List<��4_Student> list = Arrays.asList(
		new ��4_Student("ȫ�浿", 90, 96),
		new ��4_Student("�ſ��", 95, 93)
	);
	
	public static void printString( Function<��4_Student, String> function ) {
		for(��4_Student student : list) {
			System.out.println(function.apply(student));
		}
		System.out.println();
	}
	
	public static void printInt( ToIntFunction<��4_Student> function) {
		for(��4_Student student : list) {
			System.out.println(function.applyAsInt(student));
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("[ �л� �̸� ]");
		printString( t -> t.getName() );
		
		System.out.println("[ ���� ���� ]");
		printInt( t -> t.getEnglishScore() );
		
		System.out.println("[ ���� ���� ]");
		printInt( t -> t.getMathScore() );
	}
}
