package é��06_Ŭ����;

public class Question15 {
	private String id = "hong";
	private String password = "12345";
	
	public Question15() {}
	
	public boolean login(String id, String password) {
		if(id.equals(this.id) && password.equals(this.password)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void logout(String id) {
		if(id.equals(this.id)) {
			System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
		}
	}
}
