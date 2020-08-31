package 챕터06_클래스;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( { ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface 하1_PrintAnnotation {
	String value() default "-";
	int number() default 15;
}

// 런타임 시까지 어노테이션 정보를 유지하도록 RUNTIME으로 기술하였고
// 기본 엘리먼트 value는 구분선에 사용될 문자이고, number는 반복 출력 횟수이다.
// 각각 디폴트 값으로 "-"와 15를 주었다.
