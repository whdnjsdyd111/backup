package é��06_Ŭ����;

public class ��3_CarExample {
	public static void main(String[] args) {
		��3_Car car1 = new ��3_Car();
		System.out.println(car1.company);
		System.out.println();
		
		��3_Car car2 = new ��3_Car("�ڰ���");
		System.out.println(car2.company + "\t" + car2.model);
		System.out.println();
		
		��3_Car car3 = new ��3_Car("�ڰ���", "����");
		System.out.println(car3.company + "\t" + car3.model + "\t" + car3.color);
		System.out.println();
		
		��3_Car car4 = new ��3_Car("�ý�", "����", 200);
		System.out.println(car4.company + "\t" + car4.model + "\t" + car4.color + "\t" + car4.maxSpeed);
	}
}
