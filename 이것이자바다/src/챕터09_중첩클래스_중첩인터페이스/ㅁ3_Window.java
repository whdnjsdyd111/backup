package é��09_��øŬ����_��ø�������̽�;

public class ��3_Window {
	��3_Button button1 = new ��3_Button();
	��3_Button button2 = new ��3_Button();
	
	// �ʵ� �ʱⰪ���� ����
	��3_Button.OnClickListener listener = new ��3_Button.OnClickListener() {
		
		@Override
		public void onClick() {
			System.out.println("��ȭ�� �̴ϴ�.");
		}
	};
	
	public ��3_Window() {
		button1.setOnClickListener(listener);
		button2.setOnClickListener(new ��3_Button.OnClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("�޼����� �����ϴ�.");
			}
		});
	}
}
