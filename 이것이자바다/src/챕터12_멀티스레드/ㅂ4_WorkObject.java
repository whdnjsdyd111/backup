package é��12_��Ƽ������;

public class ��4_WorkObject {
	public synchronized void methodA() {
		System.out.println("ThreadA�� methodA() �۾� ����");
		
		notify();		// �Ͻ� ���� ���¿� �ִ� ThreadB�� ���� ��� ���·� ����
		
		try {
			wait();		// ThreadA�� �Ͻ� ���� ���·� ����
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	public synchronized void methodB() {
		System.out.println("ThreadB�� methodB() �۾� ����");
		
		notify();		// �Ͻ� ���� ���¿� �ִ� ThreaA�� ���� ��� ���·� ����
		
		try {
			wait();		// ThreadB�� �Ͻ� ���� ���·� ����
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}
