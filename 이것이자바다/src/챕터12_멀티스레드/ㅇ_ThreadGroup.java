package 챕터12_멀티스레드;

public class ㅇ_ThreadGroup {
	// 스레드 그룹( ThreadGroup ) 은 관련된 스레드를 묶어서 관리할 목적으로 이용된다.
	// JVM이 실행되면 system 스레드 그룹을 만들고, JVM 운영에 필요한 스레드들을 생성해서 system 스레드 그룹에 포함시킨다.
	// 그리고  system의 하위 스레드 그룹으로 main을 만들고 메인 스레드를 main 스레드 그룹에 포함 시킨다.
	// 스레드는 반드시 하나의 스레드 그룹에 포함되는데, 명시적으로 스레드 그룹에 포함시키지 않으면 기본적으로 자신을 생성한 스레드와 같은 스레드 그룹에 속하게 된다.
	// 우리가 생성하는 작업 스레드는 대부분 main 스레드가 생성하므로 기본적으로 main 스레드 그룹에 속하게 된다.
	
			//	Getting Thread Group Name		스레드 그룹 이름 얻기
	
	// 현재 스레드가 속한 스레드 그룹의 이름을 얻고 싶다면 다음과 같은 코드를 사용할 수 있다.
	
	//	ThreadGroup group = Thread.currentThread().getThreadGroup();
	//	String groupName = group.getName();
	
	// Thread의 정적 메소드인 getAllStackTraces()를 이용하면 프로세스 내에서 실행하는 모든 스레드에 대한 정보를 얻을 수 있다.
	
	//	Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
	
	// getAllStackTraces() 메소드는 Map 타입의 객체를 리턴하는데, 키는 스레드 객체이고 값은 스레드의 상태 기록을 갖고 있는 StackTraceElement[] 배열이다.
	// Map 타입에 대한 자세한 내용은 15장에서 학습한다. 다음 예제는 현재 실행하고 있는 스레드의 이름과 데몬 여부 그리고 속한 스레드 그룹 이름이 무엇인지 출력한다.
	
	// 실행 결과를 보면 가비지 컬렉션을 담당하는 Finalizer 스레드를 비롯한 일부 스레드들이 system 그룹에 속하고, main() 메소드를 실행하는 main 스레드는 system 그룹의 하위 스룹인 main에 속하는 것을 볼 수 있다.
	// 그리고 main 스레드가 실행시킨 AutoSaveThread는 main 스레드가 소속된 main 그룹에 포함되어 있는 것을 볼 수 있다.
	
			//	Creation Thread Group		스레드 그룹 생성
	
	// 명시적으로 스레드 그룹을 만들고 싶다면 다음 생성자 중 하나를 이용해서 ThreadGroup 객체를 만들면 된다.
	// ThreadGroup 이름만 주거나, 부모 ThreadGroup과 이름을 매개값으로 줄 수 있다.
	
	//	ThreadGroup tg = new ThreadGroup(String name);
	//	ThreadGroup tg = new ThreadGroup(ThreadGroup parent, String name);
	
	// 스레드 그룹 생성 시 부모(parent) 스레드 그룹을 지정하지 않으면 현재 스레드가 속한 그룹의 하위 그룹으로 생성된다.
	// 예를 들어 main 스레드가 ThreadGroup(String name)을 이용해서 새로운 스레드 그룹을 생성하면, main 스레드 그룹의 하위 스레드 그룹이 된다.
	// 새로운 스레드 그룹을 생성한 후, 이 그룹에 스레드를 포함시키려면 Thread 객체를 생성할 때 생성자 매개값으로 스레드 그룹을 지정하면 된다.
	// 스레드 그룹을 매개값으로 갖는 Thread 생성자는 다음 네 가지가 있다.
	
	//	Thread t = new Thread(ThreadGroup, Runnable target);
	//	Thread t = new Thread(ThreadGroup, Runnable target, String name);
	//	Thread t = new Thread(ThreadGroup, Runnable target, String name, long stackSize);
	//	Thread t = new Thread(ThreadGroup, String name);
	
	// Runnable 타입의 target은 Runnable 구현 객체를 말하며, String 타입의 name은 스레드의 이름이다. 그리고 long 타입의 stackSize는 JVM이 이스레드에 할당할 stack 크기이다.
	
			//	Batch Of Thread Group ( interrupt() )		스레드 그룹의 일괄 ( interrupt() )
	
