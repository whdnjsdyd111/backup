package Ã©ÅÍ13_Á¦³×¸¯;

public class Question03_ContainerExample {
	public static void main(String[] args) {
		Question03_Container<String, String> container1 = new Question03_Container<String, String>();
		container1.set("È«±æµ¿", "µµÀû");
		String name1 = container1.getKey();
		String job = container1.getValue();
		
		Question03_Container<String, Integer> container2 = new Question03_Container<String, Integer>();
		container2.set("È«±æµ¿", 35);
		String name2 = container2.getKey();
		int age = container2.getValue();
	}
}
