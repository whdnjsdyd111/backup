package é��15_�÷��������ӿ�ũ;

import java.util.TreeSet;

public class Question10_TreeSetExample {
	public static void main(String[] args) {
		TreeSet<Question10_Student> treeSet = new TreeSet<Question10_Student>();
		
		treeSet.add(new Question10_Student("blue", 96));
		treeSet.add(new Question10_Student("hong", 86));
		treeSet.add(new Question10_Student("white", 92));
		
		Question10_Student student = treeSet.last();
		System.out.println("�ְ� ����: " + student.score);
		System.out.println("�ְ� ������ ���� ���̵�: " + student.id);
	}
}
