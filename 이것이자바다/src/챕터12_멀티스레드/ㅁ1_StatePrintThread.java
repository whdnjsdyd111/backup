package 챕터12_멀티스레드;

public class ㅁ1_StatePrintThread extends Thread{
	private Thread targetThread;
	
	public ㅁ1_StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}
	
	public void run() {
		
		while(true) {
			
			Thread.State state = targetThread.getState();	// 스레드 상태 얻기
			System.out.println("타겟 스레드 상태: " + state);
			
			if(state == Thread.State.NEW) {
				targetThread.start(); 						// 객체 생성 상태일 경우 실행 대기 상태로 만듬
			}
			
			if(state == Thread.State.TERMINATED) {
				break;
			}
			
			try {
				// 0.5초간 일시 정지
				Thread.sleep(500);
			} catch(Exception e) {
				
			}
			
		}
		
	}
}
