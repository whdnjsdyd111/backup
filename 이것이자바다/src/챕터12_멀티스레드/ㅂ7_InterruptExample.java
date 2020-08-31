package 챕터12_멀티스레드;

public class ㅂ7_InterruptExample {
	public static void main(String[] args) {
		Thread thread = new ㅂ7_PrintThread2();
		thread.start();
		
		try { Thread.sleep(1000); } catch(InterruptedException e) {}
		
		thread.interrupt();
	}
}
