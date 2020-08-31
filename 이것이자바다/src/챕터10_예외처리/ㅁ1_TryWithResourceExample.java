package 챕터10_예외처리;

public class ㅁ1_TryWithResourceExample {
	public static void main(String[] args) {
		
		try(ㅁ1_FileInputStream fis = new ㅁ1_FileInputStream("file.txt")){
			fis.read();
			throw new Exception();
		} catch (Exception e) {
			System.out.println("예외 처리 코드가 실행되었습니다.");
		}
	}
}
