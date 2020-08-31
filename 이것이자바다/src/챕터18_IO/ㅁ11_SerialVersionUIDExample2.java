package √©≈Õ18_IO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class §±11_SerialVersionUIDExample2 {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		§±11_ClassC classC = (§±11_ClassC) ois.readObject();
		
		System.out.println("field1: " + classC.field1);
	}
}
