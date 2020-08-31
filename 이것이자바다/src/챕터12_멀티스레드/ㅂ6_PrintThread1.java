package 챕터12_멀티스레드;

public class ㅂ6_PrintThread1 extends Thread {
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	public void run() {
		while( !stop ) {
			System.out.println("실행 중");
		}
										// stop이 true가 될 때 자원을 정리
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}
