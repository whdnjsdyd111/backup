package Ã©ÅÍ13_Á¦³×¸¯;

public class Question04_Util {
	/*
	public static <K, V> V getValue( Question04_Pair<K, V> pair, K k){
		if(pair.getKey() == k) {
			return pair.getValue();
		}
		
		return null;
	}
	*/
	
	public static < P extends Question04_Pair<K, V>, K, V> V getvalue(P p, K k) {
		if(p.getKey() == k) {
			return p.getValue();
		} else {
			return null;
		}
	}
}
