package é��10_����ó��;

public class ��_ThrowsException {
	// �޼ҵ� ���ο��� ���ܰ� �߻��� �� �ִ� �ڵ带 �ۼ��� �� try - catch ������� ���ܸ� ó���ϴ� ���� �⺻������, ��쿡 ���󼭴� �޼ҵ带 ȣ���� ������ ���ܸ� ���ѱ� ���� �ִ�.
	// �̶� ����ϴ� Ű���尡 throws�̴�. throws Ű����� �޼ҵ� ����� ���� �ۼ��Ǿ� �޼ҵ忡�� ó������ ���� ���ܸ� ȣ���� ������ ���ѱ�� ������ �Ѵ�.
	// throws Ű���� �ڿ��� ���ѱ� ���� Ŭ������ ��ǥ�� �����ؼ� �������ָ� �ȴ�.
	
	//	����Ÿ�� �޼ҵ��(�Ű�����, ...) throws ����Ŭ����1, ����Ŭ����2, ... {
	//	}
	
	// �߻��� �� �ִ� ���ܴ� �������� throws �ڿ� �����ϴ� ���� �Ϲ���������, ������ ���� throws Exception������ ��� ���ܸ� ������ ���ѱ� �� �ִ�.
	
	//	����Ÿ�� �޼ҵ��(�Ű�����, ...) throws Exception {
	//	}
	
	// throws Ű���尡 �پ��ִ� �޼ҵ�� �ݵ�� try ��� ������ ȣ��Ǿ�� �Ѵ�. �׸��� catch ��Ͽ��� ���Ѱ� ���� ���ܸ� ó���ؾ� �Ѵ�.
	// ���� �ڵ�� throws Ű���尡 �ִ� method2()�� method1()���� ȣ���ϴ� ����� �����ش�.
	
	//	public void method1() {
	//
	//		try {
	//			method2();
	//		} catch(ClassNotFoundException e) {
	//			// ���� ó�� �ڵ�
	//			System.out.println("Ŭ������ �������� �ʽ��ϴ�.");
	//		}
	//	}
	//
	//	public void method2() throws ClassNotFoundException {
	//		Class clazz = Class.forName("java.lang.String2");
	//	}
	
	// method1()������ try - catch ������� ���ܸ� ó������ �ʰ� throws Ű����� �ٽ� ���ܸ� ���ѱ� �� �ִ�.
	// �׷��� method1()�� ȣ���ϴ� ������ �ᱹ try - catch ����� ����ؼ� ���ܸ� ó���ؾ� �Ѵ�.
	
	//	public void method1() throws ClassNotFoundException {
	//		method2();
	//	}
	
	// �ڹ� API ��ť��Ʈ�� ���� Ŭ���� �����ڿ� �޼ҵ� ����ο� throws Ű���尡 �ٿ��ִ� ���� ���� �� �� �ִ�. �̷��� �����ڿ� �޼ҵ带 ����ϰ� �ʹٸ� try - catch ������� ���� ó���� �ؾ��Ѵ�.
	// �ƴϸ� throws�� �ٽ� ����ؼ� ȣ���� ������ ���Ѱܾ� �Ѵ�. �׷��� ������ ������ ������ �߻��Ѵ�. ���� ��� Class�� forName() �޼ҵ带 �ڹ� API ��ť��Ʈ���� ���� ������ ����.
	
	//	forName
	//			public static Class<?> forName(String className)
	//											throws ClassNotFoundException
	
	// forName() �޼ҵ� ����� �ڿ� throws ClassNotFoundException �� �پ� �ֱ� ������ forName() �޼ҵ带 ȣ���� ��  try - catch ������� ���ܸ� ó���ϰų�,
	// throws�� ���ܸ� ���Ѱܾ� �Ѵ�. ���� �������� Class.forName() �޼ҵ带 ����ϴ� findClass() �޼ҵ�� ���ܸ� ���Ѱ��, findClass()�� ȣ���ϴ� main() �޼ҵ忡��
	// try - catch ����� ����ؼ� ���ܸ� ó���ߴ�.
	
	// main() �޼ҵ忡���� throws Ű���带 ����ؼ� ���ܸ� ���ѱ� �� �ִµ�, �ᱹ JVM�� ���������� ���� ó���� �ϰ� �ȴ�.
	// JVM�� ������ ������ �ܼ�(Console)�� ����ϴ� ������ ���� ó���� �Ѵ�.
	
	//	public static void main(String[] args) throws ClassNotFoundException {
 	//		findClass();
	//	}
	
	// main() �޼ҵ忡�� throws Exception�� ���̴� ���� ���� ���� ���� ó�� ����̴�.
	// ���α׷� ����ڴ� ���α׷��� �� �� ���� ���� ������ ����ϰ� ����Ǵ� ���� �������� �ʴ´�. �׷��� ������ main()���� try - catch ������� ���ܸ� ���� ó���ϴ� ���� �ٶ��� �ϴ�.
}
