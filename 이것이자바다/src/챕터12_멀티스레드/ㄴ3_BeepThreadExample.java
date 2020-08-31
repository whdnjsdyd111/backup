package 챕터12_멀티스레드;

public class ㄴ3_BeepThreadExample {
	public static void main(String[] args) {
		Thread thread = new ㄴ3_BeepThread();
		thread.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			
			try {
				Thread.sleep(500);		// 0.5초간 일시정지
			} catch(Exception e){
				
			}
		}
		
		try {
			Thread.sleep(500);		// 0.5초간 일시정지
			System.out.println(thread.isAlive());
		
		} catch(Exception e){
			
		}
	}
}
