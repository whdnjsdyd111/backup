package é��18_IO;

public class ��_File_InOutput {
			//	File Class
	
	// IO ��Ű�� (java.io)���� �����ϴ� File Ŭ������ ���� ũ��, ���� �Ӽ�, ���� �̸� ���� ������ ���� ��ɰ� ���� ���� �� ���� ����� �����ϰ� �ִ�.
	// �׸��� ���丮�� �����ϰ� ���丮�� �����ϴ� ���� ����Ʈ�� ���� ��ɵ� �ִ�. �׷��� ������ �����͸� �а� ���� ����� �������� �ʴ´�.
	// ������ ������� ��Ʈ���� ����ؾ� �Ѵ�. ������ C:\Temp ���丮�� file.txt ������ File ��ü�� �����ϴ� �ڵ��̴�.
	
	//	File file = new File("C:\\Temp\\file.txt");
	//	File file = new File("C:/Temp/file.txt");
	
	// ���丮 �����ڴ� �ü������ ���ݾ� �ٸ���. �����쿡���� \ �Ǵ� /�� ����� �� �ְ�, ���н��� ������������ \�� ����Ѵ�.
	// File.separator ����� ����غ��� �ش� �ü������ ����ϴ� ���丮 �����ڸ� Ȯ���� �� �ִ�. ���� \�� ���丮 �����ڷ� ����Ѵٸ� �̽������� ����(\\)�� ����ؾ� �Ѵ�.
	
	// File ��ü�� �����ߴٰ� �ؼ� �����̳� ���丮�� �����Ǵ� ���� �ƴϴ�. ������ �Ű������� �־��� ��ΰ� ��ȿ���� �ʴ��� ������ ������ ���ܰ� �߻����� �ʴ´�.
	// File ��ü�� ���� �ش� ��ο� ������ �����̳� ���丮�� �ִ��� Ȯ���Ϸ��� exists() �޼ҵ带 ȣ���� �� �ִ�. 
	// ���丮 �Ǵ� ������ ���� �ý��ۿ� �����Ѵٸ�  true�� �����ϰ� �������� �ʴ´ٸ� false�� �����Ѵ�.
	
	//	boolean isExist = file.exists();
	
	// exists() �޼ҵ��� ���ϰ��� false��� createNewFile(), mkdir(), mkdirs() �޼ҵ�� ���� �Ǵ� ���丮�� ������ �� �ִ�.
	
	//	���� Ÿ��		�޼ҵ�				����
	//
	//	boolean		createNewFile()		���ο� ������ ����
	//	boolean		mkdir()				���ο� ���丮�� ����
	//	boolean		mkdirs()				��λ� ���� ��� ���丮�� ����
	//	boolean		delete()			���� �Ǵ� ���丮�� ����
	
	// ���� �Ǵ� ���丮�� ������ ��쿡�� ���� �޼ҵ带 ���� ������ �� �� �ִ�.
	
	//	���� Ÿ��		�޼ҵ� 							����
	//	
	//	boolean		canExecute()					������ �� �ִ� �������� ����
	//	boolean		canRead()						���� �� �ִ� �������� ����
	//	boolean		canWrite()						���� �� ������ �� �ִ� �������� ����
	//	String		getName()						������ �̸��� ����
	//	String		getParent()						�θ� ���丮�� ����
	//	File		getParentFile()					�θ� ���丮�� File ��ü�� ���� �� ����
	//	String		getPath()						��ü ��θ� ����
	//	boolean		isDirectory()					���丮���� ����
	//	boolean		isFile()						�������� ����
	//	boolean		isHidden()						���� �������� ����
	//	long		lastModified()					������ ���� ��¥ �� �ð��� ����
	//	long		length()						������ ũ�⸦ ����
	//	String[]	list()							���丮�� ���Ե� ���� �� ������丮 ��� ���θ� String �迭�� ����
	//	String[]	list(FilenameFilter filter)		���丮�� ���Ե� ���� �� ������丮 ��� �߿� FilenameFilter�� �´� �͸� String �迭�� ����
	//	File[]		listFiles()						���丮�� ���Ե� ���� �� ���� ���丮 ��� ���θ� File �迭�� ����
	//	File[]		listFiles(FilenameFilter filter)���丮�� ���Ե� ���� �� ���� ���丮 ��� �߿� FilenameFilter�� �´� �͸� File �迭�� ����
	
