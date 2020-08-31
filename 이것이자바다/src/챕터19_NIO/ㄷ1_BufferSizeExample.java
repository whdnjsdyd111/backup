package 챕터19_NIO;

import java.nio.ByteBuffer;

public class ㄷ1_BufferSizeExample {
	public static void main(String[] args) {
		ByteBuffer directBuffer = ByteBuffer.allocateDirect(1500 * 1024 * 1024);
		System.out.println("다이렉트 버퍼가 생성되었습니다.");
		
		ByteBuffer nonDirectBuffer = ByteBuffer.allocate(1345 * 1024 * 1024);
		System.out.println("넌다이렉트 버퍼가 생성되었습니다.");
	}
}
