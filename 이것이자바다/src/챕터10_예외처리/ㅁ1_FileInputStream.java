package é��10_����ó��;

public class ��1_FileInputStream implements AutoCloseable {
	private String file;
	
	public ��1_FileInputStream(String file) {
		this.file = file;
	}
	
	public void read() {
		System.out.println(file + "�� �н��ϴ�.");
	}
	
	@Override
	public void close() throws Exception {
		System.out.println(file + "�� �ݽ��ϴ�.");
	}
}
