package Ã©ÅÍ13_Á¦³×¸¯;

public class Question03_Container<T, M> {
	private T key;
	private M value;
	
	public void set(T key, M value) {
		this.key = key;
		this.value = value;
	}
	
	public T getKey() { return this.key; }
	public M getValue() { return this.value; }
	
}
