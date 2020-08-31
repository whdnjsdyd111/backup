package 챕터04_조건문_반복문;

public class ㅋ_Continue {
	public static void main(String[] args) {

		for (int i = 0; i <= 10; i++) {

			if (i % 2 != 0)
				continue;

			System.out.println(i);

		}
	}
}
