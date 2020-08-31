package 챕터08_인터페이스;

public class Question05_ActionExample {
	public static void main(String[] args) {
		
		Question05_Action action = new Question05_Action() {
			
			@Override
			public void work() {
				System.out.println("복사를 합니다.");
			}
		};
		
		action.work();
		
	}
}
