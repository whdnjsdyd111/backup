package é��12_��Ƽ������;

public class ��2_ThreadGroupExample {
	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("Group1");
		
		��2_WorkThread workThreadA = new ��2_WorkThread(group, "workThreadA");
		��2_WorkThread workThreadB = new ��2_WorkThread(group, "workThreadB");
		
		workThreadA.start();
		workThreadB.start();
		
		System.out.println("[ main ������ �׷��� list() �޼ҵ� ��� ���� ]");
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		mainGroup.list();
		System.out.println();
		
		try { Thread.sleep(3000); } catch (InterruptedException e) {}
		
		System.out.println("[ Group1 ������ �׷��� interrupt() �޼ҵ� ȣ�� ]");
		group.interrupt();
	}
}
