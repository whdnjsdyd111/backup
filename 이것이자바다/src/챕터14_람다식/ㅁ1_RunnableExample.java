package 챕터14_람다식;

public class ㅁ1_RunnableExample {
	public static void main(String[] args) {
		Runnable runnable = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
			}
		};									// 람다식
		
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
