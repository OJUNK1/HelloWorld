package co.yedam.singleton;

public class Singleton {
	private static Singleton instance = new Singleton();
	
	// 외부에서 접근 불가.
	private Singleton() {
		
	}
	public static Singleton getInstance() {
		return instance;
	}
}	