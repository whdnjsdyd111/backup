package 챕터12_멀티스레드;

import java.awt.Toolkit;

public class ㄴ2_BeepTask implements Runnable{
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			
			try {
				Thread.sleep(500);
			} catch(Exception e) {
				
			}
		}
	}
}
