package é��12_��Ƽ������;

public class ��8_PrintThread2 extends Thread {
	public void run() {
		while(true) {
			System.out.println("���� ��");
			
			if(Thread.interrupted())
				break;
		}
		
		System.out.println("�ڿ� ����");
		System.out.println("���� ����");
	}
}
