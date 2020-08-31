package 챕터15_컬렉션프레임워크;

import java.util.LinkedList;
import java.util.Queue;

public class ㅂ2_QueueExample {
	public static void main(String[] args) {
		Queue<ㅂ2_Message> queue = new LinkedList<ㅂ2_Message>();
		
		queue.offer(new ㅂ2_Message("sendMail", "홍길동"));
		queue.offer(new ㅂ2_Message("sendSMS", "신용권"));
		queue.offer(new ㅂ2_Message("sendKakaotalk", "홍두께"));
		
		while(!queue.isEmpty()) {
			ㅂ2_Message message = queue.poll();
			
			switch(message.command) {
			case "sendMail" :
				System.out.println(message.to + "님에게 메일을 보냅니다. ");
				break;
			case "sendSMS" :
				System.out.println(message.to + "님에게 SMS를 보냅니다.");
				break;
			case "sendKakaotalk" :
				System.out.println(message.to + "님에게 카카오톡을 보냅니다.");
			}
		}
	}
}