	// 스레드를 스레드 그룹에 포함시키면 어떤 이점이 있을까? 스레드 그룹에서 제공하는 interrupt() 메소드를 이용하면 그룹 내에서 포함된 모든 스레드들을 일괄 interrupt할 수 있다.
	// 예를 들어 10개의 스레드들을 모두 종료시키기 위해 각 스레드에서 interrupt() 메소드를 10번 호출할 수도 있지만, 
	// 이 스레드들이 같은 스레드 그룹에 소속되어 있을 경우, 스레드 그룹의 interrupt() 메소드를 한번만 호출해주면 된다.
	// 이것이 가능한 이유는 스레드 그룹의 interrupt() 메소드는 포함된 모든 스레드의 interrupt() 메소드를 내부적으로 호출해주기 때문이다.
	
	//	ThreadGroup
	//						interrupt()
	//		Thread - 1	↙		...			↘	Thread - n
	//		interrupt()							interrupt()
	
	// 스레드 그룹의 interrupt() 메소드는 소속된 스레드의 interrupt() 메소드를 호출만 할 뿐 개별 스레드에서 발행하는 InterruptedException에 대한 예외 처리를 하지않는다.
	// 따라서 안전한 종료를 위해서는 개별 스레드가 예외 처리를 해야한다.
	
	// 스레드 그룹에는 interrupt() 메소드 이외에도 suspend(), resume(), stop() 메소드들이 있는데, 모두 Deprecated되었다.
	// stop() 메소드를 호출하면 그룹에 포함된 모든 스레드들의 stop() 메소드가 일괄 호출되어 모든 스레드들을 쉽게 종료할 수 있으나, 스레드의 안전성 문제 때문에 가급적 사용하지 말아야 한다.
	// 대신 interrupt() 메소드로 스레드들을 안전하게 종료할 수 있도록 유도하는 것이 좋다. 다음은 ThreadGroup이 가지고 있는 주요 메소드들이다.
	
	//		메소드											설명
	//
	//	int			activeCount()				현재 그룹 및 하위 그룹에서 활동 중인 모든 스레드의 수를 리턴한다.
	//
	//	int			activeGroupCount()			현재 그룹에서 활동 중인 모든 하위 그룹의 수를 리턴한다.
	//
	//	void		checkAccess()				현재 스레드가 스레드 그룹을 변경할 권한이 있는지 체크한다. 만약 권한이 없으면 SecurityException을 발생시킨다.
	//
	//	void		destroy()					현재 그룹 및 하위 그룹을 모두 삭제한다. 단, 그룹 내에 포함된 모든 스레드들이 종료 상태가 되어야 한다.
	//
	//	boolean		isDestroyed()				현재 그룹이 삭제되었는지 여부를 리턴한다.
	//	
	//	int 		getMaxPriority()			현재 그룹에 포함된 스레드가 가질 수 있는 최대 우선순위를 리턴한다.
	//
	//	void		setMaxPriority(int pri)		현재 그룹에 포함된 스레드가 가질 수 있는 최대 우선순위를 설정한다.
	//
	//	String		getName()					현재 그룹의 이름을 리턴한다.
	//
	//	ThreadGroup	getParent()					현재 그룹의 부모 그룹을 리턴한다.
	//
	//	boolean		parentOf(ThreadGroup g)		현재 그룹이 매개값으로 지정한 스레드 그룹의 부모인지 여부를 리턴한다.
	//
	//	boolean		isDaemon(boolean daemon)	현재 그룹이 데몬 그룹인지 여부를 리턴한다.
	//
	//	void		setDaemon(boolean daemon)	현재 그룹을 데몬 그룹으로 설정한다.
	//
	//	void		list()						현재 그룹에 포함된 스레드와 하위 그룹에 대한 정보를 출력한다.
	//
	//	void		interrupt()					현재 그룹에 포함된 모든 스레드들을 interrupt한다.
	
	// 다음 예제는 스레드 그룹을 생성하고, 정보를 출력해본다. 그리고 3초 후 스레드 그룹의 interrupt() 메소드를 호출해서 스레드 그룹에 포함된 모든 스레드들을 종료시킨다.
	
	// 예제를 실행 시키면, 현재 스레드 그룹에 포함된 스레드와 하위 스레드 그룹의 내용을 보여준다. 스레드는 [스레드이름, 우선순위, 소속 그룹명]으로 출력되는 것을 볼 수 있다.
	// 그리고 interrupt() 메소드로 그룹에 포함된 두 스레드가 종료되는 것을 볼수 있다.
	
	
}
