package é��07_���;

public class ��3_KumhoTire extends ��3_Tire {
	// �ʵ�
	
	// ������
	public ��3_KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	// �޼ҵ�
	@Override
	public boolean roll() {
		++accumulatedRotation;	// ���� ȸ���� 1����
		
		if(accumulatedRotation < maxRotation) {
			
			System.out.println(location + " KumhoTire ����: " + 
					(maxRotation - accumulatedRotation) + "ȸ");
			
			return true;
			
		} else {
			System.out.println("*** " + location + " KumhoTire ��ũ ***");
			return false;
		}
	}		// ��� ������ �޸��ϱ� ���� ������ �޼ҵ�
}
