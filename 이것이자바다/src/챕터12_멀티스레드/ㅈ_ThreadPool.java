package 챕터12_멀티스레드;

public class ㅈ_ThreadPool {
	// 병렬 작업 처리가 많아지면 스레드 개수가 증가되고 그에 따른 스레드 생성과 스케줄링으로 인해 CPU가 바빠져 메모리 사용량이 늘어난다. 따라서 애플리케이션의 성능이 저하된다.
	// 갑작스런 병렬 작업의 폭증으로 인한 스레드의 폭증을 막으려면 스레드풀(ThreadPool)을 사용해야 한다.
	// 스레드풀은 작업 처리에 사용되는 스레드를 제한된 개수만큼 정해놓고 작업 큐(Queue)에 들어오는 작업들을 하나씩 스레드가 맡아 처리한다.
	// 작업 처리가 끝난 스레드는 다시 작업 큐에서 새로운 작업을 가져와 처리한다. 그렇기 때문에 작업 처리 요청이 폭증되어도 스레드의 전체 개수가 늘어나지 않으므로 애플리케이션의 성능이 급격히 저하되지 않는다.
	
	// 자바는 스레드풀을 생성하고 사용할 수 있도록 java.util.concurrent 패키지에서 ExecutorService 인터페이스와 Executor 클래스를 제공하고 있다.
	// Executor의 다양한 정적 메소드를 이용해서 ExecutorService 구현 객체를 만들 수 있는데, 이것이 바로 스레드풀이다. 다음은 ExecutorService가 작동하는 방식이다.
	
	//	( 애플리케이션 )				(스레드풀 (ExecutorService) )
	//	1 스레드풀에									스레드 1		┐
	//	 작업 처리 요청 ■								 	3 작업 처리		│
	//				↘							↗				│
	//	4 결과 전달					2 작업 큐							│	
	//		← 스레드 1				... ■ ■ ■		↘				│
	//							각 스레드는 큐에서			스레드 2		│	최대 개수 제한
	//	1 스레드풀에	↗			작업을 가져와 처리함		3 작업 처리		│
	//	 작업 처리 요청 ■												│
	//													.		│
	//	4 결과 전달											.		│
	//		← 스레드 2										.		│
	//												스레드 n		┘
	
			//	Creation And End ThreadPool		스레드풀 생성 및 종료
	
			/*	Creation ThreadPool		스레드풀 생성	*/
	
	// ExecutorService 구현 객체는 Executor 클래스의 다음 두 가지 메소드 중 하나를 이용해서 간편하게 생성할 수 있다.
	
	//			메소드명(매개변수)				초기 스레드 수	코어 스레드 수	최대 스레드 수
	//	newCachedThreadPool()					0			0		Integer.MAX_VALUE
	//	newFixedThreadPool(int nThreads)		0		nThreads	nThreads
	
	// 초기 스레드 수는 ExecutorService 객체가 생성될 때 기본적으로 생성되는 스레드 수를 말하고, 
	// 코어 스레드 수는 스레드 수가 증가된 후 사용되지 않는 스레드를 스레드풀에서 제거할 때 최소한 유지해야 할 스레드 수를 말한다.
	// 최대 스레드 수는 스레드풀에서 관리하는 최대 스레드 수이다.
	
	// newCachedThreadPool() 메소드로 생성된 스레드풀의 특징은 초기 스레드 개수와 코어 스레드 개수는 0개이고, 스레드 개수보다 작업 개수가 많으면 새 스레드를 생성시켜 작업을 처리한다.
	// 이론적으로는 int 값이 가질 수 있는 최대값만큼 스레드가 추가되지만, 운영체제의 성능과 상황에 따라 달라진다. 
	// 1개 이상의 스레드가 추가되었을 경우 60초 동안 추가된 스레드가 아무 작업을 하지 않으면 추가된 스레드를 종료하고 풀에서 제거한다.
	// 다음은 newCachedThreadPool()을 호출해서 ExecutorService 구현 객체를 얻는 코드이다.
	
	//	ExecutorService executorService = Executors.newCachedThreadPool();
	
	// newFixedThreadPool(int nThreads) 메소드로 생성된 스레드풀의 초기 스레드 개수는 0개이고, 코어 스레드 수는 nThreads이다.
	// 스레드 개수보다 작업 개수가 많으면 새 스레드를 생성시키고 작업을 처리한다. 최대 스레드 개수는 nThreads이다.
	// 이 스레드풀은 스레드가 작업을 처리하지 않고 놀고 있더라도 스레드 개수가 줄지 않는다. 다음은 CPU 코어의 수만큼 최대 스레드를 사용하는 스레드풀을 생성한다.
	
