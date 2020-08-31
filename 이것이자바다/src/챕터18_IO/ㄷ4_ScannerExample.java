package 챕터18_IO;

import java.util.Scanner;

public class ㄷ4_ScannerExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력> ");
		String inputString = sc.nextLine();
		System.out.println(inputString);
		System.out.println();
		
		System.out.print("정수 입력>");
		int inputInt = sc.nextInt();
		System.out.println(inputInt);
		System.out.println();
		
		System.out.print("실수 입력> ");
		double inputDouble = sc.nextDouble();
		System.out.println(inputDouble);
	}
}
