package 챕터06_클래스;

public class ㅎ1_Car {
	// 필드
	private int speed;
	private boolean stop;
	
	// 생성자
	
	// 메소드
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		if(speed < 0) {
			this.speed = 0;
			return;
		} else {
			this.speed = speed;
		}
	}
	
	public boolean isStop() {
		return stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	}
}
