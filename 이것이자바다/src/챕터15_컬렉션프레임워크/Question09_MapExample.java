package 챕터15_컬렉션프레임워크;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Question09_MapExample {
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name = null;		// 최고 점수를 받은 아이디 저장
		int maxScore = 0;		// 최고 점수 저장
		int totalScore = 0;		// 점수 합계 저장
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
		
		while(iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			totalScore += entry.getValue();
			if(maxScore <= entry.getValue()) {
				maxScore = entry.getValue();
				name = entry.getKey();
			}
		}
		
		System.out.println("평균점수: " + ((double) totalScore / map.size()));
		System.out.println("최고점수: " + maxScore);
		System.out.println("최고점수를 받은 아이디: " + name);
	}
}
