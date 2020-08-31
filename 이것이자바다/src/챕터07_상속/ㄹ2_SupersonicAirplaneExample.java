package √©≈Õ07_ªÛº”;

public class §©2_SupersonicAirplaneExample {
	public static void main(String[] args) {
		
		§©2_SupersonicAirplane sa = new §©2_SupersonicAirplane();
		
		sa.takeOff();
		sa.fly();
		
		sa.flyMode = §©2_SupersonicAirplane.SUPERSONIC;
		sa.fly();
		
		sa.flyMode = §©2_SupersonicAirplane.NOMAL;
		sa.fly();
		
		sa.land();
	}
}
