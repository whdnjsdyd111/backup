package 챕터12_멀티스레드;

public class ㄹ1_MainThreadExample {
	public static void main(String[] args) {
		ㄹ1_Calculator calculator = new ㄹ1_Calculator();
		
		ㄹ1_User1 user1 = new ㄹ1_User1();
		user1.setCalculator(calculator);
		user1.start();
		
		ㄹ1_User2 user2 = new ㄹ1_User2();
		user2.setCalculator(calculator);
		user2.start();
	}
}
