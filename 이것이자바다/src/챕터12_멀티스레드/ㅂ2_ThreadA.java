package é��12_��Ƽ������;

public class ��2_ThreadA extends Thread {
	public boolean stop = false;	// ���� �÷���
	public boolean work = true;		// �۾� ���� ���� �÷���
	
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println("ThreadA �۾� ����");
			} else {
				Thread.yield();
			}
		}
		
		System.out.println("ThreadA ����");
		
	}
}
