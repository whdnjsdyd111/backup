package 챕터07_상속;

public class ㄴ1_DmbCellPhoneExample {
	public static void main(String[] args) {
		// DmbCellPhone 객체 생성
		ㄴ1_DmbCellPhone dmbCellPhone = new ㄴ1_DmbCellPhone("자바폰", "검정", 10);
		ㄴ1_CellPhone cell = new ㄴ1_CellPhone();
		
		// CellPhone으로부터 상속받은 필드
		System.out.println("모델: " + dmbCellPhone.model);
		System.out.println("색상: " + dmbCellPhone.color);
		
		// DmbCellPhone의 필드
		System.out.println("채널: " + dmbCellPhone.channel);
		
		// CellPhone으로부터 상속받은 메소드 포출
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("여보세요");
		dmbCellPhone.receiveVoice("네~");
		dmbCellPhone.sendVoice("아네");
		dmbCellPhone.hangUp();
		
		// DmbCellPhone의 메소드 호출
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelBmb(12);
		dmbCellPhone.turnOffDmb();
		
	}
}
