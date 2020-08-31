package 챕터04_조건문_반복문;

public class Question03_Equation {
	public static void main(String[] args) {

		int x = 4;

		for (int i = 1; i <= 15; i++) {
			for (int j = 1; j <= 12; j++) {

				int y = 5;

				if ((x * i) + (y * j) == 60) {
					System.out.printf("(%d, %d)\n", i, j);
				}

			}
		}

	}
}