	// ������ C:\ ���丮�� Dir ���丮�� file1.txt, file2.txt, file3.txt ������ �����ϰ�, Temp ���丮�� �ִ� ���� ����� ����ϴ� �����̴�.
	
			//	FileInputStream
	
	// FileInputStream Ŭ������ ���Ϸκ��� ����Ʈ ������ �о���� �� ����ϴ� ����Ʈ ��� �Է� ��Ʈ���̴�. ����Ʈ ������ �б� ������ �׸�, �����, ����, ����Ʈ ���� �� ��� ������ ������ ���� �� �ִ�.
	// ������ FileInputStream�� �����ϴ� �� ���� ����� �����ش�.
	
	//	// ù ��° ���
	//	FileInputStream fis = new FileInputStream("C:/Temp/image.gif");
	//
	//	// �� ��° ���
	//	File file = new File("C:/Temp/image.gif");
	//	FileInputStream fis = new FileInputStream(file);
	
	// ù ��° ����� ���ڿ��ε� ������ ��θ� ������ FileInputStream�� �����Ѵ�. ���� �о�� �� ������ File ��ü�� �̹� �����Ǿ� �ִٸ� �� ��° ������� �� �� ���� FileInputStream�� ������ �� �ִ�.
	// FileInputStream ��ü�� ������ �� ���ϰ� ���� ������ �Ǵµ�, ���� ������ �������� ������ FileNotFoundException�� �߻���Ű�Ƿ� try-catch������ ���� ó���� �ؾ� �Ѵ�.
	// FileInputStream�� InputStream�� ���� Ŭ�����̱� ������ ��� ����� InputStream�� �����ϴ�.
	// �� ����Ʈ�� �б� ���ؼ� read() �޼ҵ带 ����ϰų�, ���� ����Ʈ�� byte �迭�� �����ϱ� ���ؼ� read(byte[] b) �Ǵ� read(byte[] b, int off, int len) �޼ҵ带 ����Ѵ�.
	// ��ü ������ ������ �б� ���ؼ��� �� �޼ҵ��� �ݺ� �����ؼ� -1�� ���� ������ ������ �ȴ�. ������ ������ ��� ���� �Ŀ��� close() �޼ҵ带 ȣ���ؼ� ������ �ݾ��ش�.
	
	//	FileInputStream fis = new FileInputStream("C:/Temp/image.gif");
	//	int readByteNo;
	//	byte[] readBytes = new byte[100];
	//	while( (readByteNo = fis.read(readBytes) ) != -1 ) {	
	//		// ���� ����Ʈ �迭(readBytes)�� ó��
	//	}
	//	fis.close();
	
	// ������ FileInputStreamExample.java �ҽ� ������ �а� �ֿܼ� �����ִ� �����̴�.
	
			//	FileOutputStream
	
	// FileOutputStream�� ����Ʈ ������ �����͸� ���Ͽ� ������ �� ����ϴ� ����Ʈ ��� ��� ��Ʈ���̴�. ����Ʈ ������ �����ϱ� ������ �׸�, �����, ����, �ؽ�Ʈ �� ��� ������ �����͸� ���Ϸ� ������ �� �ִ�.
	// ������ FileOutputStream�� �����ϴ� �� ���� ����� �����ش�. ù ��° ����� ������ ��θ� ������ FileOutputStream�� ����������, ������ ������ File ��ü�� �̹� �����Ǿ� �ִٸ�
	// �� ��° ������� �� �� ���� FileOutputStream�� ������ �� �ִ�.
	
	//	// ��� 1
	//	FileOutputStream fos = new FileOutputStream("C:/Temp/image.gif");
	//
	//	// ��� 2
	//	File file = new File("C:/Temp/image.gif");
	//	FileOutputStream fos = new FileOutputStream(file);
	
	// ������ ���� ������ �̹� ������ ���, �����͸� ����ϸ� ������ ����� �ǹǷ�, ������ ���� ������ ������� �ȴ�. 
	// ������ ���� ���� ���� �����͸� �߰��� ��쿡�� FileOutputStream �������� �� ��° �Ű����� true�� �ָ� �ȴ�.
	
