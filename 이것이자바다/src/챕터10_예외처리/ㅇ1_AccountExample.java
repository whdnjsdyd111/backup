package é��10_����ó��;

public class ��1_AccountExample {
	public static void main(String[] args) {
		
		��2_Account account = new ��2_Account();
		
		// �����ϱ�
		account.deposit(10000);
		System.out.println("���ݾ�: " + account.getBalance());
		
		// ����ϱ�
		try {
			account.withdraw(30000);
		} catch (��1_BalanceInsufficientException e) {
			String message = e.getMessage();
			System.out.println(message);
			System.out.println();
			e.printStackTrace();
		}
		
	}
}
