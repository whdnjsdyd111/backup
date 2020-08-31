package 챕터12_멀티스레드;

public class ㅇ2_ThreadGroupExample {
	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("Group1");
		
		ㅇ2_WorkThread workThreadA = new ㅇ2_WorkThread(group, "workThreadA");
		ㅇ2_WorkThread workThreadB = new ㅇ2_WorkThread(group, "workThreadB");
		
		workThreadA.start();
		workThreadB.start();
		
		System.out.println("[ main 스레드 그룹의 list() 메소드 출력 내용 ]");
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		mainGroup.list();
		System.out.println();
		
		try { Thread.sleep(3000); } catch (InterruptedException e) {}
		
		System.out.println("[ Group1 스레드 그룹의 interrupt() 메소드 호출 ]");
		group.interrupt();
	}
}
