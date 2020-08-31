package 챕터12_멀티스레드;

public class ㅂ5_WaitNotifyExample {
	public static void main(String[] args) {
		ㅂ5_DataBox dataBox = new ㅂ5_DataBox();
		
		ㅂ5_ProducerThread producerThread = new ㅂ5_ProducerThread(dataBox);
		ㅂ5_ConsummerThread consummerThread = new ㅂ5_ConsummerThread(dataBox);
		
		producerThread.start();
		consummerThread.start();
	}
}