	//	ExecutorService executorService = Executor.newFixedThreadPool(
	//		Runtime.getRuntime().availableProcessors()
	//	);
	
	// newCachedThreadPool()과 newFixedThreadPool() 메소드를 사용하지 않고 코어 스레드 개수와 최대 스레드 개수를 설정하고 싶다면 직접 ThreadPoolExecutor 객체를 생성하면 된다.
	// 사실 위 두 가지 메소드도 내부적으로 ThreadPoolExecutor 객체를 생성해서 리턴한다.
	// 다음은 초기 스레드 개수가 0개, 코어 스레드 개수가 3개, 최대 스레드 개수가 100개인 스레드풀을 생성한다.
	// 그리고 코어 스레드 3개를 제외한 나머지 추가된 스레드가 120초 동안 놀고 있을 경우 ㅎ당 스레드를 제거해서 스레드 수를 관리한다.
	
	//	ExecutorService threadPool = new ThreadPoolExecutor(
	//		3,		// 코어 스레드 개수
	//		100,	// 최대 스레드 개수
	//		120L.	// 놀고 있는 시간
	//		TimeUnit.SECONDS,	// 놀고 있는 시간 단위
	//		new SynchronousQueue<Runnable>()		// 작업 큐
	//	);
	
			/*	End ThreadPool		스레드풀 종료	*/
	
	// 스레드풀의 스레드는 기본적으로 데몬 스레드가 아니기 때문에 main 스레드가 종료되더라도 작업을 처리하기 위해 계속 실행 상태로 남아있다.
	// 그래서 main() 메소드가 실행이 끝나도 애플리케이션 프로세스는 종료되지 않는다. 애플리케이션을 종료하려면 스레드풀을 종료시켜 스레드들이 종료 상태가 되도록 처리해주어야 한다.
	// ExecutorService는 종료와 관련해서 다음 세 개의 메소드를 제공하고 있다.
	
	//	리턴 타입			메소드명(매개변수)			설명
	//		
	//	void			shutdown()			현재 처리 중인 작업뿐만 아니라 작업 큐에 대기하고 있는 모든 작업을 처리한 뒤에 스레드풀을 종료시킨다.
	//
	//	List<Runnable>	shutdownNow()		현재 작업 처리 중인 스레드를 interrupt해서 작업 중지를 시도하고 스레드풀을 종료시킨다. 리턴값은 작업 큐에 있는 미러치된 작업(Runnable)의 목록이다.
	//
	//	boolean			awaitTermination(	shutdown() 메소드 호출 이후, 모든 작업 처리를 timeout 시간 내에 완료하면 true를 리턴하고,
	//					long timeout,		완료하지 못하면 작업 처리 중인 스레드를 interrupt하고 false를 리턴한다.
	//					TimeUnit unit)
	
	// 남아있는 작업을 마무리하고 스레드풀을 종료할 때에는 shutdown()을 일반적으로 호출하고, 남아있는 작업과는 상관없이 강제로 종료할 때에는 shutdownNow()를 호출한다.
	
	//	executorService.shutdown();
	//	executorService.shutdownNow();
	
			//	Creation Task And Call Process		작업 생성과 처리 요청
	
			/*	Creation Task	작업 생성	*/
	
	// 하나의 작업은 Runnable 또는 Callable 구현 클래스로 표현한다. Runnable과 Callable의 차이점은 작업 처리 완료 후 리턴값이 있느냐 없느냐이다.
	// 다음은 작업을 정의하기 위해 Runnable과 Callable 구현 클래스를 작성하는 방법이다.
	
	//		Runnable 구현 클래스				|			Callable 구현 클래스
	//	Runnable task = new Runnable() {	|		Callable<T> task = new Callable<T>() {
	//		@Override						|			@Override
	//		public void run() {				|			public T call() throws Exception {
	//			// 스레드가 처리할 작업				|				// 스레드가 처리할 작업 내용
	//		}								|				return T
	//	}									|			}
	//										|		}
	
