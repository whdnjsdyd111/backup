package Ã©ÅÍ18_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ¤±12_NonSerializableParentExample {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		¤±12_Child child = new ¤±12_Child();
		child.field1 = "È«±æµ¿";
		child.field2 = "È«»ï¿ø";
		oos.writeObject(child);
		
		oos.flush(); oos.close(); fos.close();
		
		FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		¤±12_Child v = (¤±12_Child) ois.readObject();
		System.out.println("field1: " + v.field1);
		System.out.println("field2: " + v.field2);
		
		ois.close(); fis.close();
	}
}
