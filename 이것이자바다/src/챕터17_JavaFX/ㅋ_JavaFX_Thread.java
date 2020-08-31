package é��17_JavaFX;

public class ��_JavaFX_Thread {
	// JavaFX UI�� �����忡 �������� �ʱ� ������ UI�� �������� �ʰ� �����ϴ� �۾��� JavaFX Application Thread�� ����ϰ�, �ٸ� �۾��� ��������� UI�� �����ϰų� ������ �� ����.
	// main �����尡 Application�� launch() �޼ҵ带 ȣ���ϸ鼭 ������ JavaFX Application Thread�� start() �޼ҵ带 �����Ű�鼭 ��� UI�� �����Ѵ�.
	// ��Ʈ�ѿ��� �̺�Ʈ�� �߻��� ��� ��Ʈ�ѷ��� �̺�Ʈ ó�� �޼ҵ带 �����ϴ� �͵� JavaFX Application Thread�̴�.
	
	//		main Thread
	//			��
	//		launch()	����������	JavaFX Application Thread
	//										��
	//									start()
	//										��
	//								��������������������������
	//							UI����/����	��Ʈ�ѷ� ���� �� �̺�Ʈ ó��	��
	//								��							��
	//								����������������������x������������������������Worker Thread
	
	// JavaFX ���ø����̼��� ������ �� ������ ���� JavaFX Application Thread�� �ð��� ���ϴ� �۾��� ���� �ʵ��� �ϴ� ���̴�.
	// �ð��� ���ϴ� �۾��� �ϰ� �Ǹ� �� �ð� ���� UI�� �������� �ʰ� �����ִ� ���°� �Ǳ� ������ �ٸ� �۾� �����带 �����ؼ� ó���ϴ� ���� ����.
	// ���� ��� ������ �а� ���ų�, ��Ʈ��ũ�󿡼� �����͸� �ְ���� �� �󸶸�ŭ�� �ð��� �ʿ����� �𸣱� ������ �ݵ�� �۾� �����带 �����ؼ� ó���ؾ� �Ѵ�.
	// ������ �۾� �����尡 ���� UI�� ������ �� ���� ������ UI ������ �ʿ��� ��� �� ���� ������� �ذ��ؾ� �Ѵ�.
	// ù ��° ����� Platform.runLater() �޼ҵ带 �̿��ϴ� ���̰�, �� ��° ����� javafx.concurrent API�� Task �Ǵ� Service�� �̿��ϴ� ���̴�.
	
			//	Platform.runLater() Method
	
	// �۾� �����尡 ���� UI�� ������ �� ���� ������ UI ������ �ʿ��� ���, �۾� ������� UI ���� �ڵ带 Runnable�� �����ϰ�, �̰��� �Ű������� �ؼ� Platform�� ���� �޼ҵ��� runLater()�� ȣ���� �� �ִ�.
	
	//		���� Runnable ��ü ����						���ٽ� �̿�
	//
	//	Platform.runLater(new Runnable() {			Platform.runLater( () -> {
	//		@Override									// UI ���� �� ���� �ڵ�
	//		public void run() {						});
	//			// UI ���� �� ���� �ڵ�
	//		}
	//	}
	
	// runLater() �޼ҵ�� �̺�Ʈ ť(event queue)�� Runnable�� �����ϰ� ��� �����Ѵ�. �̺�Ʈ ť�� ����� Runnable���� ����� ������ ���� 
	// JavaFX Application Thread�� ���� �ϳ��� ���� ó���Ǿ� UI ���� �۾��� �Ѵ�. runLater()�� ���� ó����� ���� ������ �ִµ�, 
	// �־��� �Ű��� Runnable�� �ٷ� ó���Ǵ� ���� �ƴ϶� �̺�Ʈ ť�� ���� ����� Runnable�� ó���� �Ŀ� ó���ȴ�.
	
	//	������ A	��	�̺�Ʈť(EventQueue)
	//			��	��������������������������				JavaFX				������������������
	//	������ B	���������� ��		��	��	������������������	Application	���������� 	��UI ����	��
	//			�� :	��������������������������				Thread				����	����	��
	//	������ C	�� :		��	��   ��										������������������
	//			  :		Runnable ��ü
	//		Platform.runLater();
	
