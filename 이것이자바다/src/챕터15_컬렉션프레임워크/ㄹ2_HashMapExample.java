package é��15_�÷��������ӿ�ũ;

import java.util.HashMap;
import java.util.Map;

public class ��2_HashMapExample {
	public static void main(String[] args) {
		Map<��2_Student, Integer> map = new HashMap<��2_Student, Integer>();
		
		map.put(new ��2_Student(1, "ȫ�浿"), 95);
		map.put(new ��2_Student(1, "ȫ�浿"), 95);
		
		System.out.println("�� Entry ��: " + map.size());
	}
}
