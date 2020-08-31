package 챕터07_상속;

public class ㄴ1_DmbCellPhone extends ㄴ1_CellPhone {
	// 필드
	int channel;

	// 생성자
	ㄴ1_DmbCellPhone(String model, String color, int channel) {
		this.model = model;
		this.color = color;
		this.channel = channel;
	}

	// 메소드
	void turnOnDmb() {
		System.out.println("채널 " + channel + "번 DMB 방송 수신을 시작합니다.");
	}
	
	void changeChannelBmb(int channel) {
		this.channel = channel;
		System.out.println("채널 " + channel + "번으로 바꿉니다.");
	}
	
	void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}
}