	// ���� ������ �۾� �����尡 0.1�� �ֱ�� �� �ð��� �̿��ؼ� JavaFX Application Thread�� Label ��Ʈ���� text �Ӽ��� �����Ѵ�.
	// Label�� UI ����̹Ƿ� �۾� �����忡�� setText() �޼ҵ�� text �Ӽ����� ������ �� ����. ��� Runnable�� �����ؼ� Platform.runLater() �޼ҵ带 ȣ���ߴ�.
	// JavaFX Application Thread�� �̺�Ʈ ť���� Runnable�� ��� �����ϰ� Label�� text() �Ӽ��� �����Ѵ�.
	
			//	Task Class
	
	// javafx.concurrent ��Ű���� JavaFX ���ø����̼� ���߿� ����� �� �ִ� ������ ���ü� API�� �����ϰ� �ִ�. �� ��Ű���� Worker �������̽��� �� ������ ���� Ŭ������ Task, Service�� �����Ǿ� �ִ�.
	
	//						Worker
	//				  �����������������覡����������������
	//				Task			Service
	
	// Worker �������̽��� Task�� Service���� ���������� ����� �� �ִ� �޼ҵ尡 ����Ǿ� �ִ�.
	// Task Ŭ������ JavaFX ���ø����̼ǿ��� �񵿱� �۾��� ǥ���� Ŭ�����̰�, Service�� �̷��� Task�� �����ϰ� ����, ���, ������� �� �ִ� ����� �����Ѵ�.
	
			/*	Task Creation		Task ����		*/
	
	// Task�� �۾� �����忡�� ����Ǵ� �ϳ��� �۾��� ǥ���� �߻� Ŭ�����̴�. �ϳ��� �۾��� ������ ������ Task�� ����ؼ� Ŭ������ ������ ��, call() �޼ҵ带 �������ϸ� �ȴ�.
	// call() �޼ҵ�� ���ϰ��� �ִµ� ���ϰ��� �۾� ����� ���Ѵ�. Task�� ���׸� Ÿ���ε�, Ÿ���Ķ���ʹ� �۾� ��� Ÿ���̴�. ��Ÿ���� call() �޼ҵ��� ���� Ÿ�԰� �����ؾ� �Ѵ�.
	// ������ �۾� ����� Integer�� Task�� ������ ���̴�.
	
	//	Task<Integer> task = new Task<Integer>() {
	//		@Override
	//		protected Integer call() throws Exception {
	//			int result = 0;
	//			// �۾� �ڵ� ...
	//			return result;
	//		}
	//	}
	
	// ���� ���ϰ��� ���� �۾��̶�� Ÿ�� �Ķ���ͷ� Void�� ����� �� �ִ�. �� ��� call() �޼ҵ��� ���ϰ��� null �̴�.
	
	//	Task<Void> task = new Task<Void>() {
	//		@Override
	//		protected Void call() throws Exception {
	//			// �۾� �ڵ�...
	//			return null;
	//		}
	//	}
	
			/*	Run Task	Task ����		*/
	
	// Task�� �۾� �����忡�� �����Ϸ��� �۾� �����带 ������ �� �Ű������� Task�� �����ϸ� �ȴ�. �̰��� Task�� Runnable �������̽��� �����ϰ� �ֱ� �����̴�.
	// ������ �۾� �����忡�� Task�� ó���ϴ� �ڵ��̴�.
	
	//	Task<Integer> task = new Task<Integer>() {...};
	//	Thread thread = new Thread(task);
	//	thread.setDaemon(true);
	//	thread.start();
	
	// Task�� ������Ǯ�� �۾� �����忡�� ó���Ϸ��� ExecutorService�� submit() �޼ҵ带 ȣ���� �� �Ű������� �����ϸ� �ȴ�.
	// ������ ������Ǯ(ExecutorService)���� Task�� ó���ϴ� �ڵ��̴�.
	
	//	Task<Integer> task = new Task<Integer>() {...};
	//	executorService.submit(task);
	
			/*	Cancel Task		Task ���		*/
	
	// Task�� cancel() �޼ҵ尡 ȣ��Ǹ� �������� ������ ���� �� �־�� �Ѵ�. �ݺ� �۾��� ���Ե� Task�� �ֱ������� isCancelled() �޼ҵ带 ȣ���ؼ� �۾��� ��� �Ǿ����� Ȯ���ϰ�,
	// �۾��� �����ؾ� �Ѵ�. cancel() �޼ҵ尡 ȣ��Ǹ� isCancelld()�� true�� �����Ѵ�.
		
