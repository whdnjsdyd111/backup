package é��09_��øŬ����_��ø�������̽�;

public class Question06_Chatting {
	void startChat(String chatId) {			/* ���� */
		String nickName = chatId;		// 	String nickName = null; 
										//	nickName = chatId;
		Chat chat = new Chat() {		//	null�� ������ �� chatId�� �ٲٷ� �ϸ� final Ư���� �־� ������ ����. 
			@Override
			public void start() {
				while(true) {
					String inputData = "�ȳ��ϼ���";
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
