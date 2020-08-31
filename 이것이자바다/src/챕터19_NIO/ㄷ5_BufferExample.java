package 챕터19_NIO;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class ㄷ5_BufferExample {
	public static void main(String[] args) {
		System.out.println("[7바이트 크기로 버퍼 생성]");
		ByteBuffer buffer = ByteBuffer.allocateDirect(7);
		printState(buffer);
		
		buffer.put((byte) 10);		// 상대적 저장
		buffer.put((byte) 11);
		System.out.println("[2바이트 저장 후]");
		printState(buffer);
		
		buffer.put((byte) 12);
		buffer.put((byte) 13);
		buffer.put((byte) 14);		// 상대적 저장
		System.out.println("[3바이트 저장 후]");
		printState(buffer);
		
		buffer.flip();		// 데이터를 읽기 위해 위치 속성값 변경
		System.out.println("[flip() 실행 후]");
		printState(buffer);
		
		buffer.get(new byte[3]);	// 상대적 읽기
		System.out.println("[3바이트 읽은 후]");
		printState(buffer);
		
		buffer.mark();				// 마크하기
		System.out.println("────────────────────[현재 위치를 마크 해놓음]");
		
		buffer.get(new byte[2]);	// 상대적 읽기
		System.out.println("[2바이트 읽은 후]");
		printState(buffer);
		
		buffer.reset();				// 마크 위치로 position 이동
		System.out.println("────────────────────[position을 마크 위치로 옮김]");
		printState(buffer);
		
		buffer.rewind();		// position을 0으로 이동
		System.out.println("[rewind() 실행 후");
		printState(buffer);
		
		buffer.clear();		// 모든 위치 속성값을 초기화
		System.out.println("[clear() 실행 후]");
		printState(buffer);
	}
	
	public static void printState(Buffer buffer) {
		System.out.print("\tposition: " + buffer.position());
		System.out.print("\tlimit: " + buffer.limit());
		System.out.println("\tcapacity: " + buffer.capacity());
	}
}
