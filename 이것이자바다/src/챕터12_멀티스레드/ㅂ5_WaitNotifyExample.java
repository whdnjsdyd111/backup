package é��12_��Ƽ������;

public class ��5_WaitNotifyExample {
	public static void main(String[] args) {
		��5_DataBox dataBox = new ��5_DataBox();
		
		��5_ProducerThread producerThread = new ��5_ProducerThread(dataBox);
		��5_ConsummerThread consummerThread = new ��5_ConsummerThread(dataBox);
		
		producerThread.start();
		consummerThread.start();
	}
}
