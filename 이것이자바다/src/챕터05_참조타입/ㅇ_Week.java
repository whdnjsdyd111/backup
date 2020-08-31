package 챕터05_참조타입;

// 데이터 중 한정된 값을 가지고 있는 경우가 있다. 다음과 같이 요일에 대한 데이터는 월, 화, 수, 목, 금, 토, 일이라는 일곱 개의 값만을 갖고 있다.
// 그와 비슷하게 계절은 봄, 여름, 가을, 겨울 네 개의 값만들 가지고 있다.
// 이와 같이 한정된 값만을 갖는 데이터 타입이 열거 타입(Enumeration Type)이다.
// 열거 타입은 몇 개의 열거 상수 (Enumeration Constant) 중 하나의 상수를 저장하는 데이터 타입이다.

// 다음은 열거 타입을 선언하는 것이다.

// public enum 열거타입이름{ ... } 관례적으로 첫 문자를 대문자로 하고 나머지는 소문자로 구성한다.

// public enum Week { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, ... } 관례적으로 열거 상수는 모두 대문자로 작성한다.

public enum ㅇ_Week {	// 열거 타입 이름 
	MONDAY,		//
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,
	SUNDAY		// 열거 상수들
}

// public enum LoginResult { LOGIN_SUCCESS, LOGIN_FAILED } 여러 단어로 구성될 경우 (_) 을 사용하여 연결하는 것이 관례이다.