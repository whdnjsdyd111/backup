package Ã©ÅÍ19_NIO;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ¤©1_FileChannelWriteExample {
	public static void main(String[] args) throws Exception {
		Path path = Paths.get("C:/Temp/file.txt");
		Files.createDirectories(path.getParent());
		
		FileChannel fileChannel = FileChannel.open(path, 
				StandardOpenOption.CREATE, StandardOpenOption.WRITE);	// FileChannel »ý¼º
		
		String data = "¾È³çÇÏ¼¼¿ä";
		Charset charset = Charset.defaultCharset();
		ByteBuffer byteBuffer = charset.encode(data);
		
		int byteCount = fileChannel.write(byteBuffer);
		System.out.println("file.txt: " + byteCount + " byte written");
		
		fileChannel.close();
	}
}
