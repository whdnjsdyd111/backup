package 챕터12_멀티스레드;

public class ㅂ_ControlThreadState {
	// 사용자는 미디어 플레이어에서 동영상을 보다가 일시 정지시킬 수도 있고, 종료시킬 수도 있다. 일시 정지는 조금 후 다시 동영상을 보겠다는 의미이므로 미디어 플레이어는 동영상 스레드를 일시 정지 상태로 만들어야 한다.
	// 그리고 종료는 더 이상 동영상을 보지 않겠다는 의미이므로 미디어 플레이어는 스레드를 종료 상태로 만들어야 한다. 이와 같이 실행 중인 스레드의 상태를 변경하는 것을 스레드 상태 제어라고 한다.
	// 멀티 스레드 프로그램을 만들기 위해서는 정교한 스레드 상태 제어가 필요한데, 상태 제어가 잘못되면 프로그램은 불안정해져서 먹통이 되거나 다운된다.
	// 멀티 스레드 프로그래밍이 어렵다고 하는 이유가 바로 여기에 있다. 스레드는 잘 이용하면 약이 되지만, 잘못 사용하면 치명작인 플그램 버그가 되기 때문에 스레드를 정확하게 제어하는 방법을 잘 알고 있어야 한다.
	// 스레드 제어를 제대로 하기 위해서는 스레드의 상태 변화를 가져오는 메소드들을 파악하고 있어야 한다. 다음은 상태 변화를 가져오는 메소드의 종류를 보여준다.
	
	//					interrupt()
	//					notify()
	//					notifyAll()		→	실행 대기
	//					[resume()]
	//				↗
	//
	//		일시 정지					yield()	↑	↓
	//					
	//				↖
	//					sleep()
	//					join()
	//					wait()			→ 	실행			─ [stop()] →	종료
	//					[suspend()]
	
	// 위를 보면 대괄호 안의 메소드가 있는데 이 의미는 스레드의 안전성을 해친다고 하여 더 이상 사용하지 않도록 권장된 Deprecated 메소드들이다.
	
	//		메소드				설명
	//
	//		interrupt()			일시 정지 상태의 스레드에서 InterruptException 예외를 발생시켜, 예외 처리 코드(catch)에서 실행 대기 상태로 가거나 종료 상태로 갈 수 있도록 한다.
	//
	//		notify()			동기화 블록 내에서 wait() 메소드에 의해 일시 정지 상태에 있는
	//		notifyAll()			스레드를 실행 대기 상태로 만든다.
	//
	//		resume()			suspend() 메소드에 의해 일시 정지 상태에 있는 스레드를 실행 대기 상태로 만든다. - Deprecated( 대신 notify(), notifyAll() 사용 )
	//
	//		sleep(long millis)				주어진 시간 동안 스레드를 일시 정지 상태로 만든다. 
	//		sleep(long millis, int nanos)	주어진 시간이 지나면 자동적으로 실행 대기 상태가 된다.
	//
	//		join()							join() 메소드를 호출한 스레드는 일시 정지 상태가 된다. 실행 대기 상태로 가려면,
	//		join(long millis)				join() 메소드를 멤버로 가지는 스레드가 종료되거나, 매개값으로 주어진 시간이 지나야 한다.
	//		join(long millis, int nanos)		
	//
	//		wait()							동기화(synchronized) 블록 내에서 스레드를 일시 정지 상태로 만든다. 매개값으로
	//		wait(long millis)				주어진 시간이 지나면 자동적으로 실행 대기 상태가 된다. 시간이 주어지지 않으면
	//		wait(long millis, int nanos)	notify(), notifyAll() 메소드에 의해 실행 대기 상태로 갈 수 있다.
	//
	//		suspend()			스레드를 일시 정지 상태로 만든다. resume() 메소드를 호출하면 다시 실행 대기 상태가 된다. - Deprecated( 대신 wait() 사용 )
	//
	//		yield()				실행 중에 우선순위가 동일한 다른 스레드에게 실행을 양보하고 실행 대기 상태가 된다.
	//
	//		stop()				스레드를 즉시 종료시킨다. - Deprecated
	
	// 위 표에서 wait(), notify(), notifyAll()은 Object 클래스의 메소드이고, 그 이외의 메소드는 모두 Thread 클래스의 메소드들이다.
	// wait(), notify(), notifyAll() 메소드의 사용 방법은 스레드의 동기화에서 자세히 설명하기로 하고, 이번 절에서는 Thread 클래스의 메소드들만 살펴볼 것이다.
	
			//	Pause For A Given Time ( sleep() )		주어진 시간동안 일시 정지( sleep() )
	
