package é��19_NIO;

import java.nio.ByteBuffer;

public class ��1_BufferSizeExample {
	public static void main(String[] args) {
		ByteBuffer directBuffer = ByteBuffer.allocateDirect(1500 * 1024 * 1024);
		System.out.println("���̷�Ʈ ���۰� �����Ǿ����ϴ�.");
		
		ByteBuffer nonDirectBuffer = ByteBuffer.allocate(1345 * 1024 * 1024);
		System.out.println("�ʹ��̷�Ʈ ���۰� �����Ǿ����ϴ�.");
	}
}
