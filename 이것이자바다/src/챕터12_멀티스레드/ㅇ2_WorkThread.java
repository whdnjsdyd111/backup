package é��12_��Ƽ������;

public class ��2_WorkThread extends Thread {
	public ��2_WorkThread(ThreadGroup threadGroup, String ThreadName) {
		super(threadGroup, ThreadName);
	}										// ������ �׷�� ������ �̸��� ����
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(getName() + " interrupted");
				break;
			}
		}
		
		System.out.println(getName() + " �����");
	}
}