	//	FileOutputStream fos = new FileOutputStream("C:/Temp/data.txt", true);
	//	FileOutputStream fos = new FileOutputStream(file, true);
	
	// FileOutputStream�� OutputStream�� ���� Ŭ�����̱� ������ ��� ����� OutputStream�� �����ϴ�.
	// �� ����Ʈ�� �����ϱ� ���ؼ� write() �޼ҵ带 ����ϰ� ����Ʈ �迭�� �Ѳ����� �����ϱ� ���ؼ� write(byte[] b) �Ǵ� write(byte[] b, int off, int len) �޼ҵ带 ����Ѵ�.
	
	//	FileOutputStream fos = new FileOutputStream("C:/Temp/images.gif");
	//	byte[] data = ...;
	//	fos.write(data);
	//	fos.flush();
	//	fos.close();
	
	// write() �޼ҵ带 ȣ���� ���Ŀ� flush() �޼ҵ�� ��� ���ۿ� �ܷ��ϴ� �����͸� ������ ����ϵ��� �ϰ�, close() �޼ҵ带 ȣ���ؼ� ������ �ݾ��ش�.
	// ������ ���� ������ Ÿ�� ���Ϸ� �����ϴ� �����̴�. ���� ���α׷��� ������ ���� ���Ͽ��� ���� ����Ʈ�� �ٷ� Ÿ�� ���Ϸ� �����ϴ� ���̱� ������ 
	// FileInputStream���� ���� ����Ʈ�� �ٷ� FileOutputStream���� �����ϸ� �ȴ�.
	
	// 15������ readByteNo�� ������ ���� ����Ʈ ���� ����� �����̰�, 16������ ������ ���� ����Ʈ�� ����Ǵ� �迭�̴�. 17������ FileInputStream�� read(byte[] b) �޼ҵ�� �� ���� 100 ����Ʈ�� �о�
	// readBytes�� �����ϰ� 100�� readByteNo�� �����Ѵ�. �׸��� readByteNo�� -1�� �ƴ��� �˻��Ѵ�. �̷��� ����ؼ� ������ ���ٰ� ������ ���� �ÿ��� 100������ ���� ����Ʈ�� �о�
	// raedBytes�� �����ϰ� ����Ʋ ���� readByteNo�� �����Ѵ�. ���� ��� ������ ����� 520 ����Ʈ��� while���� 6�� �����ϴµ� ������ ���� �ÿ��� 20����Ʈ�� �о� 
	// FileOutputStream�� write(byte[] b, int off, int len) �޼ҵ�� �����Ѵ�. b�� readBytes�� �ǰ�, off�� 0, len�� readByteNo�� �ȴ�.
	
			//	FileReader
	
	// FileReader Ŭ������ �ؽ�Ʈ ������ ���α׷����� �о���� �� ����ϴ� ���� ��� ��Ʈ���̴�. ���� ������ �б� ������ �ؽ�Ʈ�� �ƴ� �׸�, �����, ���� ���� ������ ���� �� ����.
	// ������ FileReader�� �����ϴ� �� ���� ����� �����ش�. ù ��° ����� ��ü ������ ��θ� ������ FileReader�� ����������, 
	// �о�� �� ������ File ��ü�� �̹� �����Ǿ� �ִٸ� �� ��° ������� �� �� ���� FileReader�� ������ �� �ִ�.
	
	//	// ���1
	//	FileReader fr = new FileReader("C:/Temp/file.txt");
	//
	//	// ���2
	//	File file = new File("C:/Temp/file.txt");
	//	FileReader fr = new FileReader(file);
	
	// FileReader ��ü�� ������ �� ���ϰ� ���� ������ �Ǵµ�, ���� ������ �������� ������ FileNotFoundException�� �߻���Ű�Ƿ� try-catch������ ���� ó���� �ؾ� �Ѵ�.
	// FileReader�� Reader�� ���� Ŭ�����̱� ������ ��� ����� Reader�� �����ϴ�. �� ���ڸ� �б� ���ؼ� read() �޼ҵ带 ����ϰų�, ���� ���ڸ� char �迭�� �����ϱ� ���ؼ� read(char[] cbuf) �Ǵ�
	// read(char[] cbuf, int off, int len) �޼ҵ带 ����Ѵ�. ��ü ������ ������ �б� ���ؼ��� �� �޼ҵ���� �ݺ� �����ؼ� -1�� ���� ������ ������ �ȴ�.
	
