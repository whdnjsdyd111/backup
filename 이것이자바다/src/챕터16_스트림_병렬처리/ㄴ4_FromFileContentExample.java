package é��16_��Ʈ��_����ó��;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ��4_FromFileContentExample {
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("C:\\aaa.txt");		// ������ ��� ������ ������ �ִ� Path ��ü ����
		Stream<String> stream;
		
		// Files.lines() �޼ҵ� �̿�
		stream = Files.lines(path, Charset.defaultCharset());		// �ü���� �⺻ ���ڼ�
		stream.forEach( System.out :: println );					// s -> System.out.println(s)�� ����
		
		System.out.println();
		
		// BufferedReader�� lines() �޼ҵ� �̿�
		File file = path.toFile();							// 18 �忡�� ���
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		stream = br.lines();
		stream.forEach( System.out :: println );
	}
}
