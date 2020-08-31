package 챕터07_상속;

public class ㅁ2_SportsCar extends ㅁ2_Car{
	@Override
	public void speedUp() {
		speed += 10;
	}
	
	/*	오버라이딩을 할수 없음
	
	@Override
	public void stop() {
		System.out.println("스포츠카를 멈춤");
		speed = 0;
	}
	*/
}
