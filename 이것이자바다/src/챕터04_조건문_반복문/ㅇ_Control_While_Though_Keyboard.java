package é��04_���ǹ�_�ݺ���;

public class ��_Control_While_Though_Keyboard {
	public static void main(String[] args) throws Exception {
		
		boolean run = true;
		int speed = 0;
		int keyboard = 0;
		
		while(run) {
			
			if(keyboard !=13 && keyboard != 10) {
				System.out.println("-------------------------");
				System.out.println("1.���� �� 2.���� �� 3.����");
				System.out.println("-------------------------");
				System.out.println("����: ");
			}
			
			keyboard = System.in.read();
			
			if(keyboard == 49) {	// 1�� �о��� ���
				speed++;
				System.out.println("����ӵ� = " + speed);
			} else if(keyboard == 50) {	// 2�� �о��� ���
				speed--;
				System.out.println("����ӵ� = " + speed);
			} else if(keyboard == 51) { // 3�� �о��� ���
				run = false;
			}
		}
		
		System.out.println("�ý��� ����");
		
	}
}
