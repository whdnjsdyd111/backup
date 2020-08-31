package 챕터15_컬렉션프레임워크;

import java.util.Iterator;
import java.util.TreeSet;

public class ㅁ4_ComparatorExample {
	public static void main(String[] args) {
		/*
		TreeSet<Fruit> treeSet = new TreeSet<Fruit>();
		
		// Fruit이 Comparable을 구현하지 않았기 때문에 예외 발생
		
		treeSet.add(new Fruit("포도", 3000));
		treeSet.add(new Fruit("수박", 10000));
		treeSet.add(new Fruit("딸기", 6000));
		*/
		
		TreeSet<ㅁ4_Fruit> treeSet = new TreeSet<ㅁ4_Fruit>(new ㅁ4_DescendingComparator());	// 내림차순 정렬자 제공
		
		treeSet.add(new ㅁ4_Fruit("포도", 3000));
		treeSet.add(new ㅁ4_Fruit("수박", 10000));
		treeSet.add(new ㅁ4_Fruit("딸기", 6000));
		
		Iterator<ㅁ4_Fruit> iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			ㅁ4_Fruit fruit = iterator.next();
			System.out.println(fruit.name + " - " + fruit.price);
		}
	}
}
