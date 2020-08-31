package 챕터05_참조타입;

public class ㄴ_Generate_Array {
	public static void main(String[] args) {

		int[] scores = { 83, 90, 97 };
		String[] students = { "조원용", "원용", "용" };
		
		for(int i = 0; i < 3; i++) {
			
			System.out.println(students[i] + "의 점수 : " + scores[i]);
			
		}
	}
}
