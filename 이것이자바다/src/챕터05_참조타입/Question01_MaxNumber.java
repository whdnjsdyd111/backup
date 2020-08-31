package 챕터05_참조타입;

public class Question01_MaxNumber {
	public static void main(String[] args) {
		
		
		int[] array = { 10, 5, 3, 8, 2 };
		int max = 0;
		
		for(int compare : array) {
			if(compare >= max)
				max = compare;
		}
		
		System.out.println(max);
		
	}
}
