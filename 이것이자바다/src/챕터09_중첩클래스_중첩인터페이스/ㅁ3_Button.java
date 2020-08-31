package √©≈Õ09_¡ﬂ√∏≈¨∑°Ω∫_¡ﬂ√∏¿Œ≈Õ∆‰¿ÃΩ∫;

public class §±3_Button {
	
	private OnClickListener listener;
	
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
