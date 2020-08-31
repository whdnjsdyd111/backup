package 챕터17_JavaFX;

public class ㅋ_JavaFX_Thread {
	// JavaFX UI는 스레드에 안전하지 않기 때문에 UI를 생성하지 않고 변경하는 작업은 JavaFX Application Thread가 담당하고, 다른 작업은 스레드들은 UI를 생성하거나 변경할 수 없다.
	// main 스레드가 Application의 launch() 메소드를 호출하면서 생성된 JavaFX Application Thread는 start() 메소드를 실행시키면서 모든 UI를 생성한다.
	// 컨트롤에서 이벤트가 발생할 경우 컨트롤러의 이벤트 처리 메소드를 실행하는 것도 JavaFX Application Thread이다.
	
	//		main Thread
	//			↓
	//		launch()	─────	JavaFX Application Thread
	//										│
	//									start()
	//										↓
	//								┌───────────┐
	//							UI생성/변경	컨트롤로 생성 및 이벤트 처리	┐
	//								↑							↓
	//								└──────────x────────────Worker Thread
	
	// JavaFX 애플리케이션을 개발할 때 주의할 점은 JavaFX Application Thread가 시간을 요하는 작업을 하지 않도록 하는 것이다.
	// 시간을 요하는 작업을 하게 되면 이 시간 동안 UI는 반응하지 않고 멈춰있는 상태가 되기 때문에 다른 작업 스레드를 생성해서 처리하는 것이 좋다.
	// 예를 들어 파일을 읽고 쓰거나, 네트워크상에서 데이터를 주고받을 때 얼마만큼의 시간이 필요한지 모르기 때문에 반드시 작업 스레드를 생성해서 처리해야 한다.
	// 문제는 작업 스레드가 직접 UI를 변경할 수 없기 때문에 UI 변경이 필요할 경우 두 가지 방법으로 해결해야 한다.
	// 첫 번째 방법은 Platform.runLater() 메소드를 이용하는 것이고, 두 번째 방법은 javafx.concurrent API인 Task 또는 Service를 이용하는 것이다.
	
			//	Platform.runLater() Method
	
	// 작업 스레드가 직접 UI를 변경할 수 없기 때문에 UI 변경이 필요할 경우, 작업 스레드는 UI 변경 코드를 Runnable로 생성하고, 이것을 매개값으로 해서 Platform의 정적 메소드인 runLater()를 호출할 수 있다.
	
	//		직접 Runnable 객체 생성						람다식 이용
	//
	//	Platform.runLater(new Runnable() {			Platform.runLater( () -> {
	//		@Override									// UI 생성 및 변경 코드
	//		public void run() {						});
	//			// UI 생성 및 변경 코드
	//		}
	//	}
	
	// runLater() 메소드는 이벤트 큐(event queue)에 Runnable을 저장하고 즉시 리턴한다. 이벤트 큐에 저장된 Runnable들은 저장된 순서에 따라서 
	// JavaFX Application Thread에 의해 하나씩 실행 처리되어 UI 변경 작업을 한다. runLater()는 지연 처리라는 뜻을 가지고 있는데, 
	// 주어진 매개값 Runnable이 바로 처리되는 것이 아니라 이벤트 큐에 먼저 저장된 Runnable을 처리한 후에 처리된다.
	
	//	스레드 A	┐	이벤트큐(EventQueue)
	//			│	─────────────				JavaFX				┌───────┐
	//	스레드 B	┼───→ ○		○	○	────────→	Application	────→ 	│UI 생성	│
	//			│ :	─────────────				Thread				│및	변경	│
	//	스레드 C	┘ :		↖	↑   ↗										└───────┘
	//			  :		Runnable 객체
	//		Platform.runLater();
	
	// 다음 예제는 작업 스레드가 0.1초 주기로 얻어낸 시간을 이용해서 JavaFX Application Thread가 Label 컨트롤의 text 속성을 변경한다.
	// Label은 UI 요소이므로 작업 스레드에서 setText() 메소드로 text 속성값을 변경할 수 없다. 대신 Runnable을 생성해서 Platform.runLater() 메소드를 호출했다.
	// JavaFX Application Thread는 이벤트 큐에서 Runnable을 얻어 안전하게 Label의 text() 속성을 변경한다.
	
			//	Task Class
	
	// javafx.concurrent 패키지는 JavaFX 애플리케이션 개발에 사용할 수 있는 스레드 동시성 API를 제공하고 있다. 이 패키지는 Worker 인터페이스와 두 가지의 구현 클래스인 Task, Service로 구성되어 있다.
	
