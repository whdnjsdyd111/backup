package 챕터12_멀티스레드;

public class ㄴ4_ThreadNameExample {
	public static void main(String[] args) {
		
		Thread threadMain = Thread.currentThread();		// 이 코드를 실행하는 스레드 객체 얻기
		System.out.println("프로그램 시작 스레드: " + threadMain.getName());
		
		Thread threadA = new ㄴ4_ThreadA();
		threadA.run();
		
		Thread threadB = new ㄴ4_ThreadB();
		threadB.run();
		
		
		
	}
}
