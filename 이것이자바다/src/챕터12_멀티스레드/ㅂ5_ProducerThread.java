package é��12_��Ƽ������;

public class ��5_ProducerThread extends Thread {
	private ��5_DataBox dataBox;
	
	public ��5_ProducerThread(��5_DataBox dataBox) {
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
