package 챕터15_컬렉션프레임워크;

import java.util.NavigableSet;
import java.util.TreeSet;

public class ㅁ1_TreeSetExample3 {
	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>();
		
		treeSet.add("apple");
		treeSet.add("forever");
		treeSet.add("description");
		treeSet.add("ever");
		treeSet.add("zoo");
		treeSet.add("base");
		treeSet.add("guess");
		treeSet.add("cherry");
		
		System.out.println("[ c ~ f 사이의 단어 검색 ]");
		
		NavigableSet<String> rangeSet = treeSet.subSet("c", true, "f", true);	// "c" <= 검색 단어 <= "f"
		for(String word : rangeSet) {
			System.out.println(word);
		}
	}
}
