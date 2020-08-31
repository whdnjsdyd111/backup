package 챕터15_컬렉션프레임워크;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ㄹ1_HashMapExample {
	public static void main(String[] args) {
		
		// Map 컬렉션 생성
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// 객체 저장
		map.put("신용권", 85);
		map.put("홍길동", 90);	// 같음
		map.put("동장군", 80);
		map.put("홍길동", 95);	// 키가 같으므로 제일 마지막에 저장한 값으로 대치
		System.out.println("총 Entry 수: " + map.size());
		
		// 객체 찾기
		System.out.println("\t홍길동 : " + map.get("홍길동"));	// 이름(키)으로 점수(값)를 검색
		System.out.println();
		
		// 객체를 하나씩 처리
		Set<String> keySet = map.keySet();					// Key Set 얻기
		Iterator<String> keyIterator = keySet.iterator();
		
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();
		
		// 객체 삭제
		map.remove("홍길동");
		System.out.println("총 Entry 수: " + map.size());
		
		// 객체를 하나씩 처리
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();		// Map.Entry Set 얻기
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();
		
		// 객체 전체 삭제
		map.clear();
		System.out.println("총 Entry 수: " + map.size());
		
	}
}
