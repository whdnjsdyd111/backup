package é��11_�⺻APIŬ����.��_ObjectŬ����.��_��ü����_clone.��_��������_thinClone;

// ���� ������ Member Ŭ������ Cloneable �������̽��� �����߱� ������ 
// getMember() �޼ҵ忡�� clone() �޼ҵ�� �ڽ��� ������ ��, ������ ��ü�� �ܺη� ������ �� �ִ�.

public class Member implements Cloneable { // ������ �� �ִٴ� ǥ��
	public String id;
	public String name;
	public String password;
	public int age;
	public boolean adult;
	
	public Member(String id, String name, String password, int age, boolean adult) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.adult = adult;
	}
	
	public Member getMember() {
		Member cloned = null;
		try {
			cloned = (Member) clone(); // clone() �޼ҵ��� ���� Ÿ���� Object�̹Ƿ� Member Ÿ������ ĳ�����ؾ� ��
		} catch(CloneNotSupportedException e) {}
		return cloned;
	}
}
