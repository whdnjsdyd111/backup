package 챕터12_멀티스레드;

public class ㄷ1_PriorityExample {
	public static void main(String[] args) {
		
		for (int i = 1; i <= 10; i++) {
			
			Thread thread = new ㄷ1_CalcThread("thread" + i);
			
			if(i != 10) {
				thread.setPriority(Thread.MIN_PRIORITY);
			} else {
				thread.setPriority(Thread.MAX_PRIORITY);
			}
			
			thread.start();
			
		}
		
	}
}
