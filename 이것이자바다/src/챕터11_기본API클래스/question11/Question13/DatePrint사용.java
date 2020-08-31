package 챕터11_기본API클래스.question11.Question13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePrint사용 {
	public static void main(String[] args) {
		Date now = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 h시 m분");
		System.out.println(sdf.format(now));
		
	}
}
