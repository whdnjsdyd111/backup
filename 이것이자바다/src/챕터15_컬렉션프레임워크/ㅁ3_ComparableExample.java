package é��15_�÷��������ӿ�ũ;

import java.util.Iterator;
import java.util.TreeSet;

public class ��3_ComparableExample {
	public static void main(String[] args) {
		TreeSet<��3_Person> treeSet = new TreeSet<��3_Person>();
		
		treeSet.add(new ��3_Person("ȫ�浿", 45));
		treeSet.add(new ��3_Person("���ڹ�", 25));
		treeSet.add(new ��3_Person("������", 31));
		
		Iterator<��3_Person> iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			��3_Person person = iterator.next();
			System.out.println(person.name + ": " + person.age);
		}
	}
}
