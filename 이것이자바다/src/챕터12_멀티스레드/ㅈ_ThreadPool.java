package é��12_��Ƽ������;

public class ��_ThreadPool {
	// ���� �۾� ó���� �������� ������ ������ �����ǰ� �׿� ���� ������ ������ �����ٸ����� ���� CPU�� �ٺ��� �޸� ��뷮�� �þ��. ���� ���ø����̼��� ������ ���ϵȴ�.
	// ���۽��� ���� �۾��� �������� ���� �������� ������ �������� ������Ǯ(ThreadPool)�� ����ؾ� �Ѵ�.
	// ������Ǯ�� �۾� ó���� ���Ǵ� �����带 ���ѵ� ������ŭ ���س��� �۾� ť(Queue)�� ������ �۾����� �ϳ��� �����尡 �þ� ó���Ѵ�.
	// �۾� ó���� ���� ������� �ٽ� �۾� ť���� ���ο� �۾��� ������ ó���Ѵ�. �׷��� ������ �۾� ó�� ��û�� �����Ǿ �������� ��ü ������ �þ�� �����Ƿ� ���ø����̼��� ������ �ް��� ���ϵ��� �ʴ´�.
	
	// �ڹٴ� ������Ǯ�� �����ϰ� ����� �� �ֵ��� java.util.concurrent ��Ű������ ExecutorService �������̽��� Executor Ŭ������ �����ϰ� �ִ�.
	// Executor�� �پ��� ���� �޼ҵ带 �̿��ؼ� ExecutorService ���� ��ü�� ���� �� �ִµ�, �̰��� �ٷ� ������Ǯ�̴�. ������ ExecutorService�� �۵��ϴ� ����̴�.
	
	//	( ���ø����̼� )				(������Ǯ (ExecutorService) )
	//	1 ������Ǯ��									������ 1		��
	//	 �۾� ó�� ��û ��								 	3 �۾� ó��		��
	//				��							��				��
	//	4 ��� ����					2 �۾� ť							��	
	//		�� ������ 1				... �� �� ��		��				��
	//							�� ������� ť����			������ 2		��	�ִ� ���� ����
	//	1 ������Ǯ��	��			�۾��� ������ ó����		3 �۾� ó��		��
	//	 �۾� ó�� ��û ��												��
	//													.		��
	//	4 ��� ����											.		��
	//		�� ������ 2										.		��
	//												������ n		��
	
			//	Creation And End ThreadPool		������Ǯ ���� �� ����
	
			/*	Creation ThreadPool		������Ǯ ����	*/
	
	// ExecutorService ���� ��ü�� Executor Ŭ������ ���� �� ���� �޼ҵ� �� �ϳ��� �̿��ؼ� �����ϰ� ������ �� �ִ�.
	
	//			�޼ҵ��(�Ű�����)				�ʱ� ������ ��	�ھ� ������ ��	�ִ� ������ ��
	//	newCachedThreadPool()					0			0		Integer.MAX_VALUE
	//	newFixedThreadPool(int nThreads)		0		nThreads	nThreads
	
	// �ʱ� ������ ���� ExecutorService ��ü�� ������ �� �⺻������ �����Ǵ� ������ ���� ���ϰ�, 
	// �ھ� ������ ���� ������ ���� ������ �� ������ �ʴ� �����带 ������Ǯ���� ������ �� �ּ��� �����ؾ� �� ������ ���� ���Ѵ�.
	// �ִ� ������ ���� ������Ǯ���� �����ϴ� �ִ� ������ ���̴�.
	
	// newCachedThreadPool() �޼ҵ�� ������ ������Ǯ�� Ư¡�� �ʱ� ������ ������ �ھ� ������ ������ 0���̰�, ������ �������� �۾� ������ ������ �� �����带 �������� �۾��� ó���Ѵ�.
	// �̷������δ� int ���� ���� �� �ִ� �ִ밪��ŭ �����尡 �߰�������, �ü���� ���ɰ� ��Ȳ�� ���� �޶�����. 
	// 1�� �̻��� �����尡 �߰��Ǿ��� ��� 60�� ���� �߰��� �����尡 �ƹ� �۾��� ���� ������ �߰��� �����带 �����ϰ� Ǯ���� �����Ѵ�.
	// ������ newCachedThreadPool()�� ȣ���ؼ� ExecutorService ���� ��ü�� ��� �ڵ��̴�.
	
	//	ExecutorService executorService = Executors.newCachedThreadPool();
	
