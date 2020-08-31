package 챕터11_기본API클래스.하_Format클래스.ㄴ_날짜형식클래스SimpleDateFormat;

public class 날짜형식클래스 {
	// Date 클래스의 toString() 메소드는 영문으로된 날짜를 리턴하는데 만약 특정 문자열 포맷으로 얻고 싶다면 
	// java.text.SimpleDateFormat 클래스를 이용하면 된다.
	// SimpleDateFormat 클래스도 날짜를 원하는 형식으로 표햔하기 위해서 패턴을 사용하는데 다음 표는 SimpleDateFormat의 패턴 작성에 사용되는 기호다.
	
	//	패턴문자		의미						패턴문자		의미
	
	//	y			년						H			시(0~23)
	
	//	M			월						h			시(1~12)
	
	//	d			일						K			시(0~11)
	
	//	D			월 구분이 없는 일(1~365)		k			시(1~24)
	
	//	E			요알						m			분
	
	//	a			오전/오후					s			초
	
	//	w			년의 몇 번째 주				S			밀리세컨드(1/1000초)
		
	//	W			월의 몇 번째 주
	
	// 패턴에는 자릿수에 맞게 기호를 반복해서 작성할 수 있다. 예를 들어 yyyy는 년도를 4자리로 표시하라는 의미이고,
	// MM, dd는 각각 달과 일을 2자리로 표시하라는 의미이다. 
	// 적용할 패턴을 작성했다면 이 패턴을 SimpleDateFormat의 생성자 매개값으로 지정해 객체를 생성하면 된다.
	// 그리고나서 format() 메소드를 호출해서 패턴이 적용된 문자열을 얻으면 된다.
	
	//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
	//	String strDate = sdf.format(new Date());
}
