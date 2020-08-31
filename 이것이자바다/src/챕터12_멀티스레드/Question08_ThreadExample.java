package 챕터12_멀티스레드;

public class Question08_ThreadExample {
	public static void main(String[] args) {
		Thread thread = new Question08_MovieThread();
		thread.start();
		
		try { Thread.sleep(1000); } catch (InterruptedException e) {}
		
		thread.interrupt();
	}
}
