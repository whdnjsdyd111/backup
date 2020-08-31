package é��19_NIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ��3_FileExample {
	public static void main(String[] args) throws Exception {
		Path path = Paths.get("C:\\Users\\PC\\eclipse-workspace\\�̰����ڹٴ�\\src\\é��19_NIO\\��3_FileExample.java");
		System.out.println("���丮 ����: " + Files.isDirectory(path));
		System.out.println("���� ����: " + Files.isRegularFile(path));
		System.out.println("������ ���� �ð�: " + Files.getLastModifiedTime(path));
		System.out.println("���� ũ��: " + Files.size(path));
		System.out.println("������: " + Files.getOwner(path).getName());
		System.out.println("���� ���� ����: " + Files.isHidden(path));
		System.out.println("�б� ���� ����: " + Files.isReadable(path));
		System.out.println("���� ���� ����: " + Files.isWritable(path));
	}
}
