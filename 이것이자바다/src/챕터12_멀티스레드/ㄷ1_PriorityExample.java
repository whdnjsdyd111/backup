package é��12_��Ƽ������;

public class ��1_PriorityExample {
	public static void main(String[] args) {
		
		for (int i = 1; i <= 10; i++) {
			
			Thread thread = new ��1_CalcThread("thread" + i);
			
			if(i != 10) {
				thread.setPriority(Thread.MIN_PRIORITY);
			} else {
				thread.setPriority(Thread.MAX_PRIORITY);
			}
			
			thread.start();
			
		}
		
	}
}
