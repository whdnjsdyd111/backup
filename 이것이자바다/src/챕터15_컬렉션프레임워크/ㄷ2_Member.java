package é��15_�÷��������ӿ�ũ;

public class ��2_Member {
	public String name;
	public int age;
	
	public ��2_Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ��2_Member) {
			��2_Member member = (��2_Member) obj;
			return member.name.equals(name) && (member.age == age);
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}
}
