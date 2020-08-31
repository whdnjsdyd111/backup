package Ã©ÅÍ14_¶÷´Ù½Ä;

import java.util.function.BinaryOperator;

public class ¤±90_OperatorMinByMaxByExample {
	public static void main(String[] args) {
		BinaryOperator<¤±90_Fruit> binaryOperator;
		¤±90_Fruit fruit;
		
		binaryOperator = BinaryOperator.minBy( (f1, f2)->Integer.compare(f1.price, f2.price));
		fruit = binaryOperator.apply(new ¤±90_Fruit("µþ±â", 6000), new ¤±90_Fruit("¼ö¹Ú", 10000));
		System.out.println(fruit.name);
		
		binaryOperator = BinaryOperator.maxBy( (f1, f2)->Integer.compare(f1.price, f2.price) );
		fruit = binaryOperator.apply(new ¤±90_Fruit("µþ±â", 6000), new ¤±90_Fruit("¼ö¹Ú", 10000));
		System.out.println(fruit.name);
	}
}
