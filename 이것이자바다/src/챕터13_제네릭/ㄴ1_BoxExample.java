package 챕터13_제네릭;

public class ㄴ1_BoxExample {
	public static void main(String[] args) {
		ㄴ1_Box box = new ㄴ1_Box();
		box.set("홍길동");					// String -> Object ( 자동 타입 변환 )
		String name = (String) box.get();	// Object -> String	( 강제 타입 변환 )
		
		box.set(new ㄴ1_Apple());				// Apple -> Object ( 자동 타입 변환 )
		ㄴ1_Apple apple = (ㄴ1_Apple) box.get();	// Object -> Apple ( 강제 타입 변환 )
	}
}
