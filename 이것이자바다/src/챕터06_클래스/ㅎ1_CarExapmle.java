package é��06_Ŭ����;

public class ��1_CarExapmle {
	public static void main(String[] args) {
		��1_Car car = new ��1_Car();
		
		// �߸��� �ӵ� ����
		car.setSpeed(-50);
		
		System.out.println("���� �ӵ�: " + car.getSpeed());
		
		// �ùٸ� �ӵ� ����
		car.setSpeed(60);
		
		System.out.println("���� �ӵ�: " + car.getSpeed());
		
		// ����
		if(!car.isStop()) {
			car.setStop(true);
		}
		
		System.out.println("���� �ӵ�: " + car.getSpeed());
	}
}
