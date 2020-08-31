package 챕터12_멀티스레드;

public class ㅂ5_ConsummerThread extends Thread {
	private ㅂ5_DataBox dataBox;
	
	public ㅂ5_ConsummerThread(ㅂ5_DataBox dataBox) {
		this.dataBox = dataBox;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 3; i++) {
			String data = dataBox.getData();
		}
	}
}
