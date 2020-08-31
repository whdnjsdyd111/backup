package 챕터11_기본API클래스.ㅁ_System클래스.ㄷ_현재시각읽기currentTimeMillis와nanoTime;

// 다음 에제는 for문을 사용해서 1부터 1000000까지의 합을 구하는데 걸린 시간을 출력한다.

public class SystemTime사용 {
	public static void main(String[] args) {
		long time1 = System.nanoTime(); // 시작 시간 읽기
		
		int sum = 0;
		for(int i=1; i<=1000000; i++) {
			sum += i;
		}
		
		long time2 = System.nanoTime(); // 끝 시간 읽기
		
		System.out.println("1~1000000까지의 합: " + sum);
		System.out.println("계산에 " + (time2-time1) + "나노초가 소요되었습니다.");
	}
}
