package é��06_Ŭ����;

public class Question15Example {
	public static void main(String[] args) {
		
		Question15 q = new Question15();
		
		boolean result = q.login("hong", "12345");
		
		if(result) {
			System.out.println("�α��� �Ǿ����ϴ�");
			q.logout("hong");
		} else {
			System.out.println("id �Ǵ� password�� �ùٸ��� �ʽ��ϴ�.");
		}
	}
}
