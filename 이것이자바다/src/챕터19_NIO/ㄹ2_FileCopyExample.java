package 챕터19_NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ㄹ2_FileCopyExample {
	public static void main(String[] args) throws IOException {
		Path from = Paths.get("C:\\Users\\PC\\eclipse-workspace\\이것이자바다\\src\\챕터19_NIO\\house.jpg");
		Path to = Paths.get("C:\\\\Users\\\\PC\\\\eclipse-workspace\\\\이것이자바다\\\\src\\\\챕터19_NIO\\\\house1.jpg");
		
		FileChannel fileChannel_from = FileChannel.open(from, StandardOpenOption.READ);
		FileChannel fileChannel_to = FileChannel.open(to, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		
		ByteBuffer buffer = ByteBuffer.allocateDirect(100);
		int byteCount;
		
		while(true) {
			buffer.clear();
			byteCount = fileChannel_from.read(buffer);
			if(byteCount == -1) break;
			buffer.flip();
			fileChannel_to.write(buffer);
		}
		
		fileChannel_from.close();
		fileChannel_to.close();
		System.out.println("파일 복사 성공");
	}
}
