package 챕터11_기본API클래스.ㅁ_System클래스.ㅁ_환경변수읽기getenv;

public class SystemEnv {
	public static void main(String[] args) {
		String javaHome = System.getenv("JAVA_HOME");
		System.out.println("JAVA_HONE: "+javaHome);
	}
}
