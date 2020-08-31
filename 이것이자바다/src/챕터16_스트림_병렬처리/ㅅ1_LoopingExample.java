package 챕터16_스트림_병렬처리;

import java.util.Arrays;

public class ㅅ1_LoopingExample {
	public static void main(String[] args) {
		
		int[] intArray = { 1, 2, 3, 4, 5 };
		
		System.out.println("[ peek()를 마지막에 호출한 경우 ]");
		Arrays.stream(intArray)
			.filter( a -> a % 2 == 0)
			.peek( n -> System.out.println(n) );	// 동작하지 않음
		
		System.out.println();
		
		System.out.println("[ 최종 처리 메소드를 마지막에 호출한 경우 ]");
		int total = Arrays.stream(intArray)
			.filter( a -> a % 2 == 0)
			.peek( n -> System.out.println(n) )		// 동작함
			.sum();									// 최종 메소드
		System.out.println("총합: " + total);		
		
		System.out.println();
		
		System.out.println("[ forEach()를 마지막에 호출한 경우 ]");
		Arrays.stream(intArray)
			.filter( a -> a % 2 == 0)
			.forEach(n -> System.out.println(n) );	// 최종 메소드로 동작함
	}
}
