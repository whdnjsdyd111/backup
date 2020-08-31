package 챕터09_중첩클래스_중첩인터페이스;

public class ㅁ3_Window {
	ㅁ3_Button button1 = new ㅁ3_Button();
	ㅁ3_Button button2 = new ㅁ3_Button();
	
	// 필드 초기값으로 대입
	ㅁ3_Button.OnClickListener listener = new ㅁ3_Button.OnClickListener() {
		
		@Override
		public void onClick() {
			System.out.println("전화를 겁니다.");
		}
	};
	
	public ㅁ3_Window() {
		button1.setOnClickListener(listener);
		button2.setOnClickListener(new ㅁ3_Button.OnClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("메세지를 보냅니다.");
			}
		});
	}
}
