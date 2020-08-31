package 챕터09_중첩클래스_중첩인터페이스;

public class Question06_Chatting {
	void startChat(String chatId) {			/* 원래 */
		String nickName = chatId;		// 	String nickName = null; 
										//	nickName = chatId;
		Chat chat = new Chat() {		//	null로 선언한 후 chatId로 바꾸려 하면 final 특성이 있어 에러가 난다. 
			@Override
			public void start() {
				while(true) {
					String inputData = "안녕하세요";
					String message = "[" + nickName + "]" + inputData;
					sendMessage(message);
				}
			}
		};
		
		chat.start();
		
	}
	
	class Chat {
		void start() {}
		void sendMessage(String message) {}
	}
}
