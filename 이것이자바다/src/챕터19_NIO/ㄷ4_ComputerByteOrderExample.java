package é��19_NIO;

import java.nio.ByteOrder;

public class ��4_ComputerByteOrderExample {
	public static void main(String[] args) {
		System.out.println("�ü�� ����: " + System.getProperty("os.name"));
		System.out.println("����Ƽ���� ����Ʈ �ؼ� ����: " + ByteOrder.nativeOrder());
	}
}
