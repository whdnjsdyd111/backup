package é��15_�÷��������ӿ�ũ;

import java.util.LinkedList;
import java.util.Queue;

public class ��2_QueueExample {
	public static void main(String[] args) {
		Queue<��2_Message> queue = new LinkedList<��2_Message>();
		
		queue.offer(new ��2_Message("sendMail", "ȫ�浿"));
		queue.offer(new ��2_Message("sendSMS", "�ſ��"));
		queue.offer(new ��2_Message("sendKakaotalk", "ȫ�β�"));
		
		while(!queue.isEmpty()) {
			��2_Message message = queue.poll();
			
			switch(message.command) {
			case "sendMail" :
				System.out.println(message.to + "�Կ��� ������ �����ϴ�. ");
				break;
			case "sendSMS" :
				System.out.println(message.to + "�Կ��� SMS�� �����ϴ�.");
				break;
			case "sendKakaotalk" :
				System.out.println(message.to + "�Կ��� īī������ �����ϴ�.");
			}
		}
	}
}
