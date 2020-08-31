package 챕터06_클래스;

import java.util.Scanner;

public class Question20Example {
	private static Question20[] accountArray = new Question20[100];
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean run = true;
		
		while(run) {
			
			System.out.println("┌─────────┬─────────┬───────┬───────┬───────┐");
			System.out.println("│1.계좌생성    | 2.계좌목록 | 3.예금   | 4.출금   | 5. 종료 │");
			System.out.println("└─────────┴─────────┴───────┴───────┴───────┘");
			System.out.print("선택 > ");
			
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
				System.out.println("잘못 입력 하셨습니다. 다시 입력하세요.");
				continue;
			}
		}
		
		System.out.println("프로그램 종료");
		
	}
	
	private static void createAccount() {
		
		System.out.println("┌─────────┐");
		System.out.println("│  계좌생성    ┃");
		System.out.println("└─────────┘");
		
		System.out.print("계좌번호: ");
		String ano = sc.next();
		
		System.out.print("계좌주: ");
		String owner = sc.next();
		
		
		System.out.print("초기입금액: ");
		int balance = sc.nextInt();
		
		Question20 q = new Question20(ano, owner, balance);
		
		for (int i = 0; i < accountArray.length; i++) {
			if(accountArray[i] == null) {
				accountArray[i] = q;
				break;
			}
		}
		
		System.out.println("계좌가 생성되었습니다.");
	}
	
	private static void accountList() {
		
		System.out.println("┌─────────┐");
		System.out.println("│  계좌목록    ┃");
		System.out.println("└─────────┘");
		
		for (int i = 0; i < accountArray.length; i++) {
			if(accountArray[i] == null)
				break;
			
			System.out.println(accountArray[i].getAno() + "\t" + accountArray[i].getOwner()
					+ "\t" + accountArray[i].getBalance());
			
		}
	}
	
	private static void deposit() {
		System.out.println("┌──────┐");
		System.out.println("│  예금   ┃");
		System.out.println("└──────┘");
		
		System.out.print("계좌번호: ");
		String ano = sc.next();
		
		Question20 q = findAccount(ano);
		
		if(q == null) {
			System.out.println("찾으시는 계좌는 없습니다.");
			return;
		}
		
		System.out.print("예금액: ");
		int balance = sc.nextInt();
		
		q.setBalance(q.getBalance() + balance);
		
		System.out.println("예금이 성공되었습니다.");
	}
	
	private static void withdraw() {
		System.out.println("┌──────┐");
		System.out.println("│  출금   ┃");
		System.out.println("└──────┘");
		
		System.out.print("계좌번호: ");
		String ano = sc.next();
		
		Question20 q = findAccount(ano);
		
		if(q == null) {
			System.out.println("찾으시는 계좌는 없습니다.");
			return;
		}
		
		System.out.print("출금액: ");
		int balance = sc.nextInt();
		
		q.setBalance(q.getBalance() - balance);
		
		System.out.println("출금이 성공되었습니다.");
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
