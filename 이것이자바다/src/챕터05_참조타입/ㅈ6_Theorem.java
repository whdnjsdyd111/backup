package é��05_����Ÿ��;

public class ��6_Theorem {
	public static void main(String[] args) {
		
		// name() �޼ҵ�
		��_Week today = ��_Week.SUNDAY;
		String name = today.name();
		System.out.println(name);
		
		// ordinal() �޼ҵ�
		int ordinal = today.ordinal();
		System.out.println(ordinal);
		
		// compareTo() �޼ҵ�
		��_Week day1 = ��_Week.MONDAY;
		��_Week day2 = ��_Week.WEDNESDAY;
		int result1 = day1.compareTo(day2);
		int result2 = day2.compareTo(day1);
		System.out.println(result1);
		System.out.println(result2);
		
		// valueOf() �޼ҵ�
		String tomorrow1 = "THURSDAY";
		��_Week tomorrow2 = ��_Week.valueOf(tomorrow1);
		System.out.println(tomorrow2);
		
		// values() �޼ҵ�
		��_Week[] days = ��_Week.values();
		for(��_Week day : days) {
			System.out.println(day);
		}
	}
}
