package é��09_��øŬ����_��ø�������̽�;

public class Question05_Anonymous {
	Question05_Vehicle field = new Question05_Vehicle() {
		
		@Override
		public void run() {
			System.out.println("�����Ű� �޸��ϴ�.");
		}
	};
	
	void method1() {
		Question05_Vehicle localVar = new Question05_Vehicle() {
			
			@Override
			public void run() {
				System.out.println("�¿����� �޸��ϴ�.");
			}
		};
		localVar.run();	
	}
	
	void method2(Question05_Vehicle v) {
		v.run();
	}
}
