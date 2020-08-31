package é��10_����ó��;

public class ��2_Account {
	private long balance;
	
	public ��2_Account() {}
	
	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) throws ��1_BalanceInsufficientException {
		
		if(balance < money) {
			throw new ��1_BalanceInsufficientException("�ܰ� ����: " + (money - balance) + "���ڶ�");
		}
		
		balance -= money;
		
		
	}
}