	// 실행 중인 스레드를 일정 시간 멈추게 하고 싶다면  Thread 클래스의 정적 메소드인 sleep()을 사용하면 된다. 
	// 다음과 같이 Thread.sleep() 메소드를 호출한 스레드는 주어진 시간 동안 일시 정지 상태가 되고, 다시 실행 대기 상태로 돌아간다.
	
	//	try {
	//		Thread.sleep(1000);
	//	} catch(InterruptedException e){
	//		// interrupt() 메소드가 호출되면 실행
	//	}
	
	// 매개값에는 얼마 동안 일시 정지 상태로 있을 것인지, 밀리세컨드(1/1000) 단위로 시간을 주면 된다.
	// 위와 같이 1000이라는 값을 주면 스레드는 1초가 경과할 동안 일시 정지 상태로 있게 된다.
	// 일시 정지 상태에서 주어진 시간이 되기 전에 interrupt() 메소드가 호출되면 InterruptedException이 발생하기 때문에 예외 처리가 필요하다. 다음 예제는 3초 주기로 비프(beep)음을 10번 발생시킨다.
	
			//	Run Yield To Another Thread		다른 스레드에게 실행 양보
	
	// 스레드가 처리하는 작업은 반복적인 실행을 위해 for문이나 while문을 포함하는 경우가 많다. 가끔은 이 반복문들이 무의미한 반복을 하는 경우가 있다. 다음 코드를 살펴보자.
	
	//	public void run() {
	//		while(true) {
	//			if(work) {
	//				System.out.println("ThreadA 작업 내용");
	//			}
	//		}
	//	}
	
	// 스레드가 시작되어 run() 메소드를 실행하면 while(true) {} 블록을 무한 반복 실행한다. 만약 work의 값이 false라면 그리고 work의 값이 false에서 true로 변경되는 시점이 불확명하다면,
	// while문은 어떠한 실행문도 실행하지 않고 무의미한 반복을 한다. 이것보다는 다른 스레드에게 실행을 양보하고 자신은 실행 대기 상태로 가는 것이 전체 프로그램 성능에 도움이 된다.
	// 이런 기능을 위해서 스레드는 yield() 메소드를 제공하고 있다. yield() 메소드를 호출한 스레드는 실행 대기 상태로 돌아가고 동일한 우선순위 또는 높은 우선순위를 갖는 다른 스레드가 실행 기회를 가질 수 있도록 해준다.
	
	//		실행 대기 상태
	//	스레드1		스레드2 ( 동일 또는 높은 우선순위 )
	//	1 yield		  2
	//		↖		↗
	//		실행( run() )
	
	// 다음 코드는 의미 없는 반복을 줄이기 위해 yield() 메소드를 호출해서 다른 스레드에게 실행 기회를 주도록 수정한 것이다.
	
	//	public void run() {
	//		while(true) {
	//			if(work) {
	//				System.out.println("ThreadA 작업 내용");
	//			} else {
	//				Thread.yield();
	//			}
	//		}
	//	}
	
	// 다음 예제는 처음 실행 후 3초 동안은 ThreadA와 ThreadB가 번갈아가며 실행된다. 3초 뒤에 메인 스레드가 ThreadA의 work 필드를 false로 변경함으로써 ThreadA는 yield() 메소드를 호출한다.
	// 따라서 이후 3초 동안에는 ThreadB가 더 많은 실행 기회를 얻게 된다. 메인 스레드는 3초 뒤에 다시 ThreadA의 work 필드를 true로 변경해서 ThreadA와 ThreadB가 번갈아가며 실행하도록 한다.
	// 마지막으로 메인 스레드는 3초 뒤에 ThreadA와 ThreadB의 stop() 필드를 true로 변경해서 두 스레드가 반복 작업을 중지하고 종료하도록 한다.
	
			//	Waiting For Other Thread To Close ( join() )	다른 스레드의 종료를 기다림 ( join() )
	
	// 스레드는 다른 스레드와 독립적으로 실행하는 것이 기본이지만 다른 스레드가 종료될 때까지 기다렸다가 실행해야 하는 경우가 발생할 수도 있다.
	// 예를 들어 계산 작업을 하는 스레드가 모든 계산 작업을 마쳤을 때, 계산 결과값을 받아 이용하는 경우가 이에 해당된다. 이런 경우를 위해서 Thread는 join() 메소드를 제공하고 있다. 다음을 보고 이해해보자.
	
	//		ThreadA			1		ThreadB
	//	threadB.start();	→	run() {
	//	threadB.join()				↓2
	//			↓←		←		←}
	//			3
	
	// ThreadA가 ThreadB의 join() 메소드를 호출하면 ThreadA는 ThreadB가 종료할 때까지 일시 정지 상태가 된다.
	// ThreadB의 run() 메소드가 종료되면 비로소 ThreadA는 일시 정지에서 풀려 다음 코드를 실행하게 된다. 그럼 이제 예제를 살펴보자.
	
