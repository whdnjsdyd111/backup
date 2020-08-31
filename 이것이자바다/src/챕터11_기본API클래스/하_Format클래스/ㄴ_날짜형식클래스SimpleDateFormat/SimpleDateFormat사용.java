package 챕터11_기본API클래스.하_Format클래스.ㄴ_날짜형식클래스SimpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormat사용 {
	public static void main(String[] args) {
		Date now = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println( sdf.format(now) );
		
		sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println( sdf.format(now) );
		
		sdf = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
		System.out.println( sdf.format(now) );
		
		sdf = new SimpleDateFormat("오늘은 E요일");
		System.out.println( sdf.format(now) );
		
		sdf = new SimpleDateFormat("올해의 D번째 날");
		System.out.println( sdf.format(now) );
		
		sdf = new SimpleDateFormat("이달의 d번째 날");
		System.out.println( sdf.format(now) );
		
	}
}
