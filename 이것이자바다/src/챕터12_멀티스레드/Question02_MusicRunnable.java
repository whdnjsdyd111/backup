package é��12_��Ƽ������;

public class Question02_MusicRunnable implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("������ ����մϴ�.");
			try { Thread.sleep(1000); } catch (Exception e) {}
		}
	}
}