	// newFixedThreadPool(int nThreads) �޼ҵ�� ������ ������Ǯ�� �ʱ� ������ ������ 0���̰�, �ھ� ������ ���� nThreads�̴�.
	// ������ �������� �۾� ������ ������ �� �����带 ������Ű�� �۾��� ó���Ѵ�. �ִ� ������ ������ nThreads�̴�.
	// �� ������Ǯ�� �����尡 �۾��� ó������ �ʰ� ��� �ִ��� ������ ������ ���� �ʴ´�. ������ CPU �ھ��� ����ŭ �ִ� �����带 ����ϴ� ������Ǯ�� �����Ѵ�.
	
	//	ExecutorService executorService = Executor.newFixedThreadPool(
	//		Runtime.getRuntime().availableProcessors()
	//	);
	
	// newCachedThreadPool()�� newFixedThreadPool() �޼ҵ带 ������� �ʰ� �ھ� ������ ������ �ִ� ������ ������ �����ϰ� �ʹٸ� ���� ThreadPoolExecutor ��ü�� �����ϸ� �ȴ�.
	// ��� �� �� ���� �޼ҵ嵵 ���������� ThreadPoolExecutor ��ü�� �����ؼ� �����Ѵ�.
	// ������ �ʱ� ������ ������ 0��, �ھ� ������ ������ 3��, �ִ� ������ ������ 100���� ������Ǯ�� �����Ѵ�.
	// �׸��� �ھ� ������ 3���� ������ ������ �߰��� �����尡 120�� ���� ��� ���� ��� ���� �����带 �����ؼ� ������ ���� �����Ѵ�.
	
	//	ExecutorService threadPool = new ThreadPoolExecutor(
	//		3,		// �ھ� ������ ����
	//		100,	// �ִ� ������ ����
	//		120L.	// ��� �ִ� �ð�
	//		TimeUnit.SECONDS,	// ��� �ִ� �ð� ����
	//		new SynchronousQueue<Runnable>()		// �۾� ť
	//	);
	
			/*	End ThreadPool		������Ǯ ����	*/
	
	// ������Ǯ�� ������� �⺻������ ���� �����尡 �ƴϱ� ������ main �����尡 ����Ǵ��� �۾��� ó���ϱ� ���� ��� ���� ���·� �����ִ�.
	// �׷��� main() �޼ҵ尡 ������ ������ ���ø����̼� ���μ����� ������� �ʴ´�. ���ø����̼��� �����Ϸ��� ������Ǯ�� ������� ��������� ���� ���°� �ǵ��� ó�����־�� �Ѵ�.
	// ExecutorService�� ����� �����ؼ� ���� �� ���� �޼ҵ带 �����ϰ� �ִ�.
	
	//	���� Ÿ��			�޼ҵ��(�Ű�����)			����
	//		
	//	void			shutdown()			���� ó�� ���� �۾��Ӹ� �ƴ϶� �۾� ť�� ����ϰ� �ִ� ��� �۾��� ó���� �ڿ� ������Ǯ�� �����Ų��.
	//
	//	List<Runnable>	shutdownNow()		���� �۾� ó�� ���� �����带 interrupt�ؼ� �۾� ������ �õ��ϰ� ������Ǯ�� �����Ų��. ���ϰ��� �۾� ť�� �ִ� �̷�ġ�� �۾�(Runnable)�� ����̴�.
	//
	//	boolean			awaitTermination(	shutdown() �޼ҵ� ȣ�� ����, ��� �۾� ó���� timeout �ð� ���� �Ϸ��ϸ� true�� �����ϰ�,
	//					long timeout,		�Ϸ����� ���ϸ� �۾� ó�� ���� �����带 interrupt�ϰ� false�� �����Ѵ�.
	//					TimeUnit unit)
	
	// �����ִ� �۾��� �������ϰ� ������Ǯ�� ������ ������ shutdown()�� �Ϲ������� ȣ���ϰ�, �����ִ� �۾����� ������� ������ ������ ������ shutdownNow()�� ȣ���Ѵ�.
	
	//	executorService.shutdown();
	//	executorService.shutdownNow();
	
			//	Creation Task And Call Process		�۾� ������ ó�� ��û
	
			/*	Creation Task	�۾� ����	*/
	
