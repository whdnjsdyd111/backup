package é��16_��Ʈ��_����ó��;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ��2_LambdaExpressionExample {
	public static void main(String[] args) {
		
		List<��2_Student> list = Arrays.asList(
			new ��2_Student("ȫ�浿", 90),
			new ��2_Student("�ſ��", 92)
		);
				
		Stream<��2_Student> stream = list.stream();
		stream.forEach( s -> {
			String name = s.getName();
			int score = s.getScore();
			System.out.println(name + " - " + score);
		});
	}
}
