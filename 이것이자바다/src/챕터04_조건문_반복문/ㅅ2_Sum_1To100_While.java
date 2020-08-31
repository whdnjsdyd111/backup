package 챕터04_조건문_반복문;

public class ㅅ2_Sum_1To100_While {
	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		
		while(i <= 100) {
			sum += i;
			i++;
		}
		
		System.out.println(sum);
	}
}
