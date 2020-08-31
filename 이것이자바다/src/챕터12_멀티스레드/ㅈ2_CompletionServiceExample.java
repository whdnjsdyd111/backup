package é��12_��Ƽ������;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ��2_CompletionServiceExample {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);

		System.out.println("[ �۾� ó�� ��û ]");
		for (int i = 0; i < 3; i++) {
			completionService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for (int i = 1; i <= 1000; i++) {
						sum += i;
					}
					return sum;
				}
			});
		}
	
		System.out.println("[ ó�� �Ϸ�� �۾� Ȯ�� ]");
		executorService.submit(new Runnable() {
			@Override
			public void run() {
				int n = 0;
				while (true) {
					try {
						Future<Integer> future = completionService.take();
						int value = future.get();
						System.out.println("[ ó�� ��� ] " + value);
						n++;
						if(n == 3)
							executorService.shutdownNow();
					} catch (Exception e) {
						System.out.println("[ �۾� ���� ]");
						break;
					}
				}
			}
		});
		
		
	}
}
