package é��07_���;

public class ��3_HankookTire extends ��3_Tire{
	//�ʵ�
	
	// ������
	public ��3_HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	// �޼ҵ�
	@Override
	public boolean roll() {
		++accumulatedRotation;	// ���� ȸ���� 1����
		
		if(accumulatedRotation < maxRotation) {
			
			System.out.println(location + " HankookTire ����: " + 
					(maxRotation - accumulatedRotation) + "ȸ");
			
			return true;
			
		} else {
			System.out.println("*** " + location + " HankookTire ��ũ ***");
			return false;
		}
	}		// ��� ������ �޸��ϱ� ���� ������ �޼ҵ�
}
