package é��07_���;

public class ��3_Tire {
	
	// �ʵ�
	public int maxRotation;				// �ִ� ȸ����(Ÿ�̾� ����)
	public int accumulatedRotation;		// ���� ȸ����
	public String location;				// Ÿ�̾��� ��ġ
	
	// ������
	public ��3_Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	// �޼ҵ�
	public boolean roll() {
		++accumulatedRotation;	// ���� ȸ���� 1����
		
		if(accumulatedRotation < maxRotation) {
			
			System.out.println(location + " Tire ����: " + 
					(maxRotation - accumulatedRotation) + "ȸ");
			
			return true;
			
		} else {
			System.out.println("*** " + location + " Tire ��ũ ***");
			return false;
		}
	}
}
