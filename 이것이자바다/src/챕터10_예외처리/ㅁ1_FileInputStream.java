package 챕터10_예외처리;

public class ㅁ1_FileInputStream implements AutoCloseable {
	private String file;
	
	public ㅁ1_FileInputStream(String file) {
		this.file = file;
	}
	
	public void read() {
		System.out.println(file + "을 읽습니다.");
	}
	
	@Override
	public void close() throws Exception {
		System.out.println(file + "을 닫습니다.");
	}
}