	// Runnable의 run() 메소드는 리턴값이 없고, Callable의 call() 메소드는 리턴값이 있다. call()의 리턴 타입은 implements Callable<T>에 지정한 T 타입이다.
	// 스레드풀의 스레드는 작업 큐에서 Runnable 또는 Callable 객체를 가져와 run()과 call() 메소드를 실행한다.
	
			/*	Call Task Process		작업 처리 요청	*/
	
	// 작업 처리 요청이란 ExecutorService의 작업 큐에 Runnable 또는 Callable 객체를 넣는 행위를 말한다. ExecutorService는 작업 처리 요청을 위해 다음 두 가지 종류의 메소드를 제공한다.
	
	//	리턴타입		메소드명(매개변수)					설명
	//
	//	void		executor(Runnable command)		- Runnable을 작업 큐에 저장
	//												- 작업 처리 결과를 받지 못함
	//
	//	Future<?>	submit(Runnable task)			- Runnable 또는 Callable을 작업 큐에 저장
	//	Future<V>	submit(Runnable task, V result)	- 리턴된 Future를 통해 작업 처리 결과를 얻을 수 있음
	//	Future<V>	submit(Callable<V> task)
	
	// execute()와 submit() 메소드의 차이점은 두 가지이다. 하나는 execute()는 작업 처리 결과를 받지 못하고 submit()은 작업 처리 결과를 받을 수 있도록 Future를 리턴한다.
	// 또 다른 차이점은 execute()는 작업 처리 도중 예외가 발생하면 스레드가 종료되고 해당 스레드는 스레드풀에서 제거된다. 따라서 스레드풀은 다른 작업 처리를 위해 새로운 스레드를 생성한다.
	// 반면에 submit()은 작업 처리 도중 예외가 발생하더라도 스레드는 종료되지 않고 다음 작업을 위해 재사용된다. 그렇기 때문에 가급적이면 스레드의 생성 오버헤더를 줄이기 위해 submit()을 사용하는 것이 좋다.
	
	// 다음 예제는 Runnable 작업을 정의할 때 Integer.parseInt("삼")을 넣어 NumberFormatException이 발생하도록 유도했다.
	// 10개의 작업을 execute()와 submit() 메소드로 각각 처리 요청 했을 경우 스레드풀의 상태를 살펴보기로 하자. 
	
	// 예제를 실행하면 execute() 메소드를 실행하였을 때는 스레드풀의 스레드 최대 개수 2는 변함 없지만, 실행 스레드의 이름을 보면 모두 다른 스레드가 작업을 처리하고 있다.
	// 이것은 작업 처리 도중 예외가 발생했기 때문에 해당 스레드는 제거되고 새 스레드가 계속 생성되기 때문이다.
	// 반면에 submit() 메소드로 작업 처리를 요청한 경우, execute()와의 확실한 차이점을 볼 수 있다. 예외가 발생하더라도 스레드가 종료되지 않고 계속 재사용되어 다른 작업을 처리하고 있는 것을 볼 수 있다.
	
			//	Notify Task Completion Of Blocking Way		블로킹 방식의 작업 완료 통보
	
	// ExecutorService의 submit() 메소드는 매개값으로 준 Runnable 또는 Callable 작업을 스레드풀의 작업 큐에 저장하고 즉시 Future 객체를 리턴한다.
	
	//	리턴타입		메소드명(매개변수)					설명
	// 
	//	Future<?>	submit(Runnable task)			- Runnable 또는 Callable을 작업 큐에 저장
	//	Future<V>	submit(Runnable task, V result)	- 리턴된 Future를 통해 작업 처리 결과를 얻을 수 있음
	//	Future<V>	submit(Callable<V> task)
	
	// Future 객체는 작업 결과가 아니라 작업이 완료될 때까지 기다렸다가(지연했다가=블로킹되었다가) 최종 결과를 얻는데 사용된다.
	// 그래서 Future를 지연 완료(pending completion) 객체라고 한다. Future의 get() 메소드를 호출하면 스레드가 작업을 완료할 때까지 블로킹 되었다가 작업을 완료하면 처리 결과를 리턴한다.
	// 이것이 블로킹을 사용하는 작업 완료 통보 방식이다. 다음은 Future가 가지고 있는 get() 메소드를 설명한 표이다.
	
	//	리턴타입	메소드명(매개변수)							설명
	//	
	//	V		get()									작업이 완료될 때까지 블로킹되었다가 처리 결과 V를 리턴
	//
	//	V		get(long timeout, TimeUnit unit)		timeout 시간 전에 작업이 완료되면 결과 V를 리턴하지만, 작업이 완료되지 않으면 TimeoutException을 발생시킴
	
