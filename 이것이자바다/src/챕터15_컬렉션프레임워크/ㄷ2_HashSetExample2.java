package é��15_�÷��������ӿ�ũ;

import java.util.HashSet;
import java.util.Set;

public class ��2_HashSetExample2 {
	public static void main(String[] args) {
		Set<��2_Member> set = new HashSet<��2_Member>();
		
		set.add(new ��2_Member("ȫ�浿", 30));
		set.add(new ��2_Member("ȫ�浿", 30));
		
		System.out.println("�� ��ü ��: " + set.size());
	}
}
