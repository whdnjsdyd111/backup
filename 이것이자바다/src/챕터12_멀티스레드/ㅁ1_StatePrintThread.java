package é��12_��Ƽ������;

public class ��1_StatePrintThread extends Thread{
	private Thread targetThread;
	
	public ��1_StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}
	
	public void run() {
		
		while(true) {
			
			Thread.State state = targetThread.getState();	// ������ ���� ���
			System.out.println("Ÿ�� ������ ����: " + state);
			
			if(state == Thread.State.NEW) {
				targetThread.start(); 						// ��ü ���� ������ ��� ���� ��� ���·� ����
			}
			
			if(state == Thread.State.TERMINATED) {
				break;
			}
			
			try {
				// 0.5�ʰ� �Ͻ� ����
				Thread.sleep(500);
			} catch(Exception e) {
				
			}
			
		}
		
	}
}
