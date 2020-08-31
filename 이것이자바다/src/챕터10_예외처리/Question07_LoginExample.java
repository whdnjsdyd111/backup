package é��10_����ó��;

public class Question07_LoginExample {
	public static void main(String[] args) {
		
		try {
			login("white", "12345");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			login("blue", "54321");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void login(String id, String password) throws Question07_NotExistIDException, Question07_WrongPasswordException {
		
		// id�� "blue"�� �ƴ϶�� NotExistIDException �߻���Ŵ
		
		if(!id.equals("blue")) {
			throw new Question07_NotExistIDException("���̵� �������� �ʽ��ϴ�.");
		}
		
		// password�� "12345"�� �ƴ϶�� WrongPasswordException �߻���Ŵ
		
		if(!password.equals("12345")) {
			throw new Question07_WrongPasswordException("�н����尡 Ʋ���ϴ�.");
		}
		
	}
}
