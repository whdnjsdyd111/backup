package 챕터12_멀티스레드;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ㅈ3_CallbackExample {
	private ExecutorService executorService;

	public ㅈ3_CallbackExample() {
		executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()
		);
	}
	
	private CompletionHandler<Integer, Void> callback =
		new CompletionHandler<Integer, Void>(){
		@Override
		public void completed(Integer result, Void attachment) {	// (결과타입, 첨부타입)
			System.out.println("completed() 실행: " + result);
		}
		
		@Override
		public void failed(Throwable exc, Void attachment) {		// (예외타입, 첨부타입)
			System.out.println("failed() 실행 : " + exc.toString());
		}
	};																// 콜백 메소드를 가진 CompletionHandler 객체 생성
	
	public void doWork(final String x, final String y) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					int intX = Integer.parseInt(x);
					int intY = Integer.parseInt(y);
					int result = intX + intY;
					callback.completed(result, null);				// 정상 처리 했을 경우 호출
				} catch(NumberFormatException e) {
					callback.failed(e, null);						// 예외가 발생했을 경우 호출
				}
			}
		};
		
		executorService.submit(task);								// 스레드풀에게 작업 처리 요청
	}
	
	public void finish() {
		executorService.shutdown();									// 스레드풀 종료
	}
	
	public static void main(String[] args) {
		ㅈ3_CallbackExample callback = new ㅈ3_CallbackExample();
		callback.doWork("3", "3");
		callback.doWork("3", "삼");
		callback.finish();
		
		
	}
}
