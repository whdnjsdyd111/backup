package 챕터16_스트림_병렬처리;

public class ㅋ1_Student {
	public enum Sex { MALE, FEMALE }
	public enum City { Seoul, Pusan }
	
	private String name;
	private int score;
	private Sex sex;
	private City city;
	
	public ㅋ1_Student(String name, int score, Sex sex) {
		this.name = name;
		this.score = score;
		this.sex = sex;
	}
	
	public ㅋ1_Student(String name, int score, Sex sex, City city) {
		this.name = name;
		this.score = score;
		this.sex = sex;
		this.city = city;
	}
	
	public String getName() { return name; }
	public int getScore() { return score; }
	public Sex getSex() { return sex; }
	public City getCity() { return city; }
}
