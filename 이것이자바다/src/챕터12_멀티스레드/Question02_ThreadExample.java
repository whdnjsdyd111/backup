package é��12_��Ƽ������;

public class Question02_ThreadExample {
	public static void main(String[] args) {
		Thread thread1 = new Question02_MovieThread();
		thread1.start();
		
		Thread thread2 = new Thread(new Question02_MusicRunnable());
		thread2.start();
	}
}
