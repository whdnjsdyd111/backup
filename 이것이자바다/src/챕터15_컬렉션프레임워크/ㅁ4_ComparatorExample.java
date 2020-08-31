package é��15_�÷��������ӿ�ũ;

import java.util.Iterator;
import java.util.TreeSet;

public class ��4_ComparatorExample {
	public static void main(String[] args) {
		/*
		TreeSet<Fruit> treeSet = new TreeSet<Fruit>();
		
		// Fruit�� Comparable�� �������� �ʾұ� ������ ���� �߻�
		
		treeSet.add(new Fruit("����", 3000));
		treeSet.add(new Fruit("����", 10000));
		treeSet.add(new Fruit("����", 6000));
		*/
		
		TreeSet<��4_Fruit> treeSet = new TreeSet<��4_Fruit>(new ��4_DescendingComparator());	// �������� ������ ����
		
		treeSet.add(new ��4_Fruit("����", 3000));
		treeSet.add(new ��4_Fruit("����", 10000));
		treeSet.add(new ��4_Fruit("����", 6000));
		
		Iterator<��4_Fruit> iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			��4_Fruit fruit = iterator.next();
			System.out.println(fruit.name + " - " + fruit.price);
		}
	}
}
