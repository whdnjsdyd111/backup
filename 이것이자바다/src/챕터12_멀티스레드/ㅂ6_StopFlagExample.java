package é��12_��Ƽ������;

public class ��6_StopFlagExample {
	public static void main(String[] args) {
		��6_PrintThread1 printThread = new ��6_PrintThread1();
		printThread.start();
		
		try { Thread.sleep(1000); } catch (InterruptedException e) { }
		
		printThread.setStop(true);
	}
}
