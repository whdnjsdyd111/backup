package 챕터12_멀티스레드;

public class ㅅ_DaemonThread {
	// 데몬( daemon ) 스레드는 주 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드이다.
	// 주 스레드가 종료되면 데몬 스레드는 강제적으로 자동 종료되는데, 그 이유는 주 스레드의 보조 역할을 수행하므로 주 스레드가 종료되면 데몬 스레드의 존재 의미가 없어지기 때문이다.
	// 이 점을 제외하면 데몬 스레드는 일반 스레드와 크게 차이가 없다. 데몬 스레드의 적용 예는 워드 프로세서의 자동 저장, 미디어 플레이어의 동영상 및 음악 재생, 가비지 컬렉터 등이 있는데,
	// 이 기능들은 주 스레드(워드프로세스, 미디어 플레이어, JVM)가 종료되면 같이 종료된다.
	// 스레드를 데몬으로 만들기 위해서는 주 스레드가 데몬이 될 스레드의 setDaemon(true)를 호출해주면 된다.
	// 아래 코드를 보면 메인 스레드가 주 스레드가 되고 AutoSaveThread가 데몬 스레드가 된다.
	
	//	public static void main(String[] args) {
	//		AutoSaveThread thread = new AutoSaveThread();
	//		thread.setDaemon(true);
	//		thread.start();
	//	}
	
	// 주의할 점은 start() 메소드가 호출되고 나서 setDaemon(true)를 호출하면 IllegalThreadStateException이 발생하기 때문에 start() 메소드 호출 전에 setDaemon(true)를 호출해야 한다.
	// 현재 실행 중인 스레드가 데몬 스레드인지 아닌지를 구별하는 방법은 isDaemon() 메소드의 러턴값을 조사해보면 된다. 데몬 스레드일 경우 true를 리턴한다.
	// 다음 예제는 1초 주기로 save() 메소드를 자동 호출하도록 AutoSaveThread를 작성하고, 메인 스레드가 3초 후 종료되면 AutoSaveThreaed도 같이 종료되도록 데몬 스레드로 만들었다.
	
	
}
