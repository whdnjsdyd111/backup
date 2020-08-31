package Ã©ÅÍ13_Á¦³×¸¯;

public class ¤µ1_StorageImpl<T> implements ¤µ1_Storage<T>{
	private T[] array;
	
	public ¤µ1_StorageImpl(int capacity) {
		this.array = (T[]) (new Object[capacity]);
	}
	
	@Override
	public void add(T item, int index) {
		array[index] = item;	
	}
	
	@Override
	public T get(int index) {
		return array[index];
	}
}
