package 챕터10_예외처리;

public class ㅇ1_AccountExample {
	public static void main(String[] args) {
		
		ㅅ2_Account account = new ㅅ2_Account();
		
		// 예금하기
		account.deposit(10000);
		System.out.println("예금액: " + account.getBalance());
		
		// 출금하기
		try {
			account.withdraw(30000);
		} catch (ㅅ1_BalanceInsufficientException e) {
			String message = e.getMessage();
			System.out.println(message);
			System.out.println();
			e.printStackTrace();
		}
		
	}
}
