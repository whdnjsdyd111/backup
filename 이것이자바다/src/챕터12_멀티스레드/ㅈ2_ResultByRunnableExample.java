package 챕터12_멀티스레드;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ㅈ2_ResultByRunnableExample {
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()	
		);
		
		class Result {
			int accumValue;
			
			synchronized void addValue(int value) {
				accumValue += value;
			}
		}									// 처리 결과를 저장하는 Result 클래스
		
		System.out.println("[ 작업 처리 요청 ]");
		class Task implements Runnable {
			Result result;
			
			Task(Result result) {
				this.result = result;
			}								// 외부 Result 객체를 필드에 저장
			
			@Override
			public void run() {
				
				int sum = 0;
				
				for (int i = 1; i <= 10; i++) {
					sum += i;
				}
				
				result.addValue(sum);
				
			}								// Result 객체에 작업 결과 저장
		}
		
		Result result = new Result();
		Runnable task1 = new Task(result);
		Runnable task2 = new Task(result);
		
		Future<Result> future1 = executorService.submit(task1, result);
		Future<Result> future2 = executorService.submit(task2, result);
		
		try {
			result = future1.get();
			result = future2.get();
			System.out.println("[ 처리 결과 ] " + result.accumValue);
			System.out.println("[ 작업 처리 완료 ]");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ 실행 예외 발생 ] " + e.getMessage());
		}	
	}
}
