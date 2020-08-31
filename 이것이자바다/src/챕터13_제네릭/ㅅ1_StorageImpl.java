package é��13_���׸�;

public class ��1_StorageImpl<T> implements ��1_Storage<T>{
	private T[] array;
	
	public ��1_StorageImpl(int capacity) {
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
