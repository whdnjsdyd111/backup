package 챕터05_참조타입;

public class ㅈ6_Theorem {
	public static void main(String[] args) {
		
		// name() 메소드
		ㅇ_Week today = ㅇ_Week.SUNDAY;
		String name = today.name();
		System.out.println(name);
		
		// ordinal() 메소드
		int ordinal = today.ordinal();
		System.out.println(ordinal);
		
		// compareTo() 메소드
		ㅇ_Week day1 = ㅇ_Week.MONDAY;
		ㅇ_Week day2 = ㅇ_Week.WEDNESDAY;
		int result1 = day1.compareTo(day2);
		int result2 = day2.compareTo(day1);
		System.out.println(result1);
		System.out.println(result2);
		
		// valueOf() 메소드
		String tomorrow1 = "THURSDAY";
		ㅇ_Week tomorrow2 = ㅇ_Week.valueOf(tomorrow1);
		System.out.println(tomorrow2);
		
		// values() 메소드
		ㅇ_Week[] days = ㅇ_Week.values();
		for(ㅇ_Week day : days) {
			System.out.println(day);
		}
	}
}
