package é��12_��Ƽ������;

public class Question10_ThreadExample {
	public static void main(String[] args) {
		Thread thread = new Question10_MovieThread();
		thread.setDaemon(true);
		thread.start();
		
		try { Thread.sleep(3000); } catch (InterruptedException e) {}
	}
}
