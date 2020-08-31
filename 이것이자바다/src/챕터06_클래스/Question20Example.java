package é��06_Ŭ����;

import java.util.Scanner;

public class Question20Example {
	private static Question20[] accountArray = new Question20[100];
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean run = true;
		
		while(run) {
			
			System.out.println("������������������������������������������������������������������������������������������");
			System.out.println("��1.���»���    | 2.���¸�� | 3.����   | 4.���   | 5. ���� ��");
			System.out.println("������������������������������������������������������������������������������������������");
			System.out.print("���� > ");
			
			int selectNo = sc.nextInt();
			
			if(selectNo == 1) {
				createAccount();
			} else if(selectNo == 2) {
				accountList();
			} else if(selectNo == 3) {
				deposit();
			} else if(selectNo == 4) {
				withdraw();
			} else if(selectNo == 5) {
				run = false;
			} else {
				System.out.println("�߸� �Է� �ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
				continue;
			}
		}
		
		System.out.println("���α׷� ����");
		
	}
	
	private static void createAccount() {
		
		System.out.println("����������������������");
		System.out.println("��  ���»���    ��");
		System.out.println("����������������������");
		
		System.out.print("���¹�ȣ: ");
		String ano = sc.next();
		
		System.out.print("������: ");
		String owner = sc.next();
		
		
		System.out.print("�ʱ��Աݾ�: ");
		int balance = sc.nextInt();
		
		Question20 q = new Question20(ano, owner, balance);
		
		for (int i = 0; i < accountArray.length; i++) {
			if(accountArray[i] == null) {
				accountArray[i] = q;
				break;
			}
		}
		
		System.out.println("���°� �����Ǿ����ϴ�.");
	}
	
	private static void accountList() {
		
		System.out.println("����������������������");
		System.out.println("��  ���¸��    ��");
		System.out.println("����������������������");
		
		for (int i = 0; i < accountArray.length; i++) {
			if(accountArray[i] == null)
				break;
			
			System.out.println(accountArray[i].getAno() + "\t" + accountArray[i].getOwner()
					+ "\t" + accountArray[i].getBalance());
			
		}
	}
	
	private static void deposit() {
		System.out.println("����������������");
		System.out.println("��  ����   ��");
		System.out.println("����������������");
		
		System.out.print("���¹�ȣ: ");
		String ano = sc.next();
		
		Question20 q = findAccount(ano);
		
		if(q == null) {
			System.out.println("ã���ô� ���´� �����ϴ�.");
			return;
		}
		
		System.out.print("���ݾ�: ");
		int balance = sc.nextInt();
		
		q.setBalance(q.getBalance() + balance);
		
		System.out.println("������ �����Ǿ����ϴ�.");
	}
	
	private static void withdraw() {
		System.out.println("����������������");
		System.out.println("��  ���   ��");
		System.out.println("����������������");
		
		System.out.print("���¹�ȣ: ");
		String ano = sc.next();
		
		Question20 q = findAccount(ano);
		
		if(q == null) {
			System.out.println("ã���ô� ���´� �����ϴ�.");
			return;
		}
		
		System.out.print("��ݾ�: ");
		int balance = sc.nextInt();
		
		q.setBalance(q.getBalance() - balance);
		
		System.out.println("����� �����Ǿ����ϴ�.");
	}
	
	private static Question20 findAccount(String ano) {
		for (int i = 0; i < accountArray.length; i++) {
			if(accountArray[i] != null) {
				if(accountArray[i].getAno().equals(ano))
					return accountArray[i];
			}
		}
		
		return null;
	}
}
