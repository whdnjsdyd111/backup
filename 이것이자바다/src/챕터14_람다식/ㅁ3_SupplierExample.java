package Ã©ÅÍ14_¶÷´Ù½Ä;

import java.util.function.IntSupplier;

public class ¤±3_SupplierExample {
	public static void main(String[] args) {
		IntSupplier intSupplier = () -> {
			int num = (int) (Math.random() * 6) + 1;
			return num;
		};
		
		int num = intSupplier.getAsInt();
		System.out.println("´«ÀÇ ¼ö: " + num);
	}
}
