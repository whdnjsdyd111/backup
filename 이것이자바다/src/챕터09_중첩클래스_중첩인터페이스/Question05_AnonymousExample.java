package é��09_��øŬ����_��ø�������̽�;

public class Question05_AnonymousExample {
	public static void main(String[] args) {
		Question05_Anonymous anony = new Question05_Anonymous();
		
		anony.field.run();
		
		anony.method1();
		
		anony.method2(new Question05_Vehicle() {
			
			@Override
			public void run() {
				System.out.println("Ʈ���� �޸��ϴ�.");
			}
		});
	}
}
