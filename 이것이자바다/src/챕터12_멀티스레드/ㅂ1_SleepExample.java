package 챕터12_멀티스레드;

import java.awt.Toolkit;

public class ㅂ1_SleepExample {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		for (int i = 0; i < 10; i++) {
			toolkit.beep();
			
			try {
				Thread.sleep(3000);
			} catch(InterruptedException e) {
				
			}
		}
	}
}
