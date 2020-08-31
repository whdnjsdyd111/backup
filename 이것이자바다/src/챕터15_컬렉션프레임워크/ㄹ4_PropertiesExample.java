package é��15_�÷��������ӿ�ũ;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;

public class ��4_PropertiesExample {
	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		String path = ��4_PropertiesExample.class.getResource("��4_database.properties").getPath();
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
