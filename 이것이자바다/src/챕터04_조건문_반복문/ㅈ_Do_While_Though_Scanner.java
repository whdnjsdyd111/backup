package é��04_���ǹ�_�ݺ���;

import java.util.Scanner;

public class ��_Do_While_Though_Scanner {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input;

		System.out.println("�޼����� �Է��ϼ���");
		System.out.println("Q (q) �� �Է��ϸ� �����մϴ�");

		do {
			System.out.print(" > ");
			input = sc.nextLine();
			System.out.println(input);
		} while (!input.equals("Q") && !input.equals("q"));

		System.out.println();
		System.out.println("�ý����� �����մϴ�.");
	}
}
