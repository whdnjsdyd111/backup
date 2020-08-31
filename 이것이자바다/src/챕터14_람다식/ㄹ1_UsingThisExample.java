package 챕터14_람다식;

public class ㄹ1_UsingThisExample {
	public static void main(String[] args) {
		
		ㄹ1_UsingThis usingThis = new ㄹ1_UsingThis();
		ㄹ1_UsingThis.Inner inner = usingThis.new Inner();
		
		inner.method();
	}
}
