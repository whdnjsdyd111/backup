package 챕터07_상속;

public class ㅅ4_Car {
	// 필드
	ㅅ3_Tire[] tires = {
			new ㅅ3_Tire("앞왼쪽", 6),
			new ㅅ3_Tire("앞오른쪽", 2),
			new ㅅ3_Tire("뒤왼쪽", 3),
			new ㅅ3_Tire("뒤오른쪽", 4)
	};
	
	// 생성자
	
	// 메소드
	int run() {
		System.out.println("[자동차가 달립니다.]");

		for (int i = 0; i < tires.length; i++) {

			if (tires[i].roll() == false) {

				stop();
				return (i + 1);

			}
		}

		return 0;
	}

	void stop() { // 펑크 났을 때 실행
		System.out.println("[자동차가 멈춥니다.]");
	}
}