	// �ϳ��� �۾��� Runnable �Ǵ� Callable ���� Ŭ������ ǥ���Ѵ�. Runnable�� Callable�� �������� �۾� ó�� �Ϸ� �� ���ϰ��� �ִ��� �������̴�.
	// ������ �۾��� �����ϱ� ���� Runnable�� Callable ���� Ŭ������ �ۼ��ϴ� ����̴�.
	
	//		Runnable ���� Ŭ����				|			Callable ���� Ŭ����
	//	Runnable task = new Runnable() {	|		Callable<T> task = new Callable<T>() {
	//		@Override						|			@Override
	//		public void run() {				|			public T call() throws Exception {
	//			// �����尡 ó���� �۾�				|				// �����尡 ó���� �۾� ����
	//		}								|				return T
	//	}									|			}
	//										|		}
	
	// Runnable�� run() �޼ҵ�� ���ϰ��� ����, Callable�� call() �޼ҵ�� ���ϰ��� �ִ�. call()�� ���� Ÿ���� implements Callable<T>�� ������ T Ÿ���̴�.
	// ������Ǯ�� ������� �۾� ť���� Runnable �Ǵ� Callable ��ü�� ������ run()�� call() �޼ҵ带 �����Ѵ�.
	
			/*	Call Task Process		�۾� ó�� ��û	*/
	
	// �۾� ó�� ��û�̶� ExecutorService�� �۾� ť�� Runnable �Ǵ� Callable ��ü�� �ִ� ������ ���Ѵ�. ExecutorService�� �۾� ó�� ��û�� ���� ���� �� ���� ������ �޼ҵ带 �����Ѵ�.
	
	//	����Ÿ��		�޼ҵ��(�Ű�����)					����
	//
	//	void		executor(Runnable command)		- Runnable�� �۾� ť�� ����
	//												- �۾� ó�� ����� ���� ����
	//
	//	Future<?>	submit(Runnable task)			- Runnable �Ǵ� Callable�� �۾� ť�� ����
	//	Future<V>	submit(Runnable task, V result)	- ���ϵ� Future�� ���� �۾� ó�� ����� ���� �� ����
	//	Future<V>	submit(Callable<V> task)
	
	// execute()�� submit() �޼ҵ��� �������� �� �����̴�. �ϳ��� execute()�� �۾� ó�� ����� ���� ���ϰ� submit()�� �۾� ó�� ����� ���� �� �ֵ��� Future�� �����Ѵ�.
	// �� �ٸ� �������� execute()�� �۾� ó�� ���� ���ܰ� �߻��ϸ� �����尡 ����ǰ� �ش� ������� ������Ǯ���� ���ŵȴ�. ���� ������Ǯ�� �ٸ� �۾� ó���� ���� ���ο� �����带 �����Ѵ�.
	// �ݸ鿡 submit()�� �۾� ó�� ���� ���ܰ� �߻��ϴ��� ������� ������� �ʰ� ���� �۾��� ���� ����ȴ�. �׷��� ������ �������̸� �������� ���� ��������� ���̱� ���� submit()�� ����ϴ� ���� ����.
	
	// ���� ������ Runnable �۾��� ������ �� Integer.parseInt("��")�� �־� NumberFormatException�� �߻��ϵ��� �����ߴ�.
	// 10���� �۾��� execute()�� submit() �޼ҵ�� ���� ó�� ��û ���� ��� ������Ǯ�� ���¸� ���캸��� ����. 
	
	// ������ �����ϸ� execute() �޼ҵ带 �����Ͽ��� ���� ������Ǯ�� ������ �ִ� ���� 2�� ���� ������, ���� �������� �̸��� ���� ��� �ٸ� �����尡 �۾��� ó���ϰ� �ִ�.
	// �̰��� �۾� ó�� ���� ���ܰ� �߻��߱� ������ �ش� ������� ���ŵǰ� �� �����尡 ��� �����Ǳ� �����̴�.
	// �ݸ鿡 submit() �޼ҵ�� �۾� ó���� ��û�� ���, execute()���� Ȯ���� �������� �� �� �ִ�. ���ܰ� �߻��ϴ��� �����尡 ������� �ʰ� ��� ����Ǿ� �ٸ� �۾��� ó���ϰ� �ִ� ���� �� �� �ִ�.
	
			//	Notify Task Completion Of Blocking Way		���ŷ ����� �۾� �Ϸ� �뺸
	
	// ExecutorService�� submit() �޼ҵ�� �Ű������� �� Runnable �Ǵ� Callable �۾��� ������Ǯ�� �۾� ť�� �����ϰ� ��� Future ��ü�� �����Ѵ�.
	
