package 챕터06_클래스;

public class ㅊ4_SingletonExample {
	public static void main(String[] args) {
		/*
		ㅊ4_Singleton obj1 = new ㅊ4_Singleton();		// 컴파일 에러
		ㅊ4_Singleton obj2 = new ㅊ4_Singleton();		// 컴파일 에러
		 */
		
		ㅊ4_Singleton obj1 = ㅊ4_Singleton.getInstance();
		ㅊ4_Singleton obj2 = ㅊ4_Singleton.getInstance();
		
		System.out.println(obj1 == obj2);
	}
}
