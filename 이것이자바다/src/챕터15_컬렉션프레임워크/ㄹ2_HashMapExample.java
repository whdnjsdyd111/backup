package 챕터15_컬렉션프레임워크;

import java.util.HashMap;
import java.util.Map;

public class ㄹ2_HashMapExample {
	public static void main(String[] args) {
		Map<ㄹ2_Student, Integer> map = new HashMap<ㄹ2_Student, Integer>();
		
		map.put(new ㄹ2_Student(1, "홍길동"), 95);
		map.put(new ㄹ2_Student(1, "홍길동"), 95);
		
		System.out.println("총 Entry 수: " + map.size());
	}
}
