package é��06_Ŭ����;

public class ��1_CarExample {
	public static void main(String[] args) {
		
		// ��ü ����
		��1_Car car = new ��1_Car();
		
		// �ʵ尪 �б�
		System.out.println("����ȸ��: " + car.company);
		System.out.println("�𵨸�: " + car.model);
		System.out.println("����: "  + car.color);
		System.out.println("�ְ�ӵ�: " + car.maxSpeed);
		System.out.println("����ӵ�: " + car.speed);
		
		// �ʵ尪 ����
		car.speed = 60;
		System.out.println("������ ����ӵ�: " + car.speed);
	}

}
