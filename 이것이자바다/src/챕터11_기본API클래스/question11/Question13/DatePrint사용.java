package é��11_�⺻APIŬ����.question11.Question13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePrint��� {
	public static void main(String[] args) {
		Date now = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� E���� h�� m��");
		System.out.println(sdf.format(now));
		
	}
}
