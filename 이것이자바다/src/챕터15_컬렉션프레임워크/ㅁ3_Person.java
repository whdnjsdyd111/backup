package 챕터15_컬렉션프레임워크;

public class ㅁ3_Person implements Comparable<ㅁ3_Person>{
	public String name;
	public int age;
	
	public ㅁ3_Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(ㅁ3_Person o) {
		if(age < o.age) return -1;
		else if(age == o.age) return 0;
		else return 1;
	}
}