	//						Worker
	//				  ┌───────↑────────┐
	//				Task			Service
	
	// Worker 인터페이스는 Task와 Service에서 공통적으로 사용할 수 있는 메소드가 선언되어 있다.
	// Task 클래스는 JavaFX 애플리케이션에서 비동기 작업을 표현한 클래스이고, Service는 이러한 Task를 간편하게 시작, 취소, 재시작할 수 있는 기능을 제공한다.
	
			/*	Task Creation		Task 생성		*/
	
	// Task는 작업 스레드에서 실행되는 하나의 작업을 표현한 추상 클래스이다. 하나의 작업을 정의할 때에는 Task를 상속해서 클래스를 생성한 후, call() 메소드를 재정의하면 된다.
	// call() 메소든는 리턴값이 있는데 리턴값은 작업 결과를 말한다. Task는 제네릭 타입인데, 타입파라미터는 작업 결과 타입이다. 이타입은 call() 메소드의 리턴 타입과 동일해야 한다.
	// 다음은 작업 결과가 Integer인 Task를 정의한 것이다.
	
	//	Task<Integer> task = new Task<Integer>() {
	//		@Override
	//		protected Integer call() throws Exception {
	//			int result = 0;
	//			// 작업 코드 ...
	//			return result;
	//		}
	//	}
	
	// 만약 리턴값이 없는 작업이라면 타입 파라미터로 Void를 사용할 수 있다. 이 경우 call() 메소드의 리턴값은 null 이다.
	
	//	Task<Void> task = new Task<Void>() {
	//		@Override
	//		protected Void call() throws Exception {
	//			// 작업 코드...
	//			return null;
	//		}
	//	}
	
			/*	Run Task	Task 실행		*/
	
	// Task를 작업 스레드에서 실행하려면 작업 스레드를 생성할 때 매개값으로 Task를 전달하면 된다. 이것은 Task가 Runnable 인터페이스를 구현하고 있기 때문이다.
	// 다음은 작업 스레드에서 Task를 처리하는 코드이다.
	
	//	Task<Integer> task = new Task<Integer>() {...};
	//	Thread thread = new Thread(task);
	//	thread.setDaemon(true);
	//	thread.start();
	
	// Task를 스레드풀의 작업 스레드에서 처리하려면 ExecutorService의 submit() 메소드를 호출할 때 매개값으로 전달하면 된다.
	// 다음은 스레드풀(ExecutorService)에서 Task를 처리하는 코드이다.
	
	//	Task<Integer> task = new Task<Integer>() {...};
	//	executorService.submit(task);
	
			/*	Cancel Task		Task 취소		*/
	
	// Task는 cancel() 메소드가 호출되면 언제든지 실행을 멈출 수 있어야 한다. 반복 작업이 포함된 Task는 주기적으로 isCancelled() 메소드를 호출해서 작업이 취소 되었는지 확인하고,
	// 작업을 종료해야 한다. cancel() 메소드가 호출되면 isCancelld()는 true를 리턴한다.
		
	//	Task<Void> task = new Task<Void>() {
	//		@Override
	//		protected Void call() throws Exception {
	//			while(...) {
	//				if(isCancelled()) { break; }
	//				// 작업 코드...
	//			}
	//			return null;
	//		}
	//	};
	
	// 만약 Task가 Thread.sleep()과 같이 블로킹되어 있을 때, cancel() 메소드가 호출되면 InterruptedException이 발생한다.
	// 이 경우, 예외 처리에서 isCancelled() 메소드로 cancel() 메소드가 호출된 것인지 확인하고 작업을 종료해야 한다.
	
	//	Task<Void> task = new Task<Void>() {
	//		@Override
	//		protected Void call() throws Exception {	
	//			while(...) {
	//				if(isCancelled()) { break; }
	//				// 작업 코드...
	//				try { Thread.sleep(100); } catch(InterruptedException interrupted) {
	//					if (isCancelled()) { break; }
	//				}
	//			}
	//			return null;
	//		}
	//	};
	
	// Task는 한 번만 사용할 수 있고, 재사용할 수 없기 때문에 작업이 완료되었거나 취소된 후에 작업을 재실행하려면 Task를 다시 생성해야 한다.
	
			/*	UI Change		UI 변경	*/
	
	// Task의 call() 메소드는 작업 스레드상에서 호출되기 때문에 UI 변경 코드를 작성할 수 없다. 만약 작성하게 되면 런타임 예외가 발생한다.
	// 대신 call() 메소드 내부에서는 updateProgress(), updateMessage() 메소드를 호출할 수 있는데, 이 메소드들은 JAvaFX Application Thread로 하여금 UI를 업데이트하도록 해준다.
	
