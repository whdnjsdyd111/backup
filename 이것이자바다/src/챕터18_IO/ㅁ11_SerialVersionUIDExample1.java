package √©≈Õ18_IO;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class §±11_SerialVersionUIDExample1 {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		§±11_ClassC classC = new §±11_ClassC();
		classC.field1 = 1;
		
		oos.writeObject(classC);
		
		oos.flush(); oos.close(); fos.close();
	}
}
