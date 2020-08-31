package é��10_����ó��;

public class ��_ClosingAutomicResource {
	// �ڹ� 7 ���� ���� �߰��� try - with - resources�� ����ϸ� ���� �߻� ���ο� ������� 
	// ����ߴ� ���ҽ� ��ü(���� ����� ��Ʈ��, ���� ����, ����, ���� ä��)�� close() �޼ҵ带 ȣ���ؼ� �����ϰ� ���ҽ��� �ݾ��ش�.
	// ���ҽ���� ���� �����ϰ� �鸱���� �𸣰ڴ�. ���ҽ��� ���� ���� �ǹ̰� ������ ���⼭�� �����͸� �а� ���� ��ü��� �����ϸ� �ȴ�.
	// ���� ��� ������ �����͸� �д� FileInputStream ��ü�� ���Ͽ� ���� FileOutputStream�� ���ҽ� ��ü��� ���� �ȴ�.
	// ������ ���ҽ� ��ü�� �����ϰ� �ݱ� ���� �ڹ� 6 �������� ����ߴ� �ڵ��̴�.
	
	//	FileInputStream fis = null;
	//	try {
	//		fis = new FileInputStream("file.txt");
	//		...
	//	} catch(IOException e) {
	//		...
	//	} finally {
	//		if(fis != null) {
	//			try { 
	//				fis.close();
	//			} catch (IOException e) {}
	//		}
	//	}
	
	// finally ��Ͽ��� �ٽ� try - catch�� ����ؼ� close() �޼ҵ带 ���� ó���ؾ� �ϹǷ� �ټ� �����ϰ� ���δ�. �ڹ� 7 ���� �߰��� try - with - resources�� ����ϸ� ������ ���� ����������.
	// ��� ���� close()�� ��������� ȣ���� ���� ����.
	
	//	try(FileInputStream fis = new FileInputStream("file.txt")) {
	//		...
	//	} catch(IOException e) {
	//		...
	//	}
	
	// try ����� ���������� ������ �Ϸ��߰ų� ���߿� ���ܰ� �߻��ϰ� �Ǹ� �ڵ����� FileInputStream�� close() �޼ҵ尡 ȣ��ȴ�.
	// try{}���� ���ܰ� �߻��ϸ� �켱 close()�� ���ҽ��� �ݰ� catch ����� �����Ѵ�. ���� ���� ���� ���ҽ��� ����ؾ� �Ѵٸ� ������ ���� �ۼ��� �� �ִ�.
	
	//	try(
	//		FileInputStream fis = new FileInputStream("file1.txt");
	//		FileOutputStream fos = new FileOutputStream(file2.txt");
	//	){
	//		...
	//	} catch(IOException e) {
	//		...
	//	}
	
	// try - with - resources�� ����ϱ� ���ؼ��� ������ �ִµ�, ���ҽ� ��ü�� java.lang.AutoCloseable �������̽��� �����ϰ� �־�� �Ѵ�.
	// AutoCloseable���� close() �޼ҵ尡 ���ǵǾ� �ִµ� try - with - resources�� �ٷ� �� close() �޼ҵ带 �ڵ� ȣ���Ѵ�.
	// API ��ť��Ʈ���� AutoCloseable �������̽��� ã�� "All Known Implements Classes:"�� ���� try - with - resources�� �Բ� ����� �� �ִ� ���ҽ��� � ���� �ִ��� �� �� �ִ�.
	// ���� ������ ���� AutoCloseable�� �����ؼ� FileInputStream Ŭ������ �ۼ��ߴ�. TryWithResourceExample Ŭ������ main() �޼ҵ尡
	// try - with - resources�� ����ϸ� ���ܰ�  �߻��ϴ� ��� �ڵ����� FileInputStream�� close()�� ȣ��Ǵ� ���� �� �� �ִ�.
}
