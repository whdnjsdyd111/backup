package é��14_���ٽ�;

public class ��1_UsingThisExample {
	public static void main(String[] args) {
		
		��1_UsingThis usingThis = new ��1_UsingThis();
		��1_UsingThis.Inner inner = usingThis.new Inner();
		
		inner.method();
	}
}
