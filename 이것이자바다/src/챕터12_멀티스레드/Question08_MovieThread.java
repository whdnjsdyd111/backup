package é��12_��Ƽ������;

public class Question08_MovieThread extends Thread {
	@Override
	public void run() {
		while(true) {
			
			System.out.println("�������� ����մϴ�.");
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				break;
			}
		}
	}
}
