package é��12_��Ƽ������;

public class ��8_InterruptExample {
	public static void main(String[] args) {
		Thread thread = new ��8_PrintThread2();
		thread.start();
		
		try { Thread.sleep(1000); } catch(InterruptedException e) {}
		
		thread.interrupt();
	}
}
