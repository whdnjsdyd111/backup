package é��12_��Ƽ������;

public class ��7_InterruptExample {
	public static void main(String[] args) {
		Thread thread = new ��7_PrintThread2();
		thread.start();
		
		try { Thread.sleep(1000); } catch(InterruptedException e) {}
		
		thread.interrupt();
	}
}
