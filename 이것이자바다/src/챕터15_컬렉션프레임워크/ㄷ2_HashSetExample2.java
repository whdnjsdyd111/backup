package Ã©ÅÍ15_ÄÃ·º¼ÇÇÁ·¹ÀÓ¿öÅ©;

import java.util.HashSet;
import java.util.Set;

public class ¤§2_HashSetExample2 {
	public static void main(String[] args) {
		Set<¤§2_Member> set = new HashSet<¤§2_Member>();
		
		set.add(new ¤§2_Member("È«±æµ¿", 30));
		set.add(new ¤§2_Member("È«±æµ¿", 30));
		
		System.out.println("ÃÑ °´Ã¼ ¼ö: " + set.size());
	}
}
