package 챕터16_스트림_병렬처리;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ㄴ5_FromDirectoryExample {
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("C:/");
		Stream<Path> stream = Files.list(path);
		stream.forEach( p -> System.out.println(p.getFileName()));
		
	}
}
