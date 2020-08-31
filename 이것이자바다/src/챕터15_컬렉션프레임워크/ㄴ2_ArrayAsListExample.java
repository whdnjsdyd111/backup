package 챕터15_컬렉션프레임워크;

import java.util.Arrays;
import java.util.List;

public class ㄴ2_ArrayAsListExample {
	public static void main(String[] args) {
		
		List<String> list1 = Arrays.asList("홍길동", "신용권", "김자바");
		for(String str : list1) {
			System.out.println(str);
		}
		
		List<Integer> list2 = Arrays.asList(1, 2, 3);
		for(int value : list2) {
			System.out.println(value);
		}
	}
}
