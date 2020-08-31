package 챕터12_멀티스레드;

public class ㄴ4_ThreadA extends Thread {
	public ㄴ4_ThreadA() {
		setName("ThreadA");
	}
	
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "가 출력한 내용");
		}
	}
}
