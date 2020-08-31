package 矇攪06_贗楚蝶;

public class 內4_Singleton {
	private static 內4_Singleton singleton = new 內4_Singleton();
	
	private 內4_Singleton() {}
	
	static 內4_Singleton getInstance() {
		return singleton;
	}
}
