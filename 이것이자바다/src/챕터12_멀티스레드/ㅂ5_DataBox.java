package é��12_��Ƽ������;

public class ��5_DataBox {
	private String data;
	
	public synchronized String getData() {
		if(this.data == null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}						// data �ʵ尡 null�̸� �Һ��� �����带 �Ͻ� ���� ���·� ����
		
		String returnValue = data;
		System.out.println("ConsummerThread�� ���� ������: " + returnValue);
		
		data = null;
		notify();
		return returnValue;		// data �ʵ带 null�� ����� ������ �����带 ���� ��� ���·� ����
	}
	
	public synchronized void setData(String data) {
		if(this.data != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}						// data �ʵ尡 null�� �ƴϸ� ������ �����带 �Ͻ� ���� ���·� ����
		
		this.data = data;
		System.out.println("ProducerThread�� ������ ������: " + data);
		notify();				// data �ʵ忡 ���� �����ϰ� �Һ��� �����带 ���� ��� ���·� ����

	}
}
