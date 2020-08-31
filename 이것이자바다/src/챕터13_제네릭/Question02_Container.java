package 챕터13_제네릭;

public class Question02_Container<T> {
	private T t;
	
	public T get() { return this.t; }
	public void set(T t) { this.t = t; }
	
}