	// 리턴 타입인 V는 submit(Runnable task, V result)의 두 번째 매개값인 V 타입이거나 submit(Callable<V> task)의 Callable 타입 파라미터 V 타입이다.
	// 다음은 세 가지 submit() 메소드별로 Future의 get() 메소드가 리턴하는 값이 무엇인지 보여준다.
	
	//	메소드									작업 처리 완료 후 리턴 타입				작업 처리 도중 예외 발생
	//
	//	submit(Runnable task)					future.get() -> null			future.get() -> 예외 발생
	//
	//	submit(Runnable task, Integer result)	future.get() -> int 타입 값		future.get() -> 예외 발생
	//
	//	submit(Callable<String> task)			future.get() -> String 타입 값		future.get() -> 예외 발생
	
	// Future를 이용한 블로킹 방식의 작업 완료 통보에서 주의할 점은 작업을 처리하는 스레드가 작업을 완료하기 전까지 get() 메소드가 블로킹되므로 다른 코드를 실행할 수 없다.
	// 만약 UI를 변경하고 이벤트를 처리하는 스레드가 get() 메소드를 호출하면 작업을 완료하기 전까지 UI를 변경할 수도 없고 이벤트를 처리할 수도 없게 된다.
	// 그렇기 때문에 get() 메소드를 호출하는 스레드는 새로운 스레드이거나 스레드풀의 또 다른 스레드가 되어야 한다.
	
	//	새로운 스레드를 생성해서 호출					|		스레드풀의 스레드가 호출
	//	new Thread(new Runnable() {			|		executorService.submit(new Runnable() {
	//		@Override						|			@Override
	//		public void run() {				|			public void run() {
	//			try {						|				try {
	//				future.get();			|					future.get();
	//			} catch (Exception e) {		|				} catch (Exception e) {
	//				e.printStackTrace();	|					e.printStackTrace();
	//			}							|				}
	//		}								|			}
	//	}).start();							|		});
	
	// Future 객체는 작업 결과를 얻기 위한 get() 메소드 이외에도 다음과 같은 메소드를 제공한다.
	
	//	리턴타입		메소드명(매개변수)								설명
	//
	//	boolean		cancel(boolean mayInterruptIfRunning)		작업 처리가 진행 중일 경우 취소시킴
	//
	//	boolean		isCancelled()								작업이 취소되었는지 여부
	//
	//	boolean		isDone()									작업 처리가 완료되었는지 여부
	
	// cancel() 메소드는 작업을 취소하고 싶을 경우 호출할 수 있다. 작업이 시작되기 전이라면 mayInterruptIfRunning 매개값과는 상관없이 작업 취소 후 true를 리턴하지만,
	// 작업이 진행 중이라면 mayInterruptIfRunning 매개값이 true일 경우에만 작업 스레드를 interrupt한다.
	// 작업이 완료되었을 경우 또는 어떤 이유로 인해 취소될 수 없다면 cancel() 메소드는 false를 리턴한다.
	// isCancelld() 메소드는 작업이 완료되기 전에 작업이 취소되었을 경우에만 true를 리턴한다.
	// isDone() 메소드는 작업이 정상적, 예외, 취소 등 어떤 이유에서건 작업이 완료되었다면 true를 리턴한다.
	
			/*	Notify Task Completion Without Return Value		리턴값이 없는 작업 완료 통보	*/
	
	// 리턴값이 없는 작업일 경우는 Runnable 객체로 생성하면 된다. 다음은 Runnable 객체를 생성하는 방법을 보여준다.
	
	//	Runnable task = new Runnable() {
	//		@Override
	//		public void run() {
	//			// 스레드가 처리할 작업 내용
	//		}
	//	};
	
	// 결과값이 없는 작업 처리 요청은  submit(Runnable task) 메소드를 이용하면 된다. 결과값이 없음에도 불구하고 다음과 같이 Future 객체를 리턴하는데,
	// 이것은 스레드가 작업 처리를 정상적으로 완료했는지, 아니면 작업 처리 도중에 예외가 발생했는지 확인하기 위해서이다.
	
	//	Future future = executorService.submit(task);
	
	// 작업 처리가 정상적으로 완료되었다면 Future의 get() 메소드는 null을 리턴하지만 스레드가 작업 처리 도중 interrupt되면 InterruptedException을 발생시키고, 
	// 작업 처리 도중 예외가 발생하면 ExecutionException을 발생시킨다. 그래서 다음과 같은 예외 처리 코드가 필요하다.
	