	//	Task<Void> task = new Task<Void>() {
	//		@Override
	//		protected Void call() throws Exception {
	//			while(...) {
	//				if(isCancelled()) { break; }
	//				// �۾� �ڵ�...
	//			}
	//			return null;
	//		}
	//	};
	
	// ���� Task�� Thread.sleep()�� ���� ���ŷ�Ǿ� ���� ��, cancel() �޼ҵ尡 ȣ��Ǹ� InterruptedException�� �߻��Ѵ�.
	// �� ���, ���� ó������ isCancelled() �޼ҵ�� cancel() �޼ҵ尡 ȣ��� ������ Ȯ���ϰ� �۾��� �����ؾ� �Ѵ�.
	
	//	Task<Void> task = new Task<Void>() {
	//		@Override
	//		protected Void call() throws Exception {	
	//			while(...) {
	//				if(isCancelled()) { break; }
	//				// �۾� �ڵ�...
	//				try { Thread.sleep(100); } catch(InterruptedException interrupted) {
	//					if (isCancelled()) { break; }
	//				}
	//			}
	//			return null;
	//		}
	//	};
	
	// Task�� �� ���� ����� �� �ְ�, ������ �� ���� ������ �۾��� �Ϸ�Ǿ��ų� ��ҵ� �Ŀ� �۾��� ������Ϸ��� Task�� �ٽ� �����ؾ� �Ѵ�.
	
			/*	UI Change		UI ����	*/
	
	// Task�� call() �޼ҵ�� �۾� ������󿡼� ȣ��Ǳ� ������ UI ���� �ڵ带 �ۼ��� �� ����. ���� �ۼ��ϰ� �Ǹ� ��Ÿ�� ���ܰ� �߻��Ѵ�.
	// ��� call() �޼ҵ� ���ο����� updateProgress(), updateMessage() �޼ҵ带 ȣ���� �� �ִµ�, �� �޼ҵ���� JAvaFX Application Thread�� �Ͽ��� UI�� ������Ʈ�ϵ��� ���ش�.
	
			/*	|	updateProgress() Method		|	*/
	
	// �۾� �������� ���� ������ ProgressBar�� ��Ÿ���� ��찡 ���� �ִ�. Task�� progress �Ӽ��� ProgressBar�� progress �Ӽ��� ���ε��Ǿ� �ִٸ�,
	// �۾� �����忡�� updateProgress() �޼ҵ带 ȣ������ �� JavaFX Application Thread�� ProgressBar�� ���¸� �����Ѵ�.
	
	//	updateProgress(double workDone, double max);
	
	// updateProgress() �޼ҵ��� ù ��° �Ű����� ���� ���� �����̰�, �� ��° �Ű����� ���� �Ϸᰪ�̴�. �� �޼ҵ�� Task�� progress, totalWork, workDone �Ӽ��� ������Ʈ�Ѵ�.
	// ������ Task�� progress �Ӽ��� ProgressBar�� progress �Ӽ��� ���ε��ؼ� updateProgress()�� ȣ��� ������ ProgressBar�� progress �Ӽ����� �����ϴ� �ڵ��̴�.
	
	//	Task<Void> task = new Task<Void>() {
	//		@Override
	//		protected Void call() throws Exception {
	//			for (int i = 1; i <= 100; i++) {
	//				if (isCancelled()) { break; }
	//				// �۾� �ڵ�...
	//				updateProgress(i, 100);		// Task�� progress �Ӽ� ������Ʈ
	//			}
	//			return null;
	//		}
	//	};
	//
	//	// progress �Ӽ� ���ε�
	//	ProgressBar progressBar = new ProgressBar();
	//	progressBar.progressProperty().bind(task.progressProperty());	// �Ӽ� ���ε�
	//
	//	// �۾� ������ ����
	//	Thread thread = new Thread(task);
	//	thread.start();
	
			/*	|	updateMessage() Method	|	*/
	
	// �۾� ���� ���̰ų�, �۾��� ��ҵǾ��� ���, ���ڿ� �޼����� �����ؼ� UI�� �����ϰ� �ʹٸ� updateMessage()�� ȣ���� �� �ִ�.
	
	//	updateMessage(String message);
	
	// updateMessage()�� Task�� message �Ӽ��� ������Ʈ�Ѵ�. ���� Task�� message �Ӽ��� UI ��Ʈ���� ���ڿ� �Ӽ��� ���ε���ų �� �ִ�. 
	// ������ Task�� message �Ӽ��� Label�� text �Ӽ��� ���ε��ؼ� updateMessage()�� ȣ��� ������ Label�� text �Ӽ����� �����ϴ� �ڵ��̴�.
	
