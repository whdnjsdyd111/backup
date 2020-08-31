package 챕터04_조건문_반복문;

import java.util.Scanner;

public class ㅈ_Do_While_Though_Scanner {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input;

		System.out.println("메세지를 입력하세요");
		System.out.println("Q (q) 를 입력하면 종료합니다");

		do {
			System.out.print(" > ");
			input = sc.nextLine();
			System.out.println(input);
		} while (!input.equals("Q") && !input.equals("q"));

		System.out.println();
		System.out.println("시스템을 종료합니다.");
	}
}
