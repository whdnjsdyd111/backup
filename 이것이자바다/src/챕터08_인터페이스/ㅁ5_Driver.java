package é��08_�������̽�;

public class ��5_Driver {
	public void drive(��4_Vehicle vehicle) {
		if(vehicle instanceof ��4_Bus) {
			��4_Bus bus = (��4_Bus) vehicle;
			bus.checkFare();		// Bus Ÿ������ ���� Ÿ�� ��ȯ�� �ϴ� ����
		}
		
		vehicle.run();
	}
}
