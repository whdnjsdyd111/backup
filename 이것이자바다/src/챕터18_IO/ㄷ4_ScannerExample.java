package é��18_IO;

import java.util.Scanner;

public class ��4_ScannerExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ� �Է�> ");
		String inputString = sc.nextLine();
		System.out.println(inputString);
		System.out.println();
		
		System.out.print("���� �Է�>");
		int inputInt = sc.nextInt();
		System.out.println(inputInt);
		System.out.println();
		
		System.out.print("�Ǽ� �Է�> ");
		double inputDouble = sc.nextDouble();
		System.out.println(inputDouble);
	}
}
