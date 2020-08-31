package 챕터10_예외처리;

public class ㅅ2_Account {
	private long balance;
	
	public ㅅ2_Account() {}
	
	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) throws ㅅ1_BalanceInsufficientException {
		
		if(balance < money) {
			throw new ㅅ1_BalanceInsufficientException("잔고 부족: " + (money - balance) + "모자람");
		}
		
		balance -= money;
		
		
	}
}
