package 챕터13_제네릭;

public class ㄹ1_Util {
	public static <T> ㄴ2_Box<T> boxing(T t){
		ㄴ2_Box<T> box = new ㄴ2_Box<T>();
		box.set(t);
		return box;
	}
}
