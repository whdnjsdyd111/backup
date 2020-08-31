package 챕터15_컬렉션프레임워크;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Question08_HashSetExample {
	public static void main(String[] args) {
		
		Set<Question08_Student> set = new HashSet<Question08_Student>();
		
		set.add(new Question08_Student(1, "홍길동"));
		set.add(new Question08_Student(2, "신용권"));
		set.add(new Question08_Student(1, "조민우"));
		
		Iterator<Question08_Student> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Question08_Student student = iterator.next();
			System.out.println(student.studentNum + " : " + student.name);
		}
	}
}