	//	����Ÿ��		�޼ҵ��(�Ű�����)					����
	// 
	//	Future<?>	submit(Runnable task)			- Runnable �Ǵ� Callable�� �۾� ť�� ����
	//	Future<V>	submit(Runnable task, V result)	- ���ϵ� Future�� ���� �۾� ó�� ����� ���� �� ����
	//	Future<V>	submit(Callable<V> task)
	
	// Future ��ü�� �۾� ����� �ƴ϶� �۾��� �Ϸ�� ������ ��ٷȴٰ�(�����ߴٰ�=���ŷ�Ǿ��ٰ�) ���� ����� ��µ� ���ȴ�.
	// �׷��� Future�� ���� �Ϸ�(pending completion) ��ü��� �Ѵ�. Future�� get() �޼ҵ带 ȣ���ϸ� �����尡 �۾��� �Ϸ��� ������ ���ŷ �Ǿ��ٰ� �۾��� �Ϸ��ϸ� ó�� ����� �����Ѵ�.
	// �̰��� ���ŷ�� ����ϴ� �۾� �Ϸ� �뺸 ����̴�. ������ Future�� ������ �ִ� get() �޼ҵ带 ������ ǥ�̴�.
	
	//	����Ÿ��	�޼ҵ��(�Ű�����)							����
	//	
	//	V		get()									�۾��� �Ϸ�� ������ ���ŷ�Ǿ��ٰ� ó�� ��� V�� ����
	//
	//	V		get(long timeout, TimeUnit unit)		timeout �ð� ���� �۾��� �Ϸ�Ǹ� ��� V�� ����������, �۾��� �Ϸ���� ������ TimeoutException�� �߻���Ŵ
	
	// ���� Ÿ���� V�� submit(Runnable task, V result)�� �� ��° �Ű����� V Ÿ���̰ų� submit(Callable<V> task)�� Callable Ÿ�� �Ķ���� V Ÿ���̴�.
	// ������ �� ���� submit() �޼ҵ庰�� Future�� get() �޼ҵ尡 �����ϴ� ���� �������� �����ش�.
	
	//	�޼ҵ�									�۾� ó�� �Ϸ� �� ���� Ÿ��				�۾� ó�� ���� ���� �߻�
	//
	//	submit(Runnable task)					future.get() -> null			future.get() -> ���� �߻�
	//
	//	submit(Runnable task, Integer result)	future.get() -> int Ÿ�� ��		future.get() -> ���� �߻�
	//
	//	submit(Callable<String> task)			future.get() -> String Ÿ�� ��		future.get() -> ���� �߻�
	
	// Future�� �̿��� ���ŷ ����� �۾� �Ϸ� �뺸���� ������ ���� �۾��� ó���ϴ� �����尡 �۾��� �Ϸ��ϱ� ������ get() �޼ҵ尡 ���ŷ�ǹǷ� �ٸ� �ڵ带 ������ �� ����.
	// ���� UI�� �����ϰ� �̺�Ʈ�� ó���ϴ� �����尡 get() �޼ҵ带 ȣ���ϸ� �۾��� �Ϸ��ϱ� ������ UI�� ������ ���� ���� �̺�Ʈ�� ó���� ���� ���� �ȴ�.
	// �׷��� ������ get() �޼ҵ带 ȣ���ϴ� ������� ���ο� �������̰ų� ������Ǯ�� �� �ٸ� �����尡 �Ǿ�� �Ѵ�.
	
	//	���ο� �����带 �����ؼ� ȣ��					|		������Ǯ�� �����尡 ȣ��
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
	
	// Future ��ü�� �۾� ����� ��� ���� get() �޼ҵ� �̿ܿ��� ������ ���� �޼ҵ带 �����Ѵ�.
	
	//	����Ÿ��		�޼ҵ��(�Ű�����)								����
	//
	//	boolean		cancel(boolean mayInterruptIfRunning)		�۾� ó���� ���� ���� ��� ��ҽ�Ŵ
	//
	//	boolean		isCancelled()								�۾��� ��ҵǾ����� ����
	//
	//	boolean		isDone()									�۾� ó���� �Ϸ�Ǿ����� ����
	
