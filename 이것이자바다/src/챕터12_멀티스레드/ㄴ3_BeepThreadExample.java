package é��12_��Ƽ������;

public class ��3_BeepThreadExample {
	public static void main(String[] args) {
		Thread thread = new ��3_BeepThread();
		thread.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("��");
			
			try {
				Thread.sleep(500);		// 0.5�ʰ� �Ͻ�����
			} catch(Exception e){
				
			}
		}
		
		try {
			Thread.sleep(500);		// 0.5�ʰ� �Ͻ�����
			System.out.println(thread.isAlive());
		
		} catch(Exception e){
			
		}
	}
}
