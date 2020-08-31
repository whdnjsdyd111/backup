package 챕터18_IO;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ㅁ04_BufferedReaderExample {
	public static void main(String[] args) throws Exception {
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);		// 버퍼 스트림 생성
		
		System.out.print("입력: ");
		String lineString = br.readLine();
		
		System.out.print("출력: " + lineString);
	}
}
