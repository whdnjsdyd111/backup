package é��12_��Ƽ������;

public class ��6_PrintThread1 extends Thread {
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	public void run() {
		while( !stop ) {
			System.out.println("���� ��");
		}
										// stop�� true�� �� �� �ڿ��� ����
		System.out.println("�ڿ� ����");
		System.out.println("���� ����");
	}
}
