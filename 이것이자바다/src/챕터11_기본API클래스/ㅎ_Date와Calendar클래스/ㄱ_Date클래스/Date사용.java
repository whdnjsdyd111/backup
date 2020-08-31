package 챕터11_기본API클래스.ㅎ_Date와Calendar클래스.ㄱ_Date클래스;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date사용 {
	public static void main(String[] args) {
		Date now = new Date();
		String strNow1 = now.toString();
		System.out.println(strNow1);
		
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
	}
}
