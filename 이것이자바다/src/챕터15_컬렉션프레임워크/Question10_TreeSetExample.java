package 챕터15_컬렉션프레임워크;

import java.util.TreeSet;

public class Question10_TreeSetExample {
	public static void main(String[] args) {
		TreeSet<Question10_Student> treeSet = new TreeSet<Question10_Student>();
		
		treeSet.add(new Question10_Student("blue", 96));
		treeSet.add(new Question10_Student("hong", 86));
		treeSet.add(new Question10_Student("white", 92));
		
		Question10_Student student = treeSet.last();
		System.out.println("최고 점수: " + student.score);
		System.out.println("최고 점수를 받은 아이디: " + student.id);
	}
}
