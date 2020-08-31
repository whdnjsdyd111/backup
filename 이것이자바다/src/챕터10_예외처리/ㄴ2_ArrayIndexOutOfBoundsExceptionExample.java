package 챕터10_예외처리;
	
public class ㄴ2_ArrayIndexOutOfBoundsExceptionExample {
	public static void main(String[] args) {
		if(args.length == 2) {
			String data1 = args[0];
			String data2 = args[1];
			System.out.println("args[0]: " + data1);
			System.out.println("args[1]: " + data2);
		} else {
			System.out.println("[실행 방법]");
			System.out.println("java\tArrayIndexOutOfBoundsExceptionExample\t값1\t값2");
		}
	}
}
