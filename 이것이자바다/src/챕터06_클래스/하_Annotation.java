	package 챕터06_클래스;

public class 하_Annotation {
	// 어노테이션은 메타데이터라고 볼 수 있다. 메타데이터란 애플리케이션이 처리해야 할 데이터가 아니라, 컴파일 과정과 실행 과정에서 코드를 어떻게 컴파일하고 처리할 것인지를 알려주는 정보이다.
	// 어노테이션은 다음과 같이 작성하면 된다.
	
	//	@AnnotationName
	
	// 어노테이션은 다음 세 가지 용도로 사용된다.
	
	//		컴파일러에게 코드 문법 에러를 체크하도록 정보를 제공
	//		소프트웨어 개발 툴이 빌드나 배치 시 코드를 자동으로 생성할 수 있도록 정보를 제공
	//		실행 시(런타임 시) 특정 기능을 실행하도록 정보를 제공
	
	// 컴파일에게 코드 문법 에러를 체크하도록 정보를 제공하는 대표적인 예는 @Override 어노테이션이다.
	// @Override는 메소드 선언 시 사용하는데, 메소드가 오버라이드(재정의)된 것임을 컴파일러에게 알려주어 컴파일러가 오버라이드 검사를 하도록 해준다.
	// 정확히 오버라이드가 되지 않았다면 컴파일러는 에러를 발생시킨다. 어노테이션은 빌드 시 자동으로 XML 설정 파일을 생성하거나, 배포를 위해 JAR 압출 파일을 생성하는데에도 사용된다.
	// 그리고 실행 시 클래스의 역할을 정의하기도 한다.
	
			//	Annotation Type Definition And Application	어노테이션 타입 정의와 적용
	
	// 어노테이션 타입을 정의하는 방법은 인터페이스를 정의하는 것과 유사하다. 다음과 같이 @interface를 사용해서 어노테이션을 정의하며, 그 뒤에 사용할 어노테이션 이름이 온다.
	
	//	public @interface AnnotationName {
	//	}
	
	// 이렇게 정의한 어노테이션은 코드에서 다음과 같이 사용한다.
	
	//	@Annotation
	
	// 어노테이션은 엘리먼트(element)를 멤버로 가질 수 있다. 각 엘리먼트는 타입과 이름으로 구성되며, 디폴트 값을 가질 수 있다.
	
	//	public @interface AnnotationName {
	//		타입 elementName() [default 값];		// 엘리먼트 선언
	//		...
	//	}
	
	// 엘리먼트의 타입으로는 int나 double과 같은 기본 데이터 타입이나 String, 열거 타입, Class 타입, 그리고 이들의 배열 타입을 사용할 수 있다.
	// 엘리먼트의 이름 뒤에는 메소드를 작성하는 것처럼 ()를 붙여야 한다. 예를 들어 String 타입의 엘리먼트와 int 타입의 엘리먼트를 다음과 같이 선언할 수 있다.
	
	//	public @interface AnnotationName {
	//		String elementName1();
	//		int elementName2() default 5;
	//	}
	
	// 이렇게 정의한 어노테이션을 코드에서 적용할 때에는 다음과 같이 기술한다.
	
	//	@AnnotationName(elementName="값", elementName2=3);
	//	또는
	//	@AnnotationName(elementName="값");
	
	// elementName1은 디폴트 값이 없기 때문에 반드시 값을 기술해야 하고, elementName2는 디폴트 값이 있기 때문에 생략 가능하다.
	// 어노테이션은 기본 엘리먼트인 value를 가질 수 있다.
	
	//	public @interface AnnotationName {
	//		String value();		// 기본 엘리먼트 선언
	//		int elementName() default 5;
	//	}
	
	// Value 엘리먼트를 가진 어노테이션을 코드에서 적용할 때에는 다음과 같이 값만 기술할 수 있다. 이 값은 기본 엘리먼트인 value 값으로 자동 설정된다.
	
	//	@AnnotationName("값");
	
	// 만약 value 엘리먼트와 다른 엘리먼트의 값을 동시에 주고 싶다면 다음과 같이 정상적인 방법으로 지정하면 된다.
	
	//	@AnnotationName(value="값", elemantNAme=3);
	
			// Annotation Application Target	어노테이션 적용 대상
	
	// 어노테이션을 적용할 수 있는 대상은 java.lang.annotatioin.ElementType 열거 상수로 다음과 같이 정의 되어 있다.
	
	//		ElementType 열거 상수			적용대상
	//
	//		TYPE						클래스, 인터페이스, 열거 타입
	//		ANNOTATION					어노테이션
	//		FIELD						필드
	//		CONSTRUCTOR					생성자
	//		METHOD						메소드
	//		LOCAL_VARIABLE				로컬 변수
	//		PACKAGE						패키지
	
	// 어노테이션이 적용될 대상을 지정할 때에는 @Target 어노테이션을 사용한다. @Target의 기본 엘리먼트인 value는 ElementType 배열을 값으로 가진다.
	// 이것은 어노테이션이 적용될 대상을 복수개로 지정하기 위해서이다. 에를 들어 다음과 같이 어노테이션을 정의할 경우,
	
	//	@Target( {ElementType.TYPE, ElementType.FIELD, ElementType.METHOD} )
	//	public @interface AnnotationName {
	//	}
	
	// 다음과 같이 클래스, 필드, 메소드만 어노테이션을 적용할 수 있고 생성자는 적용할 수 없다.
	
