package é��09_��øŬ����_��ø�������̽�;

public class ��1_Button {
	private OnClickListener listener;		// �������̽� Ÿ�� �ʵ�
	
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	void touch() {
		listener.onClick();
	}
	
	interface OnClickListener {
		void onClick();
	}
}
