package 챕터13_제네릭;

public class ㅁ1_Util {
	public static <T extends Number> int compare(T t1, T t2) {
		double v1 = t1.doubleValue();	// Number의 doubleValue() 메소드 사용
		double v2 = t2.doubleValue();	// Number의 doubleValue() 메소드 사용
		return Double.compare(v1, v2);
	}
}
