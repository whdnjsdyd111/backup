package 챕터16_스트림_병렬처리;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ㅌ3_ArrayListVsLinkedListExample {
	// 요소 처리
	public static void work(int value) {}
	
	// 병렬 처리
	public static long testParellel(List<Integer> list) {
		long start = System.nanoTime();
		list.stream().parallel().forEach( ㅌ3_ArrayListVsLinkedListExample :: work );
		
		long end = System.nanoTime();
		long runTime = end - start;
		
		return runTime;
	}
	
	public static void main(String[] args) {
		//소스 컬렉션
		List<Integer> arrayList = new ArrayList<Integer>();
		List<Integer> linkedList = new LinkedList<Integer>();
		
		for (int i = 0; i < 1000000; i++) {
			arrayList.add(i);
			linkedList.add(i);
		}
		
		// 워밍업
		long arrayListListParallel = testParellel(arrayList);
		long linkedListParallel= testParellel(linkedList);
		
		// 병렬 스트림 처리 시간 구하기
		arrayListListParallel = testParellel(arrayList);
		linkedListParallel = testParellel(linkedList);
		
		if(arrayListListParallel < linkedListParallel) {
			System.out.println("성능 테스트 결과 : ArrayList 처리가 더 빠름");
		} else {
			System.out.println("성능 테스트 결과 : LinkedList 처리가 더 빠름");
		}
	}
}
