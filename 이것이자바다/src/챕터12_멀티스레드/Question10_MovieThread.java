package é��12_��Ƽ������;

public class Question10_MovieThread extends Thread {
	@Override
	public void run() {
		while(true) {
			System.out.println("�������� ����մϴ�.");
			try { Thread.sleep(1000); } catch (InterruptedException e) {} 
		}
	}
}
