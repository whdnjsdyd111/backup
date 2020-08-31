package 챕터09_중첩클래스_중첩인터페이스;

public class ㄹ1_Button {
	private OnClickListener listener;		// 인터페이스 타입 필드
	
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
