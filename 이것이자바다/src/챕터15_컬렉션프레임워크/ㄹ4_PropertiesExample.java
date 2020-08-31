package 챕터15_컬렉션프레임워크;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;

public class ㄹ4_PropertiesExample {
	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		String path = ㄹ4_PropertiesExample.class.getResource("ㄹ4_database.properties").getPath();
		path = URLDecoder.decode(path, "utf-8");
		properties.load(new FileReader(path));
		
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		System.out.println(driver);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}
}
