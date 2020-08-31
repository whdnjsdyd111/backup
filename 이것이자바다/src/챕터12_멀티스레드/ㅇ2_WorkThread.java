package 챕터12_멀티스레드;

public class ㅇ2_WorkThread extends Thread {
	public ㅇ2_WorkThread(ThreadGroup threadGroup, String ThreadName) {
		super(threadGroup, ThreadName);
	}										// 스레드 그룹과 스레드 이름을 설정
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(getName() + " interrupted");
				break;
			}
		}
		
		System.out.println(getName() + " 종료됨");
	}
}
