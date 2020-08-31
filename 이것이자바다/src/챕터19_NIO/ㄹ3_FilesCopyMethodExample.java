package é��19_NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ��3_FilesCopyMethodExample {
	public static void main(String[] args) throws IOException {
		Path from = Paths.get("C:\\\\Users\\\\PC\\\\eclipse-workspace\\\\�̰����ڹٴ�\\\\src\\\\é��19_NIO\\\\house1.jpg");
		Path to = Paths.get("C:\\\\Users\\\\PC\\\\eclipse-workspace\\\\�̰����ڹٴ�\\\\src\\\\é��19_NIO\\\\house2.jpg");
		
		Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("���� ���� ����");
	}
}
