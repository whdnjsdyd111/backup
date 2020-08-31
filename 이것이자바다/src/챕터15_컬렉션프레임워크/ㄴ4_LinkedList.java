package é��15_�÷��������ӿ�ũ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ��4_LinkedList {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			set.add(String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("Set �ɸ� �ð�: \t\t" + (endTime - startTime) + " ns");
		
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList �ɸ� �ð�: \t" + (endTime - startTime) + " ns");
		
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList �ɸ� �ð�: \t" + (endTime - startTime) + " ns");
		
		System.out.println();
		
		Iterator<String> iterator = set.iterator();
		startTime = System.nanoTime();
		while(iterator.hasNext()) {
			String j = iterator.next();
		}
		endTime = System.nanoTime();
		System.out.println("Set �ɸ� �ð�: \t\t" + (endTime - startTime) + " ns");
		
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			String j = list1.get(i);
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList �ɸ� �ð�: \t" + (endTime - startTime) + " ns");
		
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			String j = list1.get(i);
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList �ɸ� �ð�: \t" + (endTime - startTime) + " ns");
	}
}
