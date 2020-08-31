package 챕터12_멀티스레드;

public class ㅂ3_JoinExample {
	public static void main(String[] args) {
		ㅂ3_SumThread sumThread = new ㅂ3_SumThread();
		sumThread.start();
		
		try {
			sumThread.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println("1~100 합: " + sumThread.getSum());
	}
}
