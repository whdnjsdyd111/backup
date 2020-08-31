package 챕터19_NIO;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

public class ㄷ2_PerformanceExample {
	public static void main(String[] args) throws Exception {
		Path from = Paths.get("C:\\Users\\PC\\eclipse-workspace\\이것이자바다\\src\\챕터19_NIO\\forest.jpg");
		Path to1 = Paths.get("C:\\Users\\PC\\eclipse-workspace\\이것이자바다\\src\\챕터19_NIO\\forest1.jpg");
		Path to2 = Paths.get("C:\\Users\\PC\\eclipse-workspace\\이것이자바다\\src\\챕터19_NIO\\forest2.jpg");
		
		long size = Files.size(from);
		
		long start, end;
		
		FileChannel fileChannel_from = FileChannel.open(from);
		FileChannel fileChannel_to1 = FileChannel.open(to1,
				EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE));
		FileChannel fileChannel_to2 = FileChannel.open(to2,
				EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE));
		
		// 넌다이렉트 버퍼와 다이렉트 버퍼 생성
		start = System.nanoTime();
		ByteBuffer nonDirectBuffer = ByteBuffer.allocate((int) size);
		end = System.nanoTime();
		
		System.out.println("넌다이렉트 버퍼 생성 시간:\t" + (end - start) + " ns");
		
		start = System.nanoTime();
		ByteBuffer directBuffer = ByteBuffer.allocateDirect((int) size);
		end = System.nanoTime();
		
		System.out.println("다이렉트 버퍼 생성 시간:\t\t" + (end - start) + " ns");
		//
		
		System.out.println();
		
		// 넌다이렉트 버퍼 테스트
		start = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			fileChannel_from.read(nonDirectBuffer);
			nonDirectBuffer.flip();
			fileChannel_to1.write(nonDirectBuffer);
			nonDirectBuffer.clear();
		}
		end = System.nanoTime();
		
		System.out.println("넌다이렉트:\t" + (end - start) + " ns");
		//
		
		fileChannel_from.position(0);	// 파일의 위치를 0으로 설정(처음으로 돌림)
		
		// 넌다이렉트 버퍼 테스트
		start = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			fileChannel_from.read(directBuffer);
			directBuffer.flip();
			fileChannel_to2.write(directBuffer);
			directBuffer.clear();
		}
		end = System.nanoTime();
				
		System.out.println("다이렉트:\t" + (end - start) + " ns");
		//
		
		fileChannel_from.close();
		fileChannel_to1.close();
		fileChannel_to2.close();
	}
}
