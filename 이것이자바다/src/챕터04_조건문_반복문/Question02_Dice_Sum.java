package 챕터04_조건문_반복문;

public class Question02_Dice_Sum {
	public static void main(String[] args) {

		while (true) {
			int dice1 = (int) (Math.random() * 6) + 1;
			int dice2 = (int) (Math.random() * 6) + 1;

			System.out.println("(" + dice1 + ", " + dice2 + ")");

			if ((dice1 + dice2) == 5) {
				break;
			}
		}
	}
}
