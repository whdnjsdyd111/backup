package 챕터15_컬렉션프레임워크;

public class ㄷ2_Member {
	public String name;
	public int age;
	
	public ㄷ2_Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ㄷ2_Member) {
			ㄷ2_Member member = (ㄷ2_Member) obj;
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