	// cancel() �޼ҵ�� �۾��� ����ϰ� ���� ��� ȣ���� �� �ִ�. �۾��� ���۵Ǳ� ���̶�� mayInterruptIfRunning �Ű������� ������� �۾� ��� �� true�� ����������,
	// �۾��� ���� ���̶�� mayInterruptIfRunning �Ű����� true�� ��쿡�� �۾� �����带 interrupt�Ѵ�.
	// �۾��� �Ϸ�Ǿ��� ��� �Ǵ� � ������ ���� ��ҵ� �� ���ٸ� cancel() �޼ҵ�� false�� �����Ѵ�.
	// isCancelld() �޼ҵ�� �۾��� �Ϸ�Ǳ� ���� �۾��� ��ҵǾ��� ��쿡�� true�� �����Ѵ�.
	// isDone() �޼ҵ�� �۾��� ������, ����, ��� �� � ���������� �۾��� �Ϸ�Ǿ��ٸ� true�� �����Ѵ�.
	
			/*	Notify Task Completion Without Return Value		���ϰ��� ���� �۾� �Ϸ� �뺸	*/
	
	// ���ϰ��� ���� �۾��� ���� Runnable ��ü�� �����ϸ� �ȴ�. ������ Runnable ��ü�� �����ϴ� ����� �����ش�.
	
	//	Runnable task = new Runnable() {
	//		@Override
	//		public void run() {
	//			// �����尡 ó���� �۾� ����
	//		}
	//	};
	
	// ������� ���� �۾� ó�� ��û��  submit(Runnable task) �޼ҵ带 �̿��ϸ� �ȴ�. ������� �������� �ұ��ϰ� ������ ���� Future ��ü�� �����ϴµ�,
	// �̰��� �����尡 �۾� ó���� ���������� �Ϸ��ߴ���, �ƴϸ� �۾� ó�� ���߿� ���ܰ� �߻��ߴ��� Ȯ���ϱ� ���ؼ��̴�.
	
	//	Future future = executorService.submit(task);
	
	// �۾� ó���� ���������� �Ϸ�Ǿ��ٸ� Future�� get() �޼ҵ�� null�� ���������� �����尡 �۾� ó�� ���� interrupt�Ǹ� InterruptedException�� �߻���Ű��, 
	// �۾� ó�� ���� ���ܰ� �߻��ϸ� ExecutionException�� �߻���Ų��. �׷��� ������ ���� ���� ó�� �ڵ尡 �ʿ��ϴ�.
	
	//	try {
	//		future.get();
	//	} catch (InterruptedException e) {
	//		// �۾� ó�� ���� �����尡 interrupt �� ��� ������ �ڵ�
	//	} catch (ExecutionException e) {
	//		// �۾� ó�� ���� ���ܰ� �߻��� ��� ������ �ڵ�
	//	}
	
	// ���� ������ ���ϰ��� ���� �ܼ��� 1���� 10������ ���� ����ϴ� �۾��� Runnable ��ü�� �����ϰ�, ������Ǯ�� �����尡 ó���ϵ��� ��û�� ���̴�.
	
			/*	Notify Task Completion With Return Value		���ϰ��� �ִ� �۾� �Ϸ� �뺸	*/
	
	// ������Ǯ�� �����尡 �۾��� �Ϸ��� �Ŀ� ���ø����̼��� ó�� ����� ���� �ȴٸ� �۾� ��ü�� Callable�� �����ϸ� �ȴ�.
	// ������ Callable ��ü�� �����ϴ� �ڵ��ε�, ������ ���� ���׸� Ÿ�� �Ƕ���� T�� call() �޼ҵ尡 �����ϴ� Ÿ���� �ǵ��� �Ѵ�.
	
	//	Callable<T> task = new Callable<T>() {
	//		@Override
	//		public T call() throws Exception {
	//			// �����尡 ó���� �۾� ����
	//			return T;
	//		}
	//	};
	
	// Callable �۾��� ó�� ��û�� Runnable �۾��� ���������� ExecutorService�� submit() �޼ҵ带 ȣ���ϸ� �ȴ�.
	// submit() �޼ҵ�� �۾� ť�� Callable ��ü�� �����ϰ� ��� Future<T>�� �����Ѵ�. �̶� T�� call() �޼ҵ尡 �����ϴ� Ÿ���̴�.
	
	//	Future<T> future = executorService.submit(task);
	
	// ������Ǯ�� �����尡 Callable ��ü�� call() �޼ҵ带 ��� �����ϰ� T Ÿ���� ���� �����ϸ�, Future<T>�� get() �޼ҵ�� ���ŷ�� �����ǰ� T Ÿ���� ���� �����ϰ� �ȴ�.
	
