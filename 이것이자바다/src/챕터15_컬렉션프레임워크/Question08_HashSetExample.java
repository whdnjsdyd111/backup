package é��15_�÷��������ӿ�ũ;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Question08_HashSetExample {
	public static void main(String[] args) {
		
		Set<Question08_Student> set = new HashSet<Question08_Student>();
		
		set.add(new Question08_Student(1, "ȫ�浿"));
		set.add(new Question08_Student(2, "�ſ��"));
		set.add(new Question08_Student(1, "���ο�"));
		
		Iterator<Question08_Student> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Question08_Student student = iterator.next();
			System.out.println(student.studentNum + " : " + student.name);
		}
	}
}
