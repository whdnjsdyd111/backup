package é��12_��Ƽ������;

import java.util.Map;
import java.util.Set;

public class ��1_ThreadInfoExample {
	public static void main(String[] args) {

		��1_AutoSaveThread autoSaveThread = new ��1_AutoSaveThread();
		autoSaveThread.setName("AutoSaveThread");
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();

		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		Set<Thread> threads = map.keySet();

		for (Thread thread : threads) {
			System.out.println("Name : " + thread.getName() + (thread.isDaemon() ? "(����)" : "(��)"));
			System.out.println("\t" + "�Ҽ� �׷�: " + thread.getThreadGroup().getName());
			System.out.println();
		}

	}
}
