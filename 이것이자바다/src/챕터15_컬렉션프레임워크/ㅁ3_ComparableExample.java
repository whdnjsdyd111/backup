package 챕터15_컬렉션프레임워크;

import java.util.Iterator;
import java.util.TreeSet;

public class ㅁ3_ComparableExample {
	public static void main(String[] args) {
		TreeSet<ㅁ3_Person> treeSet = new TreeSet<ㅁ3_Person>();
		
		treeSet.add(new ㅁ3_Person("홍길동", 45));
		treeSet.add(new ㅁ3_Person("김자바", 25));
		treeSet.add(new ㅁ3_Person("박지원", 31));
		
		Iterator<ㅁ3_Person> iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			ㅁ3_Person person = iterator.next();
			System.out.println(person.name + ": " + person.age);
		}
	}
}
