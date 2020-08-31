package √©≈Õ09_¡ﬂ√∏≈¨∑°Ω∫_¡ﬂ√∏¿Œ≈Õ∆‰¿ÃΩ∫;

public class Question04_NestedClassExample {
	public static void main(String[] args) {
		Question04_Car car = new Question04_Car();
		
		Question04_Car.Tire tire = car.new Tire();
		
		Question04_Car.Engine engine = new Question04_Car.Engine();
	}
}
