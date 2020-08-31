package 챕터19_NIO;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class ㄴ1_PathExample {
	public static void main(String[] args) {
		Path path = Paths.get("C:\\Users\\PC\\eclipse-workspace\\이것이자바다\\src\\챕터19_NIO\\ㄴ1_PathExample.java");
		System.out.println("[파일명] " + path.getFileName());
		System.out.println("[부모 디렉토리명] " + path.getParent().getFileName());
		System.out.println("중첩 경로 수: " + path.getNameCount());
		
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