	//	Task<Void> task = new Task<Void>() {
	//		@Override
	//		protected Void call() throws Exception {	
	//			for (int i = 1; i <= 100; i++) {
	//				if( isCanelled() ) { break; }
	//				updateMessage( String.valueOf(i) );		// Task�� message �Ӽ� ������Ʈ
	//			}
	//			return null;
	//		}
	//	};
	//
	//	// ���ڿ� �Ӽ� ���ε�
	//	Label label = new Label();
	//	label.textProperty().bind(task.messageProperty());	// �Ӽ� ���ε�
	//
	//	// �۾� ������ ����
	//	Thread thread = new Thread(task);
	//	thread.start();
	
			/*	|	Platform.runLater() Method	|	*/
	
	// �ܼ��� ProgressBar �Ǵ� �ٸ� ��Ʈ���� ���ڿ� �Ӽ� ���ε��ϴ� �ͺ��� �� ������ UI ������ �ʿ��� ��쿡�� call() �޼ҵ� ������ Platform.runLater(new Runnable() {...})�� ȣ���ϸ� �ȴ�.
	
	//	Task<Integer> task = new Task<Integer>() {
	//		@Override
	//		protected Integer call() throws Exception {
	//			for(int i = 1; i <= 100; i++) {
	//				if(isCancelled()) { break; }
	//				Platform.runLater( () -> { // UI ���� �ڵ� } );
	//			}
	//			return result;
	//		}
	//	};
	//
	//	// �۾� ������ ����
	//	Thread thread = new Thread(task);
	//	thread.start();
	
	// ���� ������ �۾� �����尡 0.1�� �ֱ�� 0���� 100���� ī������ ���� ProgressBar�� progress �Ӽ� �� Label�� text �Ӽ��� ���ε��ؼ� UI�� �����Ѵ�.
	
			/*	Callback By Task Status		�۾� ���º� �ݹ�		*/
	
	// �۾��� ��� ó���ƴ����� ���� Task�� ���� �� ���� �޼ҵ� �� �ϳ��� �ڵ� ȣ��(�ݹ�) �ȴ�.
	
	//	�ݹ� �޼ҵ�			����
	//
	//	succeeded()		���������� call() �޼ҵ尡 ���ϵǾ��� ��	
	//	cancelled()		cancel() �޼ҵ�� �۾��� ��� �Ǿ��� ��
	//	failed()		���ܰ� �߻��Ǿ��� ��
	
	// �� �޼ҵ���� Task Ŭ������ �ۼ��� �� �������ؼ� ���ø����̼� �������� �籸���� �� �ִ�. �ָ��� ���� �� �޼ҵ���� �۾� ������󿡼� ȣ��Ǵ� ���� �ƴ϶�, 
	// JavaFX Application Thread�󿡼� ȣ��Ǳ� ������ �����ϰ� UI ���� �ڵ带 �ۼ��� �� �ִ�. �۾� ����� �ִ� Task�� ���(call() �޼ҵ尡 ���ϰ��� ���� ���)
	// succeeded() �޼ҵ带 �������ؼ� �ۿ� ����� ������ ���� ���� �� �ִ�. V�� call() �޼ҵ尡 �����ϴ� ���� Ÿ���̴�.
	
	//	@Override
	//	protected void succeeded() {
	//		V v = task.getValue();
	//	}
	
	// ���� ������ 0���� 100���� ���� ���ϴ� Task�� �ۼ��ϰ� �۾� �����忡�� �����Ų��. �۾� �Ϸ� ����� succeeded() �޼ҵ忡�� ��� Label ��Ʈ�ѿ� ��Ÿ����.
	
			//	Service Class
	
	// Service Ŭ������ �۾� ������󿡼� Task�� �����ϰ� ����, ���, ������� �� �ִ� ����� �����Ѵ�.
	// Service Ŭ������ ������ �۾� ������� JavaFX Application Thread�� �ùٸ��� ��ȣ�ۿ��� �� �� �ֵ��� �����ִ� ���̴�.
	
			/*	Service Creation	*/
	
