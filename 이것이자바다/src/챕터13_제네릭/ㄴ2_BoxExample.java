package é��13_���׸�;

public class ��2_BoxExample {
	public static void main(String[] args) {
		��2_Box<String> box1 = new ��2_Box<String>();
		box1.set("hello");
		String str = box1.get();
		
		��2_Box<Integer> box2 = new ��2_Box<Integer>();
		box2.set(6);
		int value = box2.get();
				
	}
}
