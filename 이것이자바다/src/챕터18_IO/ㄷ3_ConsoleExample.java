package 챕터18_IO;

import java.io.Console;

public class ㄷ3_ConsoleExample {
	public static void main(String[] args) {
		Console console = System.console();
		
		System.out.print("아이디: ");
		String id = console.readLine();
		
		System.out.print("패스워드: ");
		char[] charPass = console.readPassword();
		String strPassword = new String(charPass);	// char[] 배열을 문자열로 생성
		
		System.out.println("────────────");
		System.out.println(id);
		System.out.println(strPassword);
	}
}