	//	FileReader fr = new FileReader("C:/Temp/file.txt");
	//	int readCharNo;
	//	char[] cbuf = new char[100];
	//	while( (readCharNo = fr.read(cbuf)) != -1) {
	//		// ���� ���� �迭(cbuf)�� ó��
	//	}
	//	fr.close();
	
	// ������ ������ ��� ���� �Ŀ��� close() �޼ҵ带 ȣ���ؼ� ������ �ݾ��ش�. ������ FileReaderExample.java �ҽ� ������ �а� �ֿܼ� ����ϴ� �����̴�.
	
	// 13���ο��� cbuf �迭�� ����Ǿ� �ִ� ���ڵ��� �����ؼ� ���ڿ�(String ��ü)�� �����Ͽ���.
	// String �������� ù ��° �Ű������� cbuf��, �� ��° �Ű����� 0 �ε�����, �� ��° �Ű����� ���� ���� ���� �����ߴ�.
	
			//	FileWriter
	
	// FileWriter�� �ؽ�Ʈ �����͸� ���Ͽ� ������ �� ����ϴ� ���� ��� ��Ʈ���̴�. ���� ������ �����ϱ� ������ �ؽ�Ʈ�� �ƴ� �׸�, �����, ���� ���� �����͸� ���Ϸ� ������ �� ����.
	// ������ FileWriter�� �����ϴ� �� ���� ����� �����ش�. ù ��° ����� ��ü ������ ��θ� ������ FileWriter�� ����������, 
	// ������ ������ File ��ü�� �̹� �����Ǿ� �ִٸ� �� ��° ������� �� �� ���� FileWirter�� ������ �� �ִ�.
	
	//	// ���1	
	//	FileWriter fw = new FileWriter("C:/Temp/file.txt");
	//
	//	// ���2
	//	File file = new File("C:/Temp/file.txt");
	//	FileWriter fw = new FileWriter(file);
	
	// ���� ���� FileWriter�� �����ϸ� ������ ������ �̹� ������ ��� �� ������ ����� �ǹǷ�, ������ ���� ������ ������� �ȴ�.
	// ������ ���� ���� ���� �����͸� �߰��� ��쿡�� FileWriter �����ڿ� �� ��° �Ű������� true�� �ָ� �ȴ�.
	
	//	FileWriter fw = new FileWriter("C:/Temp/file.txt", true);
	//	FileWriter fw = new FileWriter(file, true);
	
	// FileWriter�� Writer�� ���� Ŭ�����̱� ������ ��� ����� Writer�� �����ϴ�. �� ���ڸ� �����ϱ� ���ؼ� write() �޼ҵ带 ����ϰ� ���ڿ��� �����ϱ� ���ؼ� write(String str) �޼ҵ带 ����Ѵ�.
	
	//	FileWriter fw = new FileWriter("C:/Temp/file.txt");
	//	String data = "������ ���ڿ�";
	//	fw.write(data);
	//	fw.flush();
	//	fw.close();
	
	// write() �޼ҵ带 ȣ���� ���Ŀ� flush() �޼ҵ�� ��� ���ۿ� �ִ� �����͸� ���Ϸ� ������ ����ϵ��� �ϰ�, close() �޼ҵ带 ȣ���ؼ� ������ �ݾ��ش�.
	// ���� ������ ���ڿ� �����͸� C:\Temp\file.txt ���Ͽ� �����Ѵ�.
	
	//	������
	//
	//	����������������������������������������������������������	����������������������������������������������������������
	//	��	:			�� �� file.txt��	��file.txt - �޸���			��
	//	��	�� Temp		��			��	����������������������������������������������������������
	//	��	�� Windows	��			��	��FileWriter�� �ѱ۷� ��			��
	//	��	�� �����		��			��	�����ڿ��� �ٷ� ����� �� �ִ�.			��
	//	��	:			��			��	��							��
	//	����������������������������������������������������������	����������������������������������������������������������
	
	// 10���ΰ� 11������ \r\n�� ĳ��������(\r)�� �����ǵ�(\n)�� EnterŰ�� ������ ������ �ϱ� ������ ���� �ٲٴ� ������ �Ѵ�.
}
