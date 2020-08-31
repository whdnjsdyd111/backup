package 챕터11_기본API클래스.ㅁ_System클래스.ㄹ_시스템프로퍼티읽기getProperty;

public class 시스템프로퍼티읽기 {
	// 시스템 프로퍼티(System Property)는 JVM이 시작할 때 자동 설정되는 시스템의 속성값을 말한다.
	// 예를 들어 운영체제의 종류 및 자바 프로그램을 실행시킨 사용자 아이디, JVM의 버전, 운영체제에서 사용되는 파일 경로 구분자 등이 여기에 속한다.
	// 시스템 프로퍼티는 키(key)와 값(value)으로 구성되어 있다. 대표적인 키와 값에 대한 설명은 다음 표에 나와있다.
	
	//	키(key)			설명							값(value)
	//
	//	java.version	자바의 버전						1.8.0_20
	//
	//	java.home		사용하는 JRE의 파일 경로			<jdk 설치 경로>\jre
	//
	//	os.name			Operating system name		Windows 7
	//
	//	file.separator	File separator("/" on UNIX)	\
	//
	//	user.name		사용자의 이름					사용자계정
	//
	//	user.home		사용자의 홈 디렉토리				C:\User\사용자계정
	//
	//	user.dir		사용자가 현재 작업 중인 디렉토리 경로		다양
	
	// 시스템 프로퍼티를 읽어오기 위해서는 System.getProperty() 메소드를 이용하면 된다.
	// 이 메소드는 시스템 프로퍼티의 키 이름을 매개값으로 받고, 해당 키에 대한 값을 문자열로 리턴한다.
	
	//	String value = System.getProperty(String key);
	
}
