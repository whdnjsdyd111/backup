package 챕터06_클래스;

public class Question19Example {
	public static void main(String[] args) {
		Question19 q = new Question19();
		
		q.setBalance(10000);
		System.out.println("현재 잔고: " + q.getBalance());
		
		q.setBalance(-100);
		System.out.println("현재 잔고: " + q.getBalance());
		
		q.setBalance(2000000);
		System.out.println("현재 잔고: " + q.getBalance());
		
		q.setBalance(300000);
		System.out.println("현재 잔고: " + q.getBalance());
	}
}
