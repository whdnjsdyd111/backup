package é��11_�⺻APIŬ����.question11.Question04;

public class Member {
	private String id;
	private String name;
	
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return id + ": " + name;
	}
}
