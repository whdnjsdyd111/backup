package é��12_��Ƽ������;

public class ��2_Calculator {
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		
		try {
			Thread.sleep(2000);		// 2�ʰ� �Ͻ� ����
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(Thread.currentThread().getName() + ": " + this.memory);
	}
}