	//	try {
	//		future.get();
	//	} catch (InterruptedException e) {
	//		// 작업 처리 도중 스레드가 interrupt 될 경우 실행할 코드
	//	} catch (ExecutionException e) {
	//		// 작업 처리 도중 예외가 발생된 경우 실행할 코드
	//	}
	
	// 다음 예제는 리턴값이 없고 단순히 1부터 10까지의 합을 출력하는 작업을 Runnable 객체로 생성하고, 스레드풀의 스레드가 처리하도록 요청한 것이다.
	
			/*	Notify Task Completion With Return Value		리턴값이 있는 작업 완료 통보	*/
	
	// 스레드풀의 스레드가 작업을 완료한 후에 애플리케이션이 처리 결과를 얻어야 된다면 작업 객체를 Callable로 생성하면 된다.
	// 다음은 Callable 객체를 생성하는 코드인데, 주의할 점은 제네릭 타입 피라미터 T는 call() 메소드가 리턴하는 타입이 되도록 한다.
	
	//	Callable<T> task = new Callable<T>() {
	//		@Override
	//		public T call() throws Exception {
	//			// 스레드가 처리할 작업 내용
	//			return T;
	//		}
	//	};
	
	// Callable 작업의 처리 요청은 Runnable 작업과 마찬가지로 ExecutorService의 submit() 메소드를 호출하면 된다.
	// submit() 메소드는 작업 큐에 Callable 객체를 저장하고 즉시 Future<T>를 리턴한다. 이때 T는 call() 메소드가 리턴하는 타입이다.
	
	//	Future<T> future = executorService.submit(task);
	
	// 스레드풀의 스레드가 Callable 객체의 call() 메소드를 모두 실행하고 T 타입의 값을 리턴하면, Future<T>의 get() 메소드는 블로킹이 해제되고 T 타입의 값을 리턴하게 된다.
	
	//	try {
	//		T result = future.get();
	//	} catch (InterruptedException e) {
	//		// 작업 처리 도중 스레드가 interrupt 될 경우 실행할 코드
	//	} catch (ExecutionException e) {
	//		// 작업 처리 도중 예외가 발생된 경우 실행할 코드
	//	}
	
	// 다음 예제는 1부터 10까지 합을 리턴하는 작업을 Callable 객체로 생성하고, 스레드풀의 스레드가 처리하도록 요청한 것이다.
	
			/*	Save Task Completion Result On Outside Object		작업 처리 결과를 외부 객체에 저장	*/
	
	// 상황에 따라서 스레드가 작업한 결과를 외부 객체에 저장해야 할 경우도 있다. 예를 들어 스레드가 작업 처리를 완료하고 외부 Result 객체에 작업 결과를 저장하면, 
	// 애플리케이션이 Result 객체를 사용해서 어떤 작업을 진행할 수 있을 것이다. 대개 Result 객체는 공유 객체가 되어, 두 개 이상의 스레드 작업을 취합할 목적으로 이용된다.
	
	//								스레드 1
	//					Result	↙	작업 처리
	//		결과 이용	←	결과 취합			
	//							↖	스레드 2
	//								작업 처리
	
	// 이런 작업을 하기 위해서 ExecutorService의 submit(Runnable task, V result) 메소드를 사용할 수 있는데, V가 바로 Result 타입이 된다.
	// 메소드를 호출하면 즉시 Future<V>가 리턴되는데, Future의 get() 메소드를 호출하면 스레드가 작업을 완료할 때까지 블로킹되었다가 작업을 완료하면 V 타입 객체를 리턴한다.
	// 리턴된 객체는 submit()의 두 번째 매개값으로 준 객체와 동일한데, 차이점은 스레드 처리 결과가 내부에 저장되어 있다는 것이다.

	//	Result result = ...;
	//	Runnable task = new Task(result);
	//	Future<Result> future = executorService.submit(task, result);
	//	result = future.get();
	
	// 작업 객체는 Runnable 구현 클래스로 생성하는데, 주의할 점은 스레드에서 결과를 저장하기 위해 외부 Result 객체를 사용해야 하므로 생성자를 통해 Result 객체를 주입받도록 해야 한다.
	
