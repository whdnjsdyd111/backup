package 챕터16_스트림_병렬처리;

public class ㄷ1_Member {
	public static int MALE = 0;
	public static int FEMALE = 1;
	
	private String name;
	private int sex;
	private int age;
	
	public ㄷ1_Member(String name, int sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	
	public int getSex() { return sex; }
	public int getAge() { return age; }
}