	// 예제를 보면 메인 스레드는 SumThread가 계산 작업을 모두 마칠 때까지 일시 정지 상태에 있다가 SumThread가 최종 계산된 결과값을 산출하고 종료하면 결과값을 받아 출력한다.
	// JoinExample 클래스의 8~12라인을 주석 처리허고 실행하면 1~100까지의 합은 0이 나오게 된다. 그 이유는 SumThread가 계산 작업을 완료하지 않은 상태에서 합을 먼저 출력하기 때문이다.
	
			//	Collaboration Between Thread ( wait(), notify(), nofityAll() )	스레드 간 협업 ( wait(), notify(), nofityAll() )
	
	// 경우에 따라서는 두 개의 스레드를 교대로 번갈아가며 실행해야 할 경우가 있다. 정확한 교대 작업이 필요할 경우, 자신의 작업이 끝나면 상대방 스레드를 일시 정지 생태에서 풀어주고, 자신은 일시 정지 상태로 만드는 것이다.
	// 이 방법의 핵심은 공유 객체에 있다. 공유 객체는 두 스레드가 작업할 내용을 각각 동기화 메소드로 구분해 놓는다. 
	// 한 스레드가 작업을 완료하면 notify() 메소드를 호출해서 일시 정지 상태에 있는 다른 스레드를 실행 대기 상태로 만들고, 자신은 두 번 작업을 하지 않도록 wait() 메소드를 호출하여 일시 정지 상태로 만든다.
	
	//		일시 정지
	//	waiting Pool( 1 wait() )
	//			스레드		→		실행 대기 ( RUNNABLE )
	//						3			
	//										↓
	//						↖
	//				notify() 2				실행
	//				notifyAll()				스레드
	
	// 만약 wait() 대신 wait(long timeout)이나, wait(long timeout, int nanos)를 사용하면 notify()를 호출하지 않아도 지정된 시간이 지나면 스레드가 자동적으로 실행 대기 상태가 된다.
	// notify() 메소드와 동일한 역할을 하는 notifyAll() 메소드도 있는데, notify()는 wait()에 의해 일시 정지된 스레드 중 한 개를 실행 대기 상태로 만들고, 
	// notifyAll() 메소드는 wait()에 의해 일시 정지된 모든 스레드들을 실행 대기 상태로 만든다.
	// 이 메소드들은 Thread 클래스가 아닌 Object 클래스에 선언된 메소드이므로 모든 공유 객체에서 호출이 가능하다. 주의할 점은 이 메소드들은 동기화 메소드 또는 동기화 블록 내에서만 사용할 수 있다.
	// 다음 예제는 두 스레드의 작업을 WorkObject의 methodA()와 methodB()에 정의해 두고, 두 스레드는 ThreadA와 ThreadB가 교대로 methodA()와 methodB()를 호출하도록 했다.
	
	// 다음 예제는 데이터를 저장하는 스레드 ( 생산자 스레드 )가 데이터를 저장하면, 데이터를 소비하는 스레드( 소비자 스레드)가 데이터를 읽고 처리하는 교대 작업을 구현한 것이다.
	
	//				2 데이터 저장		5 데이터 읽기
	//					→				→
	//	4		생산자			공유 객체		소비자
	//	wait()	스레드			 데이터		스레드	1 wait()
	//
	//			↓
	//			→			→		→		→↑
	//					3 notify()
	
	// 생산자 스레드는 소비자 스레드가 읽기 전에 새로운 데이터를 두 번 생성하면 안되고( setData() 메소드를 두 번 실행하면 안됨. ), 
	// 소비자 스레드는 생산자 스레드가 새로운 데이터를 생성하기 전에 이전 데이터를 두 번 읽어서도 안된다( getData() 메소드를 두 번 실행하면 안됨. ).
	// 구현 방법은 공유 객체( DataBox)에 데이터를 저장할 수 있는 data 필드의 값이 null이면 생성자 스레드를 실행 대기 상태로 만들고, 소비자 스레드를 일시 정지 상태로 만드는 것이다.
	// 반대로 data 필드의 값이 null이 아니면 소비자 스레드를 실행 대기 상태로 만들고, 생성자 스레드를 일시 정지 상태로 만들면 된다.
	
			//	Security End Of Thread( stop 플래그, interrupt() )		스레드의 안전한 종료( stop 플래그, interrupt() )
	