	//	class Task implements Runnable {
	//		Result result;
	//		Task(Result result) { this.result = result; }
	//		@Override
	//		public void run() {		
	//			// 작업 코드
	//			// 처리 결과를 result 저장
	//		}
	//	}
	
	// 다음 예제는 1부터 10까지의 합을 계산하는 두 개의 작업을 스레드풀에 처리 요청하고, 각각의 스레드가 작업 처리를 완료한 후 산출된 값을 외부 Result 객체에 누적하도록 했다.
	
			/*	Notify On Task Completion Order		작업 완료 순으로 통보	*/
	
	// 작업 요청 순서대로 작업 처리가 완료되는 것은 아니다. 작업의 양과 스레드 스케줄링에 따라서 먼저 요청한 작업이 나중에 완료되는 경우도 발생한다.
	// 여러 개의 작업들이 순차적으로 처리될 필요성이 없고, 처리 결과도 순차적으로 이용할 필요가 없다면 작업 처리가 완료된 것부터 결과를 얻어 이용하면 된다.
	// 스레드풀에서 작업 처리가 완료된 것만 통보받는 방법이 있는데, CompletionService를 이용하는 것이다. CompletionService는 처리 완료된 작업을 가져오는 poll()과 take() 메소드를 제공한다.
	
	//	리턴 타입			메소드명(매개 변수)					설명
	//
	//	Future<V>		poll()							완료된 작업의 Future를 가져옴. 완료된 작업이 없다면 즉시 null을 리턴함
	//
	//	Future<V>		poll(long timeout,				완료된 작업의 Future를 가져옴.
	//					TimeUnit unit)					완료된 작업이 없다면 timeout까지 블로킹됨.
	//
	//	Future<V>		take()							완료된 작업의 Future를 가져옴. 완료된 작업이 없다면 있을 때까지 블로킹됨.
	//
	//	Future<V>		submit(Callable<V> task)		스레드풀에 Callable 작업 처리 요청
	//
	//	Future<V>		submit(Runnable task, V result)	스레드풀에 Runnable 작업 처리 요청
	
	// CompletionService 구현 클래스는 ExecutorCompletionService<V>이다. 객체를 생성할 때 생성자 매개값으로 ExecutorService를 제공하면 된다.
	
	//	ExecutorService executorService = Executors.newFixedThreadPool(
	//		Runtime.getRuntime().availableProcessors()
	//	);
	//	CompletionService<V> completionService = new ExecutorCompletionService<V>(
	//		executorService
	//	);
	
	// poll()과 take() 메소드를 이용해서 처리 완료된 작업의 Future를 얻으려면 CompletionService의 submit() 메소드로 작업 처리 요청을 해야 한다.
	
	//	completionService.submit(Callable<V> task);
	//	completionService.submit(Runnable task, V result);
	
	// 다음은 take() 메소드를 호출하여 완료된 Callable 작업이 있을 때까지 블로킹되었다가 완료된 작업의 Future를 얻고, get() 메소드로 결과값을 얻어내는 코드이다.
	// while문은 애플리케이션이 종료될 때까지 반복 실행해야 하므로 스레드풀의 스레드에서 실행하는 것이 좋다.
	
	//	executorService.submit(new Runnable() {		// 스레드풀의 스레드에서  실행하도록 함
	//		@Override
	//		public void run() {
	//			while(true) {
	//				try {
	//					Future<Integer> future = completionService.take();	// 완료된 작업이 있을 때까지 블로킹/완료된 작업이 있으면 Future를 리턴
	//					int value = future.get();							// get()은 블로킹되지 않고 바로 작업 결과를 리턴
	//					System.out.println("[ 처리 결과 ] " + value);
	//				} catch (Exception e) {
	//					break;
	//				}
	//			}
	//		}
	//	});
	
	// take() 메소드가 리턴하는 완료된 작업은 submit()으로 처리 요청한 작업의 순서가 아님을 명심해야 한다. 작업의 내용에 따라서 먼저 요청한 작업이 나중에 완료될 수도 있기 때문이다. 
	// 더 이상 완료된 작업을 가져올 필요가 없다면 take() 블로킹에서 빠져나와 while문을 종료해야 한다. 
	// ExecutorService의 shutdownNow()를 호출하면 take()에서 InterruptedException이 발생하고 catch 절에서 break가 되어 while문을 종료하게 된다.
	// 다음 예제는 3개의 Callable 작업을 처리 요청하고 완료되는 순으로 작업의 결과값을 콘솔에 출력하도록 했다.
	
