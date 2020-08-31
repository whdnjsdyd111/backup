package 챕터18_IO;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ㄹ1_FileExample {
	public static void main(String[] args) throws Exception {
		File dir = new File("C:/Temp/Dir");
		File file1 = new File("C:/Temp/file1.txt");
		File file2 = new File("C:/Temp/file2.txt");
		File file3 = new File(new URI("file:///C:/Temp/file3.txt"));	// 파일 경로를 URI 객체로 생성해서 매개값으로 제공해도 됨
		
		if(dir.exists() == false) { dir.mkdirs(); }
		if(file1.exists() == false) { file1.createNewFile(); }
		if(file2.exists() == false) { file2.createNewFile(); }
		if(file3.exists() == false) { file3.createNewFile(); }
		
		File temp = new File("C:/Temp");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd		a	HH:mm");
		File[] contents = temp.listFiles();
	
		System.out.println("날짜			        시간		형태	                크기	    이름");
		System.out.println("─────────────────────────────────────────────────────────────────────────");
		for(File file : contents) {
			System.out.print(sdf.format(new Date(file.lastModified())));
			if(file.isDirectory()) {
				System.out.print("\t<Dir>\t\t\t" + file.getName());
			} else {
				System.out.print("\t\t\t" + file.length() + "\t" + file.getName());
			}
			System.out.println();
		}
	}
}
