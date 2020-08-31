package 챕터15_컬렉션프레임워크;

import java.util.NavigableSet;
import java.util.TreeSet;

public class ㅁ1_TreeSetExample2 {
	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<Integer>();
		
		scores.add(87);
		scores.add(98);
		scores.add(78);
		scores.add(95);
		scores.add(80);
		
		NavigableSet<Integer> descendingSet = scores.descendingSet();
		for(Integer score : descendingSet) {
			System.out.print(score + " ");
		}
		System.out.println();
		
		NavigableSet<Integer> ascendingSet = descendingSet.descendingSet();
		for(Integer score : ascendingSet) {
			System.out.print(score + " ");
		}
	}
}
