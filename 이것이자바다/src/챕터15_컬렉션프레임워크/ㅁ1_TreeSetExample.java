package 챕터15_컬렉션프레임워크;

import java.util.TreeSet;

public class ㅁ1_TreeSetExample {
	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<Integer>();
		
		scores.add(87);
		scores.add(98);
		scores.add(78);
		scores.add(95);
		scores.add(80);
		
		Integer score = null;
		
		score = scores.first();
		System.out.println("제일 낮은 점수: " + score);
		
		score = scores.last();
		System.out.println("제일 높은 점수: " + score + "\n");
		
		score = scores.lower(95);
		System.out.println("95점 아래 점수: " + score);
		
		score = scores.higher(95);
		System.out.println("95점 위의 점수: " + score + "\n");
		
		score = scores.floor(95);
		System.out.println("95점 이거나 바로 아래 점수: " + score);
		
		score = scores.ceiling(85);
		System.out.println("85점 이거나 바로 위의 점수: " + score + "\n");
		
		while(!scores.isEmpty()) {
			score = scores.pollFirst();
			System.out.println(score + "(남은 객체 수: " + scores.size() + ")");
		}
	}
}
