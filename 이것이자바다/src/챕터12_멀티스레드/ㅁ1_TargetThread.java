package 챕터12_멀티스레드;

public class ㅁ1_TargetThread extends Thread {
	public void run() {
		for(long i = 0; i < 1000000000; i++) {
			
		}
		
		try {
			// 1.5초간 정지
			Thread.sleep(1500);
		} catch(Exception e) {
			
		}
		
		for(long i = 0; i < 1000000000; i++) {
			
		}
	}
}
