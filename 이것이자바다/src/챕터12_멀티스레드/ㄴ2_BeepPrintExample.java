package é��12_��Ƽ������;

public class ��2_BeepPrintExample {
	public static void main(String[] args) {		// ���� ������
		
		Runnable beepTask = new ��2_BeepTask();
		Thread thread = new Thread(beepTask);
		thread.start();								// �۾� ������
		
		for (int i = 0; i < 5; i++) {			
			System.out.println("��");
			
			try {
				Thread.sleep(500);		// 0.5�ʰ� �Ͻ�����
			} catch(Exception e){
				
			}
		}
	}
}
