package 챕터12_멀티스레드;

public class ㅂ6_StopFlagExample {
	public static void main(String[] args) {
		ㅂ6_PrintThread1 printThread = new ㅂ6_PrintThread1();
		printThread.start();
		
		try { Thread.sleep(1000); } catch (InterruptedException e) { }
		
		printThread.setStop(true);
	}
}
