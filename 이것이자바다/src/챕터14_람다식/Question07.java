package é��14_���ٽ�;

import java.util.function.Function;

public class Question07 {
	public static class Student {
		private String name;
		private int englishScore;
		private int mathScore;
		
		public Student(String name, int englishScore, int mathScore) {
			this.name = name;
			this.englishScore = englishScore;
			this.mathScore = mathScore;
		}
		
		public String getName() { return name;}
		public int getEnglishScore() { return englishScore; }
		public int getMathScore() { return mathScore; }
	}
	
	private static Student[] students = {
		new Student("ȫ�浿", 90, 96),
		new Student("�ſ��", 95, 93)
	};
	
	private static double avg( Function<Student, Integer> function ) {
		int sum = 0;
		for(Student student : students) {
			sum += function.apply(student);
		}
		
		return (double) sum / students.length;
	}
	
	public static void main(String[] args) {
		double englishAvg = avg( Student :: getEnglishScore );
		System.out.println("���� ��� ����: " + englishAvg);
		
		double mathAvg = avg( Student :: getMathScore );
		System.out.println("���� ��� ����: " + mathAvg)
		;
	}
}
