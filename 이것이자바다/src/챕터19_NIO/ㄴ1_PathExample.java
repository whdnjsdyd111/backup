package é��19_NIO;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class ��1_PathExample {
	public static void main(String[] args) {
		Path path = Paths.get("C:\\Users\\PC\\eclipse-workspace\\�̰����ڹٴ�\\src\\é��19_NIO\\��1_PathExample.java");
		System.out.println("[���ϸ�] " + path.getFileName());
		System.out.println("[�θ� ���丮��] " + path.getParent().getFileName());
		System.out.println("��ø ��� ��: " + path.getNameCount());
		
		System.out.println();
		
		for (int i = 0; i < path.getNameCount(); i++) {
			System.out.println(path.getName(i));
		}
		
		System.out.println();
		
		Iterator<Path> iterator = path.iterator();
		while(iterator.hasNext()) {
			Path temp = iterator.next();
			System.out.println(temp.getFileName());
		}
	}
}
