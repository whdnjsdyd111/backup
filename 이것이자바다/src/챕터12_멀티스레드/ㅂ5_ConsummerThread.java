package é��12_��Ƽ������;

public class ��5_ConsummerThread extends Thread {
	private ��5_DataBox dataBox;
	
	public ��5_ConsummerThread(��5_DataBox dataBox) {
		this.dataBox = dataBox;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 3; i++) {
			String data = dataBox.getData();
		}
	}
}
