package é��11_�⺻APIŬ����.��_SystemŬ����.��_���α׷�����exit;

public class Exit��� {
	public static void main(String[] args) {
		// ���� ���� ������
		System.setSecurityManager(new SecurityManager() {
			@Override
			public void checkExit(int status) {
				if(status != 5) {
					throw new SecurityException();
				}
			}
		});
		
		for(int i=0; i<10; i++) {
			// i�� ���
			System.out.println(i);
			try {
				// JVM ���� ��û
				System.exit(i);
			} catch(SecurityException e) {}
		}
	}
}
