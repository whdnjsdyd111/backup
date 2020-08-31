package 챕터16_스트림_병렬처리;

import java.util.Arrays;
import java.util.List;

public class ㅌ2_SequencialVsParallelExample {
	
	// 요소 처리
	public static void work(int value) {
		try {
			Thread.sleep( 100 ); // 값이 작을수록 처리가 빠름
		} catch(InterruptedException e) {
			
		}
	}
	
	// 순차 처리
	public static long testSequencial(List<Integer> list) {
		long start = System.nanoTime();
		list.stream().forEach( ㅌ2_SequencialVsParallelExample :: work);
		
		long end = System.nanoTime();
		long runTime = end - start;
		
		return runTime;
	}
	
	public static long testParellel(List<Integer> list) {
		long start = System.nanoTime();
		list.stream().parallel().forEach( ㅌ2_SequencialVsParallelExample :: work);
		
		long end = System.nanoTime();
		long runTime = end - start;
		
		return runTime;
	}
	
	public static void main(String[] args) {
		
		// 소스 컬렉션
		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		// 순차 스트림 처리 시간 구하기
		long timeSequencial = testSequencial(list);
		
		// 병렬 스트림 처리 시간 구하기
		long timeParallel = testParellel(list);
		
		if(timeSequencial < timeParallel) {
			System.out.println("성능 테스트 결과: 순차 처리가 더 빠름");
		} else {
			System.out.println("성능 테스트 결과: 병렬 처리가 더 빠름");
		}
	}
}
