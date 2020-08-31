package 챕터12_멀티스레드;

public class ㅅ1_DaemonExample {
	public static void main(String[] args) {
		ㅅ1_AutoSaveThread autoSaveThread = new ㅅ1_AutoSaveThread();
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println("메인 스레드 종료");
	}
}
