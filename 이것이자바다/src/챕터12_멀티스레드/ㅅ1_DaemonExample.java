package é��12_��Ƽ������;

public class ��1_DaemonExample {
	public static void main(String[] args) {
		��1_AutoSaveThread autoSaveThread = new ��1_AutoSaveThread();
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println("���� ������ ����");
	}
}
