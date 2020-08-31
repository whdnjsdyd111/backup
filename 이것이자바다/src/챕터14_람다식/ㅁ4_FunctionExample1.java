package 챕터14_람다식;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class ㅁ4_FunctionExample1 {
	private static List<ㅁ4_Student> list = Arrays.asList(
		new ㅁ4_Student("홍길동", 90, 96),
		new ㅁ4_Student("신용권", 95, 93)
	);
	
	public static void printString( Function<ㅁ4_Student, String> function ) {
		for(ㅁ4_Student student : list) {
			System.out.println(function.apply(student));
		}
		System.out.println();
	}
	
	public static void printInt( ToIntFunction<ㅁ4_Student> function) {
		for(ㅁ4_Student student : list) {
			System.out.println(function.applyAsInt(student));
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("[ 학생 이름 ]");
		printString( t -> t.getName() );
		
		System.out.println("[ 영어 점수 ]");
		printInt( t -> t.getEnglishScore() );
		
		System.out.println("[ 수학 점수 ]");
		printInt( t -> t.getMathScore() );
	}
}
