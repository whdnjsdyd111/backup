package é��09_��øŬ����_��ø�������̽�;

public class ��1_ButtonExample {
	public static void main(String[] args) {
		��1_Button btn = new ��1_Button();
		
		btn.setOnClickListener(new ��1_CallListener());
		btn.touch();
		
		btn.setOnClickListener(new ��1_MessageListener());
		btn.touch();
		
	}
}
