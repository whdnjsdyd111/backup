package 챕터12_멀티스레드;

public class ㅂ5_ProducerThread extends Thread {
	private ㅂ5_DataBox dataBox;
	
	public ㅂ5_ProducerThread(ㅂ5_DataBox dataBox) {
		this.dataBox = dataBox;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 3; i++) {
			String data = "Data-" + i;
			dataBox.setData(data);
		}
	}
}
