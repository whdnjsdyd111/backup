package é��15_�÷��������ӿ�ũ;

import java.util.Arrays;
import java.util.List;

public class ��2_ArrayAsListExample {
	public static void main(String[] args) {
		
		List<String> list1 = Arrays.asList("ȫ�浿", "�ſ��", "���ڹ�");
		for(String str : list1) {
			System.out.println(str);
		}
		
		List<Integer> list2 = Arrays.asList(1, 2, 3);
		for(int value : list2) {
			System.out.println(value);
		}
	}
}