	//	try {
	//		T result = future.get();
	//	} catch (InterruptedException e) {
	//		// �۾� ó�� ���� �����尡 interrupt �� ��� ������ �ڵ�
	//	} catch (ExecutionException e) {
	//		// �۾� ó�� ���� ���ܰ� �߻��� ��� ������ �ڵ�
	//	}
	
	// ���� ������ 1���� 10���� ���� �����ϴ� �۾��� Callable ��ü�� �����ϰ�, ������Ǯ�� �����尡 ó���ϵ��� ��û�� ���̴�.
	
			/*	Save Task Completion Result On Outside Object		�۾� ó�� ����� �ܺ� ��ü�� ����	*/
	
	// ��Ȳ�� ���� �����尡 �۾��� ����� �ܺ� ��ü�� �����ؾ� �� ��쵵 �ִ�. ���� ��� �����尡 �۾� ó���� �Ϸ��ϰ� �ܺ� Result ��ü�� �۾� ����� �����ϸ�, 
	// ���ø����̼��� Result ��ü�� ����ؼ� � �۾��� ������ �� ���� ���̴�. �밳 Result ��ü�� ���� ��ü�� �Ǿ�, �� �� �̻��� ������ �۾��� ������ �������� �̿�ȴ�.
	
	//								������ 1
	//					Result	��	�۾� ó��
	//		��� �̿�	��	��� ����			
	//							��	������ 2
	//								�۾� ó��
	
	// �̷� �۾��� �ϱ� ���ؼ� ExecutorService�� submit(Runnable task, V result) �޼ҵ带 ����� �� �ִµ�, V�� �ٷ� Result Ÿ���� �ȴ�.
	// �޼ҵ带 ȣ���ϸ� ��� Future<V>�� ���ϵǴµ�, Future�� get() �޼ҵ带 ȣ���ϸ� �����尡 �۾��� �Ϸ��� ������ ���ŷ�Ǿ��ٰ� �۾��� �Ϸ��ϸ� V Ÿ�� ��ü�� �����Ѵ�.
	// ���ϵ� ��ü�� submit()�� �� ��° �Ű������� �� ��ü�� �����ѵ�, �������� ������ ó�� ����� ���ο� ����Ǿ� �ִٴ� ���̴�.

	//	Result result = ...;
	//	Runnable task = new Task(result);
	//	Future<Result> future = executorService.submit(task, result);
	//	result = future.get();
	
	// �۾� ��ü�� Runnable ���� Ŭ������ �����ϴµ�, ������ ���� �����忡�� ����� �����ϱ� ���� �ܺ� Result ��ü�� ����ؾ� �ϹǷ� �����ڸ� ���� Result ��ü�� ���Թ޵��� �ؾ� �Ѵ�.
	
	//	class Task implements Runnable {
	//		Result result;
	//		Task(Result result) { this.result = result; }
	//		@Override
	//		public void run() {		
	//			// �۾� �ڵ�
	//			// ó�� ����� result ����
	//		}
	//	}
	
	// ���� ������ 1���� 10������ ���� ����ϴ� �� ���� �۾��� ������Ǯ�� ó�� ��û�ϰ�, ������ �����尡 �۾� ó���� �Ϸ��� �� ����� ���� �ܺ� Result ��ü�� �����ϵ��� �ߴ�.
	
			/*	Notify On Task Completion Order		�۾� �Ϸ� ������ �뺸	*/
	
	// �۾� ��û ������� �۾� ó���� �Ϸ�Ǵ� ���� �ƴϴ�. �۾��� ��� ������ �����ٸ��� ���� ���� ��û�� �۾��� ���߿� �Ϸ�Ǵ� ��쵵 �߻��Ѵ�.
	// ���� ���� �۾����� ���������� ó���� �ʿ伺�� ����, ó�� ����� ���������� �̿��� �ʿ䰡 ���ٸ� �۾� ó���� �Ϸ�� �ͺ��� ����� ��� �̿��ϸ� �ȴ�.
	// ������Ǯ���� �۾� ó���� �Ϸ�� �͸� �뺸�޴� ����� �ִµ�, CompletionService�� �̿��ϴ� ���̴�. CompletionService�� ó�� �Ϸ�� �۾��� �������� poll()�� take() �޼ҵ带 �����Ѵ�.
	
