package é��07_���;

public class ��2_SupersonicAirplane extends ��2_Airplane{
	public static final int NOMAL = 1;
	public static final int SUPERSONIC = 2;
	
	public int flyMode = NOMAL;
	
	@Override
	public void fly() {
		if(flyMode == SUPERSONIC) {
			System.out.println("�����Ӻ����մϴ�");
		} else {
			super.fly();	// Airplane ��ü�� fly() �޼ҵ� ȣ��
		}
	}
}
