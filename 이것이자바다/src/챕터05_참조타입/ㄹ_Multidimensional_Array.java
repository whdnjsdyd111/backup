package é��05_����Ÿ��;

public class ��_Multidimensional_Array {
	public static void main(String[] args) {

		int[][] scores = new int[3][3];

		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				scores[j][i] = (int) (Math.random() * 51) + 50;
				System.out.print(scores[j][i] + "   ");
			}
			System.out.println();
		}
	}
}
