package é��10_����ó��;

public class ��1_TryWithResourceExample {
	public static void main(String[] args) {
		
		try(��1_FileInputStream fis = new ��1_FileInputStream("file.txt")){
			fis.read();
			throw new Exception();
		} catch (Exception e) {
			System.out.println("���� ó�� �ڵ尡 ����Ǿ����ϴ�.");
		}
	}
}
