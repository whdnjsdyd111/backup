package é��12_��Ƽ������;

public class ��3_JoinExample {
	public static void main(String[] args) {
		��3_SumThread sumThread = new ��3_SumThread();
		sumThread.start();
		
		try {
			sumThread.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println("1~100 ��: " + sumThread.getSum());
	}
}
