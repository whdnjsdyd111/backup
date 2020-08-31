package √©≈Õ18_IO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class §±10_SerializableReader {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		§±10_ClassA v = (§±10_ClassA) ois.readObject();
		
		System.out.println("field1: " + v.field1);
		System.out.println("field2.field1: " + v.field2.field1);
		System.out.println("field3: " + v.field3);
		System.out.println("field4: " + v.field4);
	}
}
