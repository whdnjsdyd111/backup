package é��12_��Ƽ������;

public class ��1_MainThreadExample {
	public static void main(String[] args) {
		��1_Calculator calculator = new ��1_Calculator();
		
		��1_User1 user1 = new ��1_User1();
		user1.setCalculator(calculator);
		user1.start();
		
		��1_User2 user2 = new ��1_User2();
		user2.setCalculator(calculator);
		user2.start();
	}
}