			/*	|	updateProgress() Method		|	*/
	
	// 작업 스레드의 진행 정도를 ProgressBar에 나타내는 경우가 종종 있다. Task의 progress 속성과 ProgressBar의 progress 속성이 바인딩되어 있다면,
	// 작업 스레드에서 updateProgress() 메소드를 호출했을 때 JavaFX Application Thread가 ProgressBar의 상태를 변경한다.
	
	//	updateProgress(double workDone, double max);
	
	// updateProgress() 메소드의 첫 번째 매개값은 현재 진행 정도이고, 두 번째 매개값은 진행 완료값이다. 이 메소드는 Task의 progress, totalWork, workDone 속성을 업데이트한다.
	// 다음은 Task의 progress 속성과 ProgressBar의 progress 속성을 바인딩해서 updateProgress()가 호출될 때마다 ProgressBar의 progress 속성값을 변경하는 코드이다.
	
	//	Task<Void> task = new Task<Void>() {
	//		@Override
	//		protected Void call() throws Exception {
	//			for (int i = 1; i <= 100; i++) {
	//				if (isCancelled()) { break; }
	//				// 작업 코드...
	//				updateProgress(i, 100);		// Task의 progress 속성 업데이트
	//			}
	//			return null;
	//		}
	//	};
	//
	//	// progress 속성 바인딩
	//	ProgressBar progressBar = new ProgressBar();
	//	progressBar.progressProperty().bind(task.progressProperty());	// 속성 바인딩
	//
	//	// 작업 스레드 시작
	//	Thread thread = new Thread(task);
	//	thread.start();
	
			/*	|	updateMessage() Method	|	*/
	
	// 작업 진행 중이거나, 작업이 취소되었을 경우, 문자열 메세지를 전달해서 UI를 변경하고 싶다면 updateMessage()를 호출할 수 있다.
	
	//	updateMessage(String message);
	
	// updateMessage()는 Task의 message 속성을 업데이트한다. 따라서 Task의 message 속성과 UI 컨트롤의 문자열 속성을 바인딩시킬 수 있다. 
	// 다음은 Task의 message 속성과 Label의 text 속성을 바인딩해서 updateMessage()가 호출될 때마다 Label의 text 속성값을 변경하는 코드이다.
	
	//	Task<Void> task = new Task<Void>() {
	//		@Override
	//		protected Void call() throws Exception {	
	//			for (int i = 1; i <= 100; i++) {
	//				if( isCanelled() ) { break; }
	//				updateMessage( String.valueOf(i) );		// Task의 message 속성 업데이트
	//			}
	//			return null;
	//		}
	//	};
	//
	//	// 문자열 속성 바인딩
	//	Label label = new Label();
	//	label.textProperty().bind(task.messageProperty());	// 속성 바인딩
	//
	//	// 작업 스레드 시작
	//	Thread thread = new Thread(task);
	//	thread.start();
	
			/*	|	Platform.runLater() Method	|	*/
	
	// 단순히 ProgressBar 또는 다른 컨트롤의 문자열 속성 바인딩하는 것보다 더 복잡한 UI 변경이 필요한 경우에는 call() 메소드 내에서 Platform.runLater(new Runnable() {...})을 호출하면 된다.
	
	//	Task<Integer> task = new Task<Integer>() {
	//		@Override
	//		protected Integer call() throws Exception {
	//			for(int i = 1; i <= 100; i++) {
	//				if(isCancelled()) { break; }
	//				Platform.runLater( () -> { // UI 변경 코드 } );
	//			}
	//			return result;
	//		}
	//	};
	//
	//	// 작업 스레드 시작
	//	Thread thread = new Thread(task);
	//	thread.start();
	
	// 다음 예제는 작업 스레드가 0.1초 주기로 0부터 100까지 카운팅한 값을 ProgressBar의 progress 속성 및 Label의 text 속성과 바인딩해서 UI를 변경한다.
	
			/*	Callback By Task Status		작업 상태별 콜백		*/
	
	// 작업이 어떻게 처리됐는지에 따라 Task의 다음 세 가지 메소드 중 하나가 자동 호출(콜백) 된다.
	
	//	콜백 메소드			설명
	//
	//	succeeded()		성공적으로 call() 메소드가 리턴되었을 때	
	//	cancelled()		cancel() 메소드로 작업이 취소 되었을 때
	//	failed()		예외가 발생되었을 때
	
