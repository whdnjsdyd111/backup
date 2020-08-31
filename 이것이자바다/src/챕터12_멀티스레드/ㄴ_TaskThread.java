package 챕터12_멀티스레드;

public class ㄴ_TaskThread {
	// 멀티 스레드로 실행하는 애플리케이션을 개발하려면 먼저 몇 개의 작업을 병렬로 실행할지 결정하고 각 직업별로 스레드를 생성해야 한다.
	
	//				프로그램에서 병렬로 실행할 작업을 결정
	//		↓				↓			↓
	//		메인작업			작업1			작업2
	//		↓				↓			↓
	//		메인 스레드			스레드1		스레드2
	//		(프로그램 시작)		(네트워킹)		(드로잉)
	
	// 어떤 자바 애플리케이션이건 메인 스레드는 반드시 존재하기 때문에 메인 작업 이외에 추가적인 병렬 작업의 수만큼 스레드를 생성하면 된다.
	// 자바에서는 작업 스레드도 객체로 생성되기 때문에 클래스가 필요하다. java.lang.Thread 클래스를 직접 객체화해서 생성해도 되지만, Thread를 상속해서 하위 클래스를 만들어 생성할 수도 있다.
	
			//	Directly Creation From Thread Class		Thread 클래스로부터 직접 생성
	
	// java.lang.Thread 클래스로부터 작업 스레드 객체를 직접 생성하려면 다음과 같이 Runnable을 매개값으로 갖는 생성자를 호출해야한다.
	
	//	Thread thread = new Thread(Runnable target);
	
	// Runnable은 작업 스레드가 실행할 수 있는 코드를 가지고 있는 객체라고 해서 붙여진 이름이다.
	// Runnable은 인터페이스 타입이기 때문에 구현 객체를 만들어 대입해야 한다. Runnable에는 run() 메소드 하나가 정의되어 있는데, 구현 클래스는 run()을 재정의해서 작업 스레드가 실행할 코드를 작성해야 한다.
	// 다음은 Runnable 구현 클래스를 작성하는 방법을 보여준다.
	
	//	class Task implements Runnable {
	//		public void run() {
	//			스레드가 실행할 코드;
	//		}
	//	}
	
	// Runnable은 작업 내용을 가지고 있는 객체이지 실제 스레드는 아니다. Runnable 구현 객체를 생성한 후, 이것을 매개값으로 해서 Thread 생성자를 호출하면 비로소 작업 스레드가 생성된다.
	
	//	Runnable task = new Task();
	//			  └──────────────────┐
	//								 ↓
	//	Thread thread = new Thread(task);
	
	// 코드를 더 절약하기 위해 Thread 생성자를 호출할 때 Runnable 익명 객체를 매개값으로 사용할 수 있다. 오히려 이 방법이 더 많이 사용된다.
	
	//	Thread thread = new Thread(new Runnable() {
	//		public void run() {
	//			스레드가 실행할 코드;
	//		}
	//	});
	
	// Runnable 인터페이스는 run() 메소드 하나만 정의되어 있기 때문에 함수적 인터페이스이다. 따라서 다음과 같이 람다식을 매개값으로 사용할 수 있다.
	// 가장 간단한 방법이지만, 자바 8 부터 지원되기 때문에 자바 7 이전 버전에서는 사용할 수 없다. 람다식은 14장에서 배우게 될 것이다.
	
	//	Thread thread = new Thread( () -> {
	//		스레드가 실행할 코드;						// 람다식
	//	});
	
	// 작업 스레드는 생성되는 즉시 실행되는 것이 아니라, start() 메소드를 다음과 같이 호출해야만 비로소 실행된다.
	
	//	thread.start();
	
	// start() 메소드가 호출되면, 작업 스레드는 매개값으로 받은 Runnable의 run() 메소드를 실행하면서 자신의 작업을 처리한다.
	
	//	메인 스레드					↙	class Task implements Runnable {
	//			↓		  1	↙			public void run() {
	//		스레드 객체 생성	←		  2	↗		↓ 3 작업 스레드 실행
	//		start() 메소드 호출		↗		}
	//			↓ 3 메인스레드 실행		}
	
	// 0.5초 주기로 비프(beep) 음을 발생시키면서 동시에 프린팅하는 작업이 있다고 가정해보자. 비프음 발생과 프린팅은 서로 다른 작업이므로 메인 스레드가 동시에 두 가지 작업을 처리할 수 없다.
	// 만약 다음과 같이 작성했다면 메인 스레드는 비프음을 모두 발생한 다음, 프린팅을 시작한다. 다음 예제 BeepPrintExample을 살펴보자
	
	// 비프음을 발생시키면서 동시에 프린팅을 하려면 두 작업 중 하나를 메인 스레드가 아닌 다른 스레드에서 실행시켜야 한다.
	// 프린팅은 메인 스레드가 담당하고 비프음을 들려주는 것은 작업 스레드가 담당하도록 수정해보자.
	// 우선 작업을 정의하는 Runnable 구현 클래스를 다음과 같이 작성한다. 예제를 살펴보자.
	
