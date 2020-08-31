package 矇攪13_薯啻葛;

public class 中2_BoxExample {
	public static void main(String[] args) {
		中2_Box<String> box1 = new 中2_Box<String>();
		box1.set("hello");
		String str = box1.get();
		
		中2_Box<Integer> box2 = new 中2_Box<Integer>();
		box2.set(6);
		int value = box2.get();
				
	}
}
