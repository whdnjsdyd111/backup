package 챕터12_멀티스레드;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ㅈ2_CompletionServiceExample {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);

		System.out.println("[ 작업 처리 요청 ]");
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
	
		System.out.println("[ 처리 완료된 작업 확인 ]");
		executorService.submit(new Runnable() {
			@Override
			public void run() {
				int n = 0;
				while (true) {
					try {
						Future<Integer> future = completionService.take();
						int value = future.get();
						System.out.println("[ 처리 결과 ] " + value);
						n++;
						if(n == 3)
							executorService.shutdownNow();
					} catch (Exception e) {
						System.out.println("[ 작업 종료 ]");
						break;
					}
				}
			}
		});
		
		
	}
}
