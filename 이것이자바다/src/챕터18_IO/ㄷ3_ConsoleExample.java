package é��18_IO;

import java.io.Console;

public class ��3_ConsoleExample {
	public static void main(String[] args) {
		Console console = System.console();
		
		System.out.print("���̵�: ");
		String id = console.readLine();
		
		System.out.print("�н�����: ");
		char[] charPass = console.readPassword();
		String strPassword = new String(charPass);	// char[] �迭�� ���ڿ��� ����
		
		System.out.println("������������������������");
		System.out.println(id);
		System.out.println(strPassword);
	}
}
