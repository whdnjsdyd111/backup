package é��16_��Ʈ��_����ó��;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ��1_FromCollectionExample {
	public static void main(String[] args) {
		
		List<��1_Student> list = Arrays.asList(
			new ��1_Student("ȫ�浿", 10),
			new ��1_Student("�ſ��", 20),
			new ��1_Student("���̼�", 30)
		);
		
		Stream<��1_Student> stream = list.stream();
		stream.forEach( s -> System.out.println(s.getName()) );
	}
}
