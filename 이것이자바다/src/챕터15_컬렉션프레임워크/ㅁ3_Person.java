package é��15_�÷��������ӿ�ũ;

public class ��3_Person implements Comparable<��3_Person>{
	public String name;
	public int age;
	
	public ��3_Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(��3_Person o) {
		if(age < o.age) return -1;
		else if(age == o.age) return 0;
		else return 1;
	}
}