	// BeepTask 객체를 생성후 작업 스레드를 생성해 start() 메소드를 호출하여 작업 스레드를 실행시켜 비프음을 발생시킴과 동시에 메인 스레드인 "띵"을 픤팅한다.
	// 다음은 작업 스레드를 만들 수 있는 또 다른 두 가지 방법을 보여준다
	
	//	// Runnable 익명 객체 사용
	//
	//	Thread thread = new Thread(new Runnable() {
	//		@Override
	//		public void run() {
	//			Toolkit toolkit = Toolkit.getDefaultToolkit();
	//			for(int i = 0; i < 5; i++) {
	//				toolkit.beep();
	//				try {
	//					Thread.sleep(500);
	//				} catch(Exception e) {
	//					
	//				}
	//			}
	//		});
	
	//	// 람다식 사용
	//
	//	Thread thread = new Thread( () -> {
	//		Toolkit toolkit = Toolkit.getDefaultToolkit();
	//		for(int i = 0; i < 5; i++) {
	//			toolkit.beep();
	//			try {
	//				Thread.sleep(500);
	//			} catch(Exception e) {
	//				
	//			}
	//		}
	//	});
	
			// Creation From Thread Subclass	Thread 하위 클래스로부터 생성
	
	// 작업 스레드가 실행할 작업을 Runnable로 만들지 않고, Thread의 하위 클래스로 작업 스레드를 정의하면서 작업 내용을 포함시킬 수도 있다.
	// 다음은 작업 스레드 클래스를 정의하는 방법인데, Thread 클래스를 상속한 후 run 메소드를 재정의해서 스레드가 실행할 코드를 작성하면 된다.
	// 작업 스레드 클래스로부터 작업 스레드 객체를 생성하는 방법은 일반적인 객체를 생성하는 방법과 동일하다.
	
	//	public class WorkerThread extends Thread {
	//		@Override
	//		public void run() {
	//			// 스레드가 실행할 코드;
	//		}
	//	}
	//	Thread thread = new WorkerThread();
	
	// 코드를 좀 더 절약하기 위해 다음과 같이 Thread 익명 객체로 작업 스레드 객체를 생성할 수도 있다.
	
	//	Thread thread = new Thread() {
	//		public void run() {
	//			스레드가 실행할 코드;
	//		}
	//	};
	
	// 이렇게 생성된 작업 스레드 객체에서 start() 메소드를 호출하면 작업 스레드는 자신의 run() 메소드를 실행하게 된다.
	
	//	thread.start();
	
	//	메인 스레드					
	//							
	//		스레드 객체 생성	→ 1		스레드 객체
	//		start() 메소드 호출	→ 2	public void run() {
	//								↓ 3 작업 스레드 실행
	//		↓ 3 메인 스레드 실행		}
	//							
	//
	
	// 다음 BeepThread 클래스는 Runnable을 생성하지 않고 Thread 하위 클래스로 작업 스레드를 정의한 것이다.
	
	// 다음은 익명 객체를 이용한 방법이다.
	
	//	Thread thread = new Thread() {
	//		@Override
	//		public void run() {
	//			Toolkit toolkit = new Toolkit.getDefaultToolkit();
	//
	//			for(int i = 0; i < 5; i++) {
	//				toolkit.beep();
	//			}
	//		}
	//	};
	
			//	Thread Name		스레드의 이름
	
	// 스레드는 자신의 이름을 가지고 있다. 스레드의 이름이 큰 역할을 하는 것은 아니지만, 디버깅할 때 어떤 스레드가 어떤 작업을 하는지 조사할 목적으로 가끔 사용된다.
	// 메인 스레드는 "main"이라는 이름을 가지고 있고, 우리가 직접 생성한 스레드는 자동적으로 "Thread-n"이라는 이름으로 설정 된다. n은 스레드의 번호를 말한다.
	// Thread-n 대신 다른 이름으로 설정하고 싶다면 Thread 클래스의 setName() 메소드로 변경하면 된다.
	
	//	thread.setName("스레드 이름");
	
	// 반대로 스레드 이름을 알고 싶을 경우에는 getName() 메소드를 호출하면 된다.
	
	//	thread.getName();
	
	// setName()과 getName()은 Thread의 인스턴스 메소드이므로 스레드 객체의 참조가 필요하다.
	// 만약 스레드 객체의 참조를 가지고 있지 않다면, Thread의 정적 메소드인 currentThread()로 코드를 실행하는 현재 스레드의 참조를 얻을 수 있다.
	
	// Thread thread = Thread.currentThread();
	
	// 다음 예제는 메인 스레드의 참조를 얻어 스레드 이름을 콘솔에 출력하고, 새로 생성한 스레드의 이름을 setName() 메소드로 설정한 후, getName() 메소드로 읽어오도록 했다.
	
	
}
