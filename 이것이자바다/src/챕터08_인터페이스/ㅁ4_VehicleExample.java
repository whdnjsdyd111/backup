package é��08_�������̽�;

public class ��4_VehicleExample {
	public static void main(String[] args) {
		
		��4_Vehicle vehicle = new ��4_Bus();
		
		vehicle.run();
//		vehicle.checkFare(); (x)	// Vehicle �������̽����� checkFare()�� ����
		
		��4_Bus bus = (��4_Bus) vehicle;	// ���� Ÿ�� ��ȯ
		
		bus.run();
		bus.checkFare();			// Bus Ŭ�������� checkFare()�� ����
	}
}
