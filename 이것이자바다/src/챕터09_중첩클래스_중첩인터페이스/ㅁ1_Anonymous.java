package 챕터09_중첩클래스_중첩인터페이스;

public class ㅁ1_Anonymous {
	ㅁ1_Person field = new ㅁ1_Person() {
		void work() {
			System.out.println("출근합니다.");
		}
		
		@Override
		void wake() {
			System.out.println("6시에 일어납니다.");
			work();
		}
	};
	
	void method1() {
		
		/* 로컬 변수값으로 대입 */
		ㅁ1_Person localVar = new ㅁ1_Person() {
			void walk() {
				System.out.println("산책합니다");
			}
			
			@Override
			void wake() {
				System.out.println("7시에 일어납니다.");
				walk();
			}
		};
		
		/* 로컬 변수 사용*/
		localVar.wake();
	}
	
	void method2(ㅁ1_Person person) {
		person.wake();
	}
}
