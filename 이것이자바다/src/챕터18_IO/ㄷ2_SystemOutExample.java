package é��18_IO;

import java.io.OutputStream;

public class ��2_SystemOutExample {
	public static void main(String[] args) throws Exception {
		OutputStream os = System.out;
		
		for(byte b = 48; b < 58; b++) {
			os.write(b);	// �ƽ�Ű �ڵ� 48���� 57������ ���ڸ� ���
		}
		
		os.write(10);		// �����ǵ�(10)�� ����ϸ� ���� ������ �Ѿ��.
		
		for(byte b = 97; b < 123; b++) {
			os.write(b);
		}
		
		os.write(10);
		
		String hangul = "�����ٶ󸶹ٻ������īŸ����";
		byte[] hangulBytes = hangul.getBytes();
		os.write(hangulBytes);
		
		os.flush();
	}
}
