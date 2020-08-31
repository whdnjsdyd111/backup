package é��12_��Ƽ������;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ��3_CallbackExample {
	private ExecutorService executorService;

	public ��3_CallbackExample() {
		executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()
		);
	}
	
	private CompletionHandler<Integer, Void> callback =
		new CompletionHandler<Integer, Void>(){
		@Override
		public void completed(Integer result, Void attachment) {	// (���Ÿ��, ÷��Ÿ��)
			System.out.println("completed() ����: " + result);
		}
		
		@Override
		public void failed(Throwable exc, Void attachment) {		// (����Ÿ��, ÷��Ÿ��)
			System.out.println("failed() ���� : " + exc.toString());
		}
	};																// �ݹ� �޼ҵ带 ���� CompletionHandler ��ü ����
	
	public void doWork(final String x, final String y) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					int intX = Integer.parseInt(x);
					int intY = Integer.parseInt(y);
					int result = intX + intY;
					callback.completed(result, null);				// ���� ó�� ���� ��� ȣ��
				} catch(NumberFormatException e) {
					callback.failed(e, null);						// ���ܰ� �߻����� ��� ȣ��
				}
			}
		};
		
		executorService.submit(task);								// ������Ǯ���� �۾� ó�� ��û
	}
	
	public void finish() {
		executorService.shutdown();									// ������Ǯ ����
	}
	
	public static void main(String[] args) {
		��3_CallbackExample callback = new ��3_CallbackExample();
		callback.doWork("3", "3");
		callback.doWork("3", "��");
		callback.finish();
		
		
	}
}
