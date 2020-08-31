package √©≈Õ08_¿Œ≈Õ∆‰¿ÃΩ∫;

public class Question03_SoundableExample {

	private static void printSound(Question03_Soundable question03) {
		System.out.println(question03.sound());
	}
	
	public static void main(String[] args) {
		
		printSound(new Question03_Soundable() {
			
			@Override
			public String sound() {
				return "∏€∏€";
			}
		});
	
		printSound(new Question03_Soundable() {
			
			@Override
			public String sound() {
				return "æﬂøÎ";
			}
		});
		
		printSound(new Question03_Dog());
		printSound(new Question03_Cat());
		
	}
	
}