	//	���� Ÿ��			�޼ҵ��(�Ű� ����)					����
	//
	//	Future<V>		poll()							�Ϸ�� �۾��� Future�� ������. �Ϸ�� �۾��� ���ٸ� ��� null�� ������
	//
	//	Future<V>		poll(long timeout,				�Ϸ�� �۾��� Future�� ������.
	//					TimeUnit unit)					�Ϸ�� �۾��� ���ٸ� timeout���� ���ŷ��.
	//
	//	Future<V>		take()							�Ϸ�� �۾��� Future�� ������. �Ϸ�� �۾��� ���ٸ� ���� ������ ���ŷ��.
	//
	//	Future<V>		submit(Callable<V> task)		������Ǯ�� Callable �۾� ó�� ��û
	//
	//	Future<V>		submit(Runnable task, V result)	������Ǯ�� Runnable �۾� ó�� ��û
	
	// CompletionService ���� Ŭ������ ExecutorCompletionService<V>�̴�. ��ü�� ������ �� ������ �Ű������� ExecutorService�� �����ϸ� �ȴ�.
	
	//	ExecutorService executorService = Executors.newFixedThreadPool(
	//		Runtime.getRuntime().availableProcessors()
	//	);
	//	CompletionService<V> completionService = new ExecutorCompletionService<V>(
	//		executorService
	//	);
	
	// poll()�� take() �޼ҵ带 �̿��ؼ� ó�� �Ϸ�� �۾��� Future�� �������� CompletionService�� submit() �޼ҵ�� �۾� ó�� ��û�� �ؾ� �Ѵ�.
	
	//	completionService.submit(Callable<V> task);
	//	completionService.submit(Runnable task, V result);
	
	// ������ take() �޼ҵ带 ȣ���Ͽ� �Ϸ�� Callable �۾��� ���� ������ ���ŷ�Ǿ��ٰ� �Ϸ�� �۾��� Future�� ���, get() �޼ҵ�� ������� ���� �ڵ��̴�.
	// while���� ���ø����̼��� ����� ������ �ݺ� �����ؾ� �ϹǷ� ������Ǯ�� �����忡�� �����ϴ� ���� ����.
	
	//	executorService.submit(new Runnable() {		// ������Ǯ�� �����忡��  �����ϵ��� ��
	//		@Override
	//		public void run() {
	//			while(true) {
	//				try {
	//					Future<Integer> future = completionService.take();	// �Ϸ�� �۾��� ���� ������ ���ŷ/�Ϸ�� �۾��� ������ Future�� ����
	//					int value = future.get();							// get()�� ���ŷ���� �ʰ� �ٷ� �۾� ����� ����
	//					System.out.println("[ ó�� ��� ] " + value);
	//				} catch (Exception e) {
	//					break;
	//				}
	//			}
	//		}
	//	});
	
	// take() �޼ҵ尡 �����ϴ� �Ϸ�� �۾��� submit()���� ó�� ��û�� �۾��� ������ �ƴ��� ����ؾ� �Ѵ�. �۾��� ���뿡 ���� ���� ��û�� �۾��� ���߿� �Ϸ�� ���� �ֱ� �����̴�. 
	// �� �̻� �Ϸ�� �۾��� ������ �ʿ䰡 ���ٸ� take() ���ŷ���� �������� while���� �����ؾ� �Ѵ�. 
	// ExecutorService�� shutdownNow()�� ȣ���ϸ� take()���� InterruptedException�� �߻��ϰ� catch ������ break�� �Ǿ� while���� �����ϰ� �ȴ�.
	// ���� ������ 3���� Callable �۾��� ó�� ��û�ϰ� �Ϸ�Ǵ� ������ �۾��� ������� �ֿܼ� ����ϵ��� �ߴ�.
	
			//	Notify Task Completion Of Callback Way		�ݹ� ����� �۾� �Ϸ� �뺸
	
	// �̹����� �ݹ�(callback) ����� �̿��ؼ� �۾� �Ϸ� �뺸�� �޴� ����� ���ؼ� �˾ƺ���. �ݹ��̶� ���ø����̼��� �����忡�� �۾� ó���� ��û�� ��, �����尡 �۾��� �Ϸ��ϸ� Ư�� �޼ҵ带 �ڵ� �����ϴ� ����� ���Ѵ�.
	// �̶� �ڵ� ����Ǵ� �޼ҵ带 �ݹ� �޼ҵ��� �Ѵ�. ������ ���ŷ ��İ� �ݹ� ����� ���� ���̴�.
	