	// Service�� �߻� Ŭ�����̹Ƿ� ���ο� Service�� �����Ϸ��� Service�� ��ӹް� createTask() �޼ҵ带 �������ϸ� �ȴ�.
	// createTask()�� �۾� �����尡 ������ Task�� �����ؼ� �����ϵ��� �ؾ��Ѵ�. Service�� ���׸� Ÿ���̱� ������ Ÿ�� �Ķ���ʹ� �۾� ��� Ÿ������ �����ϸ� �ȴ�.
	// ������ �۾� ����� Integer�� Service�� ������ ���̴�.
	
	//	class CustomService extends Service<Integer> {
	//		@Override
	//		protected Task<Integer> createTask() {
	//			Task<Integer> task = new Task<Integer>() {...}
	//			return task;
	//		}
	//	}
	
	// ������ �۾� ����� ���� Service Ŭ������ ������ ���̴�.
	
	//	class CustomService extends Service<Void> {
	//		@Override
	//		protected Task<Void> createTask() {
	//			Task<Void> task = new Task<Void>() {...}
	//			return task;
	//		}
	//	}
	
			/*	Service Start, Cancel, Restart		Service ����, ���, �����		*/
	
	// Service�� �����Ϸ��� start() �޼ҵ带 ȣ���ϸ� �ǰ�, ����Ϸ��� cancel() �޼ҵ带 ȣ���ϸ� �ȴ�. �׸��� ������� �ʿ��� ��� restart()�� ȣ���ϸ� �ȴ�.
	// ������ ���� �� �޼ҵ���� JavaFX Application Thread �󿡼� ȣ���ؾ� �Ѵ�. start()�� restart()�� ȣ��Ǹ� �Ź� createTask()�� ����ǰ�, ���ϵ� Task�� �޾� �۾� �����忡�� �����Ѵ�.
	// ���� ������ JavaFX ���ø����̼��� �����ϸ� TimeService�� ����, btnStop�� Ŭ���ϸ� ���, btnStart�� Ŭ���ϸ� ����۵ǵ��� ��Ʈ�ѷ��� �����ߴ�.
	
	//	public class RootController implements Initializable {
	//		private TimeService timeService;
	//
	//		@Override
	//		public void initialize(URL location, ResourceBundle resources) {
	//			timeService = new TimeService();
	//			timeService.start();
	//		}
	//
	//		public void handleBtnStart(ActionEvent e) {
	//			timeService.restart();
	//		}
	//		
	//		public void handleBtnStop(ActionEvent e) {
	//			timeService.cancel();
	//		}
	//
	//		class TimeService extends Service<Void> {
	//			@Override
	//			protected Task<Void> createTask() {
	//				Task<Void> task = new Task<Void>() {...}
	//				return task;
	//			}
	//		}
	//	}
	
			/*	Callback By Task Status		���� ���º� �ݹ�		*/
	
	// Task�� ���������� Service�� �۾��� ��� ó���ƴ��Ŀ� ���� Service�� ���� �� ���� �޼ҵ� �� �ϳ��� �ڵ� ȣ��(�ݹ�)�ȴ�.
	
	//	�ݹ� �޼ҵ�			����
	//
	//	succeeded()		���������� call() �޼ҵ尡 ���ϵǾ��� ��	
	//	cancelled()		cancel() �޼ҵ�� �۾��� ��� �Ǿ��� ��
	//	failed()		���ܰ� �߻��Ǿ��� ��
	
	// �� �޼ҵ���� Service Ŭ������ �ۼ��� �� �������ؼ� ���ø����̼� �������� �籸���Ҥ� �� �ִ�. Task�� ���������� �� �޼ҵ���� �۾� ������󿡼� ȣ��Ǵ� ���� �ƴ϶�, 
	// JavaFX Application Thread �󿡼� ȣ��Ǳ� ������ �����ϰ� UI ���� �ڵ带 �ۼ��� �� �ִ�. 
	// �۾� ����� �ִ� Service�� ��� succeeded() �޼ҵ忡�� �۾� ����� ������ ���� ���� �� �ִ�. V�� �۾� ��� Ÿ���̴�.
	
	//	@Override
	//	protected void succeeded() {
	//		V v = service.getValue();
	//	}
	
	// ���� ������ ���� ������ �����ѵ�, Service�� �̿��ߴٴ� �������� �ִ�.
	// 0���� 100���� ���� ���ϴ� Service�� �ۼ��ϰ� �۾� �����忡�� �����Ų��. �۾� �Ϸ� ����� succeeded() �޼ҵ忡�� ��� Label ��Ʈ�ѿ� ��Ÿ����.
}		
