package é��06_Ŭ����;

public class Question18 {
	private static Question18 singleton = new Question18();
	
	private Question18() {}
	
	static Question18 getInstance() {
		return singleton;
	}
}
