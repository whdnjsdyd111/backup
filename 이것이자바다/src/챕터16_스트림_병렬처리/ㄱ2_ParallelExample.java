package 챕터16_스트림_병렬처리;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ㄱ2_ParallelExample {
	public static void main(String[] args) {
		
		
		List<String> list = Arrays.asList(
			"홍길동", "신용권", "김자바",
			"람다식", "박병렬"
		);
		
		// 순차 처리
		Stream<String> stream = list.stream();
		stream.forEach(ㄱ2_ParallelExample :: print);
		
		System.out.println();
		
		// 병렬 처리
		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(ㄱ2_ParallelExample :: print);
	}
	
	public static void print(String str) {
		System.out.println(str + " : " + Thread.currentThread().getName());
	}
}
