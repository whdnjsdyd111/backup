package é��06_Ŭ����;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( { ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ��1_PrintAnnotation {
	String value() default "-";
	int number() default 15;
}

// ��Ÿ�� �ñ��� ������̼� ������ �����ϵ��� RUNTIME���� ����Ͽ���
// �⺻ ������Ʈ value�� ���м��� ���� �����̰�, number�� �ݺ� ��� Ƚ���̴�.
// ���� ����Ʈ ������ "-"�� 15�� �־���.
