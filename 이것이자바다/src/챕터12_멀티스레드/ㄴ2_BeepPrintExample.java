package 챕터12_멀티스레드;

public class ㄴ2_BeepPrintExample {
	public static void main(String[] args) {		// 메인 스레드
		
		Runnable beepTask = new ㄴ2_BeepTask();
		Thread thread = new Thread(beepTask);
		thread.start();								// 작업 스레드
		
		for (int i = 0; i < 5; i++) {			
			System.out.println("띵");
			
			try {
				Thread.sleep(500);		// 0.5초간 일시정지
			} catch(Exception e){
				
			}
		}
	}
}
