package é��04_���ǹ�_�ݺ���;

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
			System.out.println("1.���ݤ�2.��ݤ�3.�ܰ��4.�����");
			System.out.println("--------------------");
			System.out.print("����> ");

			option = sc.nextInt();

			switch (option) {
			case 1:
				System.out.print("���ݾ�> ");
				money = sc.nextInt();
				System.out.println();
				balance += money;
				break;
			case 2:
				System.out.print("��ݾ�> ");
				money = sc.nextInt();
				System.out.println();
				balance -= money;
				break;
			case 3:
				System.out.print("�ܰ��> ");
				System.out.println(balance);
				System.out.println();
				break;
			case 4:
				System.out.println();
				System.out.println("���α׷� ����");
				run = false;
				break;
			default:
				System.out.println("�ٽ� �����Ͻÿ�.");
				System.out.println();
			}
		}
	}
}