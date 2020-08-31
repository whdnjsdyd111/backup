package √©≈Õ09_¡ﬂ√∏≈¨∑°Ω∫_¡ﬂ√∏¿Œ≈Õ∆‰¿ÃΩ∫;

public class §±4_Anonymous {
	private int field;
	
	public void method(final int arg1, int arg2) {
		final int var1 = 0;
		int var2 = 0;
		
		field = 10;
		
		§±4_Calculator cal = new §±4_Calculator() {
			
			@Override
			public int sum() {
				int result = field + arg1 + arg2 + var1 + var2;
				return result;
			}
		};
		
		System.out.println(cal.sum());
	}
}
