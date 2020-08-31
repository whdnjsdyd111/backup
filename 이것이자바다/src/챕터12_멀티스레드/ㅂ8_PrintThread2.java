package 챕터12_멀티스레드;

public class ㅂ8_PrintThread2 extends Thread {
	public void run() {
		while(true) {
			System.out.println("실행 중");
			
			if(Thread.interrupted())
				break;
		}
		
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}
