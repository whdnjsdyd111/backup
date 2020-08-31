package 챕터04_조건문_반복문;

public class Question01_3Multiple {
	public static void main(String[] args) {

		int sum = 0;

		for (int i = 3; i <= 100; i += 3)
			sum += i;

		System.out.println(sum);
	}
}