			//	Notify Task Completion Of Callback Way		콜백 방식의 작업 완료 통보
	
	// 이번에는 콜백(callback) 방식을 이용해서 작업 완료 통보를 받는 방법에 대해서 알아보자. 콜백이란 애플리케이션이 스레드에게 작업 처리를 요청한 후, 스레드가 작업을 완료하면 특정 메소드를 자동 실행하는 기법을 말한다.
	// 이때 자동 실행되는 메소드를 콜백 메소드라고 한다. 다음은 블로킹 방식과 콜백 방식을 비교한 것이다.
	
	//	[ 블로킹 방식 ]							[ 콜백 방식 ]
	//										
	//	메인 스레드			스레드풀				메인 스레드			스레드풀
	//		│	1 작업 처리 요청	│					│	1 작업 처리 요청	│
	//		│	────────→	│					│	────────→	│
	//		↓	←────────	↓					│	←────────	│
	//			2 Future						│	2 Future	│	
	//	3 Future.get()		4 실행		   3 실행	↓				│
	//		블로킹												3 실행
	//						│								콜백	↓
	//		│	←			│				골백 메소드() {	┌───────┘
	//		│ 5 실행	↖		│					4 실행	│
	//		│				│				}			↓
	//		↓			↖	↓				
	
	// 블로킹 방식은 작업 처리를 요청한 후 작업이 완료될 때까지 블로킹되지만, 콜백 방식은 작업 처리를 요청한 후 결과를 기다릴 필요 없이 다른 기능을 수행할 수 있다.
	// 그 이유는 작업 처리가 완료되면 자동적으로 콜백 메소드가 실행되어 결과를 알 수 있기 때문이다.
	// 아쉽게도 ExecutorService는 콜백을 위한 별도의 기능을 제공하지 않는다. 하지만 Runnable 구현 클래스를 작성할 때 콜백 기능을 구현할 수 있다.
	// 먼저 콜백 메소드를 가진 클래스가 있어야 하는데, 직접 정의해도 좋고 java.nio.channels.CompletionHandler를 이용해도 좋다.
	// 이 인터페이스는 NIO 패키지에 포함되어 있는데 비동기 통신에서 콜백 객체를 만들 때 사용된다.
	// 그럼 CompletionHandler를 이용해서 콜백 객체를 만드는 방법을 살펴보자. 다음은 CompletionHandler 객체를 생성하는 코드이다.
	
	//	CompletionHandler<V, A> callback = new CompletionHandler<V, A>() {
	//		@Override
	//		public void completed(V result, A attachment) {
	//		}
	//
	//		@Override
	//		public void failed(Throwable exc, A attachment) {
	//		}
	//	};
	
	// CompletionHandler는 completed()와 failed() 메소드가 있는데, completed()는 작업을 정상 처리 완료했을 때 호출되는 콜백 메소드이고,
	// failed()는 작업 처리 도중 예외가 발생했을 때 호출되는 콜백 메소드이다. CompletionHandler의 V 타입 파라미터는 결과값의 타입이고, A는 첨부값의 타입이다.
	// 첨부값은 콜백 메소드에 결과값 이외에 추가적으로 전달하는 객체라고 생삭하면 된다. 만약 첨부값이 필요없다면 A는 void로 지정해주면 된다. 다음은 작업 처리 결과에 따라 콜백 메소드를 호출하는 Runnable 객체이다.
	
	//	Runnable task = new Runnable() {
	//		@Override
	//		public void run() {
	//			try {
	//				// 작업 처리
	//				V result = ..;
	//				callback.completed(result, null);
	//			} catch (Exception e) {
	//				callback.failed(e, null);
	//			}
	//		}
	//	};
	
	// 작업 처리가 정상적으로 완료되면 completed() 콜백 메소드를 호출해서 결과값을 리턴하고, 예외가 발생하면 failed() 콜백 메소드를 호출해서 예외 객체를 전달한다.
	// 다음은 두 개의 문자열을 정수화해서 더하는 작업을 처리하고 결과를 콜백 방식으로 통보한다. 첫 번째 작업은 "3", "3" 을 주었고 두 번째 작업은 "3", "삼"을 주었다.
	// 첫 번째 작업은 정상적으로 처리되기 때문에 completed()가 자동 호출되고, 두 번째 작업은 NumberFormatException이 발생되어 failed() 메소드가 호출된다.
}