	//	@AnnotationName
	//	public class ClassName {
	//		@Annotation
	//		private String fieldName;
	//
	//		// @AnnotationName		// @Target에 CONTRUCT가 없어 생성자는 적용 못함
	//		public ClassName() {}
	//
	//		@AnnotationName
	//		public void methodName () {}
	//	}
	
			// Annotation Retention Policy	어노테이션 유지 정책
	
	// 어노테이션 정의 시 한 가지 더 추가해야 할 내용은 사용 용도에 따라 @AnnotationName을 어느 범위까지 유지할 것인지 지정해야 한다.
	// 쉽게 설명하면 소스상에만 유지할 건지, 컴파일된 클래스까지 유지할 건지, 런타임 시에도 유지할 건지를 지정해야 한다.
	// 어노테이션 유지 정책은 java.lang.annotation.RetentionPolicy 열거 상수로 다음과 같이 정의되어 있다.
	
	//		RetentionPolicy 열거 상수		설명
	//		
	//		SOURCE						소스상에서만 어노테이션 정보를 유지한다. 소스 코드를 분석할 때만 의미가 있으며, 바이트 코드 파일에는 정보가 남지 않는다.
	//
	//		CLASS						바이트 코드 파일까지 어노테이션 정보를 유지한다. 하지만 리플렉션을 이용해서 어노테이션 정보를 얻을 수 없다.
	//
	//		RUNTIME						바이트 코드 파일까지 어노테이션 정보를 유지하면서 리플렉션을 이용해서 런타임 시에 어노테이션 정보를 얻을 수 있다.
	
	// 리플렉션(Reflection)이란 런타임 시에 클래스의 메타 정보를 얻는 기능을 말한다. 예를 들어 클래스가 가지고 있는 필드가 무엇인지, 어떤 생성자를 갖고 있는지, 어떤 메소드를 가지고 있는지,
	// 적용된 어노테이션이 무엇인지 알아내는 것이 리플렉션이다. 리플렉션을 이용해서 런타임 시에 어노테이션 정보를 얻으려면 어노테이션 유지 정책을 RUNTIME으로 설정해야 한다.
	// 어노테이션 유지 정책을 지정할 때에는 @Retention 어노테이션을 사용한다. @Retention의 기본 엘리먼트인 value는 RetentionPolicy 타입이므로 위 세가지 상수 중 하나를 지정하면 된다.
	// 코드 자동 생성 툴을 개발하지 않는 이상 우리가 작성하는 어노테이션은 대부분 런타임 시점에 사용하기 위한 용도로 만들어진다. 다음은 런타임 유지 정책을 적용한 어노테이션이다.
	
	//	@Target( {ElementType.TYPE, ElementType.FIELD, ElementType.METHOD} )
	//	@Retention(RetentionPolicy.RUNTIME)
	//	public @interface AnnotationName {
	//	}
	
			//	Using Annotation Information At Runtime	런타임 시 어노테이션 정보 사용하기
	
	// 런타임 시에 어노테이션이 적용되었는지 확인하고 엘리먼트 값을 이용해서 특정 작업을 수행하는 방법에 대해 알아보자.
	// 어노테이션 자체는 아무런 동작을 가지지 않는 단지 표식일 뿐이지만, 리플렉션을 이용해서 어노테이션의 적용 여부와 엘리먼트 값을 읽고 적절히 처리할 수 있다.
	// 클래스에 적용된 어노테이션 정보를 얻으려면 java.lang.Class를 이용하면 되지만, 필드, 생성자, 메소드에 적용된 어노테이션 정보를 얻으려면
	// Class의 다음 메소드를 통해서 java.lang.reflect 패키지의 Field, Constructor, Method 타입의 배열을 얻어야 한다.
	
	//		리턴 타입			메소드명(매개 변수)			설명
	//
	//		Field[]			getFields()				필드 정보를 Field 배열로 리턴
	//
	//		Constructor[]	getConstructor()		생성자 정보를 Constructor 배열로 리턴
	//
	//		Method[]		getDeclaredMethods()	메소드 정보를 Method 배열로 리턴
	
	// 그런 다음 Class, Field, Constructor, Method가 가지고 있는 다음 메소드를 호출해서 적용된 어노테이션 정보를 얻을 수 있다.
	
	//		리턴 타입			메소드명(매개 변수
	
	//		boolean			isAnnotationPresent( Class < ? extends Annotation > annotationClass )
	//						지정한 어노테이션이 적용되었는지 여부. Class에서 호출했을 때 상위 클래스에 적용된 경우에도 true를 리턴한다.
	//
	//		Annotation		getAnnotation( Class < T > annotationClass )
	//						지정한 어노테이션이 적용되어 있으면 어노테이션을 리턴하고 그렇지 않다면 null을 리턴한다.
	//						Class에서 호출했을 때 상위 클래스에 적용된 경우에도 어노테이션을 리턴한다.
	//
	//		Annotation[]	getAnnotations()
	//						적용된 모든 어노테이션을 리턴한다. Class에 호출했을 때 상위 클래스에 적용된 어노테이션도 모두 포함한다.
	//						적용된 어노테이션이 없을 경우 길이가 0인 배열을 리턴한다.
	//
	//		Annotation[]	getDeclaredAnnotations()
	//						직접 적용된 모든 어노테이션을 리턴한다. Class에서 호출했을 때 상위 클래스에 적용된 어노테이션은 포함되지 않는다.
	
	// 어노테이션과 리플렉션을 이용해서 간단한 예제를 만들어 보자. 다음 예제는 메소드의 실행 내용을 구분선으로 분리해서 콘솔에 출력하도록 하는 PrintAnnotation이다.
}