	//	[ ���ŷ ��� ]							[ �ݹ� ��� ]
	//										
	//	���� ������			������Ǯ				���� ������			������Ǯ
	//		��	1 �۾� ó�� ��û	��					��	1 �۾� ó�� ��û	��
	//		��	������������������	��					��	������������������	��
	//		��	�禡��������������	��					��	�禡��������������	��
	//			2 Future						��	2 Future	��	
	//	3 Future.get()		4 ����		   3 ����	��				��
	//		���ŷ												3 ����
	//						��								�ݹ�	��
	//		��	��			��				��� �޼ҵ�() {	������������������
	//		�� 5 ����	��		��					4 ����	��
	//		��				��				}			��
	//		��			��	��				
	
	// ���ŷ ����� �۾� ó���� ��û�� �� �۾��� �Ϸ�� ������ ���ŷ������, �ݹ� ����� �۾� ó���� ��û�� �� ����� ��ٸ� �ʿ� ���� �ٸ� ����� ������ �� �ִ�.
	// �� ������ �۾� ó���� �Ϸ�Ǹ� �ڵ������� �ݹ� �޼ҵ尡 ����Ǿ� ����� �� �� �ֱ� �����̴�.
	// �ƽ��Ե� ExecutorService�� �ݹ��� ���� ������ ����� �������� �ʴ´�. ������ Runnable ���� Ŭ������ �ۼ��� �� �ݹ� ����� ������ �� �ִ�.
	// ���� �ݹ� �޼ҵ带 ���� Ŭ������ �־�� �ϴµ�, ���� �����ص� ���� java.nio.channels.CompletionHandler�� �̿��ص� ����.
	// �� �������̽��� NIO ��Ű���� ���ԵǾ� �ִµ� �񵿱� ��ſ��� �ݹ� ��ü�� ���� �� ���ȴ�.
	// �׷� CompletionHandler�� �̿��ؼ� �ݹ� ��ü�� ����� ����� ���캸��. ������ CompletionHandler ��ü�� �����ϴ� �ڵ��̴�.
	
	//	CompletionHandler<V, A> callback = new CompletionHandler<V, A>() {
	//		@Override
	//		public void completed(V result, A attachment) {
	//		}
	//
	//		@Override
	//		public void failed(Throwable exc, A attachment) {
	//		}
	//	};
	
	// CompletionHandler�� completed()�� failed() �޼ҵ尡 �ִµ�, completed()�� �۾��� ���� ó�� �Ϸ����� �� ȣ��Ǵ� �ݹ� �޼ҵ��̰�,
	// failed()�� �۾� ó�� ���� ���ܰ� �߻����� �� ȣ��Ǵ� �ݹ� �޼ҵ��̴�. CompletionHandler�� V Ÿ�� �Ķ���ʹ� ������� Ÿ���̰�, A�� ÷�ΰ��� Ÿ���̴�.
	// ÷�ΰ��� �ݹ� �޼ҵ忡 ����� �̿ܿ� �߰������� �����ϴ� ��ü��� �����ϸ� �ȴ�. ���� ÷�ΰ��� �ʿ���ٸ� A�� void�� �������ָ� �ȴ�. ������ �۾� ó�� ����� ���� �ݹ� �޼ҵ带 ȣ���ϴ� Runnable ��ü�̴�.
	
	//	Runnable task = new Runnable() {
	//		@Override
	//		public void run() {
	//			try {
	//				// �۾� ó��
	//				V result = ..;
	//				callback.completed(result, null);
	//			} catch (Exception e) {
	//				callback.failed(e, null);
	//			}
	//		}
	//	};
	
	// �۾� ó���� ���������� �Ϸ�Ǹ� completed() �ݹ� �޼ҵ带 ȣ���ؼ� ������� �����ϰ�, ���ܰ� �߻��ϸ� failed() �ݹ� �޼ҵ带 ȣ���ؼ� ���� ��ü�� �����Ѵ�.
	// ������ �� ���� ���ڿ��� ����ȭ�ؼ� ���ϴ� �۾��� ó���ϰ� ����� �ݹ� ������� �뺸�Ѵ�. ù ��° �۾��� "3", "3" �� �־��� �� ��° �۾��� "3", "��"�� �־���.
	// ù ��° �۾��� ���������� ó���Ǳ� ������ completed()�� �ڵ� ȣ��ǰ�, �� ��° �۾��� NumberFormatException�� �߻��Ǿ� failed() �޼ҵ尡 ȣ��ȴ�.
}
