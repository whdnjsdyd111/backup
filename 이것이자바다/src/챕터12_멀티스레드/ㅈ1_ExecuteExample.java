package é��12_��Ƽ������;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ��1_ExecuteExample {
	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(2);	// �ִ� �����尡 2�� ������Ǯ ����
		
		for (int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					// ������ �� ���� �� �۾� ������ �̸� ���
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
					int poolSize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("[ �� ������ ����: " + poolSize + "] �۾� ������ �̸�: " + threadName);
					
					// ���� �߻� ��Ŵ
					int value = Integer.parseInt("��");
				}
			};
			
			executorService.execute(runnable);
			//executorService.submit(runnable);
			
			Thread.sleep(100);
		}
		
		executorService.shutdown();
	}
}
