package Ã©ÅÍ13_Á¦³×¸¯;

public class ¤©2_Util {
	public static <K, V> boolean compare(¤©2_Pair<K, V> p1, ¤©2_Pair<K, V> p2) {
	
		boolean KeyCompare = p1.getKey().equals(p2.getKey());
		boolean ValueCompare = p2.getValue().equals(p2.getValue());
		return (KeyCompare && ValueCompare);
	}
}