	// 이 메소드들은 Task 클래스를 작성할 때 재정의해서 애플리케이션 로직으로 재구성할 수 있다. 주목할 점은 이 메소드들은 작업 스레드상에서 호출되는 것이 아니라, 
	// JavaFX Application Thread상에서 호출되기 때문에 안전하게 UI 변경 코드를 작성할 수 있다. 작업 결과가 있는 Task일 경우(call() 메소드가 리턴값이 있을 경우)
	// succeeded() 메소드를 재정의해서 작엽 결과를 다음과 같이 얻을 수 있다. V는 call() 메소드가 리턴하는 값의 타입이다.
	
	//	@Override
	//	protected void succeeded() {
	//		V v = task.getValue();
	//	}
	
	// 다음 예제는 0부터 100까지 합을 구하는 Task를 작성하고 작업 스레드에서 실행시킨다. 작업 완료 결과는 succeeded() 메소드에서 얻어 Label 컨트롤에 나타낸다.
	
			//	Service Class
	
	// Service 클래스는 작업 스레드상에서 Task를 간편하게 시작, 취소, 재시작할 수 있는 기능을 제공한다.
	// Service 클래스의 목적은 작업 스레드와 JavaFX Application Thread가 올바르게 상호작용을 할 수 있도록 도와주는 것이다.
	
			/*	Service Creation	*/
	
	// Service는 추상 클래스이므로 새로운 Service를 생성하려면 Service를 상속받고 createTask() 메소드를 재정의하면 된다.
	// createTask()는 작업 스레드가 실행할 Task를 생성해서 리턴하도록 해야한다. Service는 제네릭 타입이기 때문에 타입 파라미터는 작업 결과 타입으로 지정하면 된다.
	// 다음은 작업 결과가 Integer인 Service를 정의한 것이다.
	
	//	class CustomService extends Service<Integer> {
	//		@Override
	//		protected Task<Integer> createTask() {
	//			Task<Integer> task = new Task<Integer>() {...}
	//			return task;
	//		}
	//	}
	
	// 다음은 작업 결과가 없는 Service 클래스를 정의한 것이다.
	
	//	class CustomService extends Service<Void> {
	//		@Override
	//		protected Task<Void> createTask() {
	//			Task<Void> task = new Task<Void>() {...}
	//			return task;
	//		}
	//	}
	
			/*	Service Start, Cancel, Restart		Service 시작, 취소, 재시작		*/
	
	// Service를 시작하려면 start() 메소드를 호출하면 되고, 취소하려면 cancel() 메소드를 호출하면 된다. 그리고 재시작이 필요한 경우 restart()를 호출하면 된다.
	// 주의할 점은 이 메소드들은 JavaFX Application Thread 상에서 호출해야 한다. start()와 restart()가 호출되면 매번 createTask()가 실행되고, 리턴된 Task를 받아 작업 스레드에서 실행한다.
	// 다음 예제는 JavaFX 애플리케이션이 시작하면 TimeService를 시작, btnStop을 클릭하면 취소, btnStart를 클릭하면 재시작되도록 컨트롤러를 구성했다.
	
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
	
			/*	Callback By Task Status		직업 상태별 콜백		*/
	
	// Task와 마찬가지로 Service도 작업이 어떻게 처리됐느냐에 따라서 Service의 다음 세 가지 메소드 중 하나가 자동 호출(콜백)된다.
	
	//	콜백 메소드			설명
	//
	//	succeeded()		성공적으로 call() 메소드가 리턴되었을 때	
	//	cancelled()		cancel() 메소드로 작업이 취소 되었을 때
	//	failed()		예외가 발생되었을 때
	
	// 이 메소드들은 Service 클래스를 작성할 때 재정의해서 애플리케이션 로직으로 재구성할ㄹ 수 있다. Task와 마찬가지로 이 메소드들은 작업 스레드상에서 호출되는 것이 아니라, 
	// JavaFX Application Thread 상에서 호출되기 때문에 안전하게 UI 변경 코드를 작성할 수 있다. 
	// 작업 결과가 있는 Service일 경우 succeeded() 메소드에서 작업 결과를 다음과 같이 얻을 수 있다. V는 작업 결과 타입이다.
	
	//	@Override
	//	protected void succeeded() {
	//		V v = service.getValue();
	//	}
	
	// 다음 예제는 이전 예제와 동일한데, Service를 이용했다는 차이점이 있다.
	// 0부터 100까지 합을 구하는 Service를 작성하고 작업 스레드에서 실행시킨다. 작업 완료 결과는 succeeded() 메소드에서 얻어 Label 컨트롤에 나타낸다.
}		
