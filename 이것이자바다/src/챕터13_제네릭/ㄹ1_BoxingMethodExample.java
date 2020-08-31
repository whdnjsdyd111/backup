package Ã©ÅÍ13_Á¦³×¸¯;

public class ¤©1_BoxingMethodExample {
	public static void main(String[] args) {
		¤¤2_Box<Integer> box1 = ¤©1_Util.<Integer>boxing(100);
		int intValue = box1.get();
		
		¤¤2_Box<String> box2 = ¤©1_Util.boxing("È«±æµ¿");
		int strValue = box1.get();
	}
}
