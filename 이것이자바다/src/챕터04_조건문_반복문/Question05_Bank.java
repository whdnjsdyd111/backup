package 챕터04_조건문_반복문;

import java.util.Scanner;

public class Question05_Bank {
	public static void main(String[] args) {

		boolean run = true;
		
		int balance = 0;
		int money = 0;
		int option = 0;

		Scanner sc = new Scanner(System.in);

		while (run) {

			System.out.println("--------------------");
			System.out.println("1.예금ㅣ2.출금ㅣ3.잔고ㅣ4.종료ㅣ");
			System.out.println("--------------------");
			System.out.print("선택> ");

			option = sc.nextInt();

			switch (option) {
			case 1:
				System.out.print("예금액> ");
				money = sc.nextInt();
				System.out.println();
				balance += money;
				break;
			case 2:
				System.out.print("출금액> ");
				money = sc.nextInt();
				System.out.println();
				balance -= money;
				break;
			case 3:
				System.out.print("잔고액> ");
				System.out.println(balance);
				System.out.println();
				break;
			case 4:
				System.out.println();
				System.out.println("프로그램 종료");
				run = false;
				break;
			default:
				System.out.println("다시 선택하시오.");
				System.out.println();
			}
		}
	}
}