	// 스레드는 자신의 run() 메소드가 모두 실행되면 자동적으로 종료된다. 경우에 따라서는 실행 중인 스레드를 즉시 종료할 필요가 있다. 예를 들어 동영상을 끝까지 보지 않고, 사용자가 멈춤을 요구할 수 있다.
	// Thread는 스레드를 즉시 종료시키기 위해서 stop() 메소드를 제공하고 있는데, 이 메소드는 deprecated되었다.
	// 그 이유는 stop() 메소드로 스레드를 갑자기 종료하게 되면 스레드가 사용 중이던 자원들이 불안전한 상태로 남겨지기 때문이다.
	// 여기서 자원이란 파일, 네트워크 연결 등을 말한다. 그렇다면 스레드를 즉시 종료시키기 위한 최선의 방법은 무엇일까?
	
			/*	How To Use The Stop Flag	stop 플래그를 이용하는 방법*/
	
	// 스레드는 run() 메소드가 끝나면 자동적으로 종료되므로, run() 메소드가 정상적으로 종료되도록 유도하는 것이 최선의 방법이다. 다음 코드는 stop 플래그를 이용해서 run() 메소드의 종료를 유도한다.
	
	//	public class XXXThread extends Thread {
	//		private boolean stop;		// stop 플래그 필드
	//
	//		public void run() {
	//			while( !stop ) {		// stop이 true가 되면 run()이 종료된다.
	//				스레드가 반복 실행하는 코드;
	//			}
	//			// 스레드가 사용한 자원 정리
	//		}
	//	}
	
	// 위 코드에서 stop 필드가 false일 경우에는 while문의 조건식이 true가 되어 반복 실행하지만, stop 필드가 true일 경우에는 while문의 조건식이 false가 되어 while문을 빠져나온다.
	// 그리고 스레드가 사용한 저원을 정리하고, run() 메소드가 끝나게 됨으로써 스레드는 안전하게 종료된다.
	// 다음 예제는 PrintThread1을 실행한 후 1초 후에 PrintThread1을 멈추도록 setStop() 메소드를 호출한다.
	
			/*	How To Use The interrupt() Method		interrupt() 메소드를 이용하는 방법 */
	
	// interrupt() 메소드는 스레드가 일시 정지 상태에 있을 때 InterruptedException 예외를 발생시키는 역할을 한다.
	// 이것을 이용하면 run() 메소드를 정상 종료시킬 수 있다. 예를 들어 다음과 같이 ThreadA가 ThreadB를 생성해서 start() 메소드로 ThreadB를 실행했다고 가정하자.
	
	//		ThreadA								ThreadB
	//
	//		ThreadB threadB = new ThreadB();	public void run() {	
	//		threadB.start();				1↗		try {
	//			...										while(true) {
	//														...
	//		threadB.interrupt();		2→				Thread.sleep(1);	// 일시정지	↓ 3
	//													}
	//												} catch(InterruptedException e) {	←
	//												}
	//												// 스레드가 사용한 자원 정리
	//											}
	
	// ThreadA가 ThreadB의 interrupt() 메소드를 실행하게 되면 ThreadB가 sleep() 메소드로 일시 정지 상태가 될 때 
	// threadB에서 InterruptedException이 발생하여 예외처리(catch) 블록으로 이동한다.
	// 결국 ThreadB는 while문을 빠져나와 run() 메소드를 정상 종료하게 된다. 다음 예제는 PrintThread2를 실행한 후 1초 후에 PrintThread2를 멈추도록 interrupt() 메소드를 호출한다.
	
	// 주목할 점은 스레드가 실행 대기 또는 실행 상태에 있을 때 interrupt() 메소드가 실행되면 즉시 InterruptedException 예외가 발생되지 않고,
	// 스레드가 미래에 일시 정지 상태가 되면 InterruptedException 예외가 발생한다는 것이다. 따라서 스레드가 일시 정지 상태가 되지 않으면 interrupt() 메소드 호출은 아무런 의미가 없다.
	// 그래서 짧은 시간이나마 일시 정지 시키기 위해 Thread.sleep(1)을 사용한 것이다.
	
	// 일시 정지를 만들지 않고도 interrupt() 호출 여부를 알 수 있는 방법이 있다. interrupt() 메소드가 호출되었다면 스레드의 interrupted()와 isInterrupted() 메소드는 true를 리턴한다.
	// interrupted()는 정적 메소드로 현재 스레드가 interrupted 되었는지 확인하는 것이고, isInterrupted()는 인스턴스 메소드로 현재 스레드가 interrupted 되었는지 확인할 때 사용한다.
	// 둘중 어떤 것을 사용해도 좋다.
	
	//	boolean status = Thread.interrupted();
	//	boolean status = objThread.isInterrupted();
	
	// 다음은 PrintThread2를 수정한 것인데, 일시 정지 코드인 Thread.sleep(1)을 사용하지 않고, 
	// Thread.interrupted()을 사용해서 PrintThread2의 interrupt()가 호출되었는지 확안한 다음 while문을 빠져나가도록 했다.
	
}
