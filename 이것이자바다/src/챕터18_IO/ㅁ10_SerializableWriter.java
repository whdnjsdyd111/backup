package √©≈Õ18_IO;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class §±10_SerializableWriter {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		§±10_ClassA classA = new §±10_ClassA();
		classA.field1 = 1;
		classA.field2.field1 = 2;
		classA.field4 = 3;
		classA.field4 = 4;
		
		oos.writeObject(classA);
		
		oos.flush(); oos.close(); fos.close();
	}
}
