package é��14_���ٽ�;

public class ��1_RunnableExample {
	public static void main(String[] args) {
		Runnable runnable = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
			}
		};									// ���ٽ�
		
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
