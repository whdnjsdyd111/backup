package é��09_��øŬ����_��ø�������̽�;

public class ��1_Anonymous {
	��1_Person field = new ��1_Person() {
		void work() {
			System.out.println("����մϴ�.");
		}
		
		@Override
		void wake() {
			System.out.println("6�ÿ� �Ͼ�ϴ�.");
			work();
		}
	};
	
	void method1() {
		
		/* ���� ���������� ���� */
		��1_Person localVar = new ��1_Person() {
			void walk() {
				System.out.println("��å�մϴ�");
			}
			
			@Override
			void wake() {
				System.out.println("7�ÿ� �Ͼ�ϴ�.");
				walk();
			}
		};
		
		/* ���� ���� ���*/
		localVar.wake();
	}
	
	void method2(��1_Person person) {
		person.wake();
	}
}
