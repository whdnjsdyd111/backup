package 챕터06_클래스;

public class Question15Example {
	public static void main(String[] args) {
		
		Question15 q = new Question15();
		
		boolean result = q.login("hong", "12345");
		
		if(result) {
			System.out.println("로그인 되었습니다");
			q.logout("hong");
		} else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
	}
}
