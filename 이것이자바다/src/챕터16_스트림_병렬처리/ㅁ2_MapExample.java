package é��16_��Ʈ��_����ó��;

import java.util.Arrays;
import java.util.List;

public class ��2_MapExample {
	public static void main(String[] args) {
		
		List<��2_Student> list = Arrays.asList(
			new ��2_Student("ȫ�浿", 10),
			new ��2_Student("�ſ��", 20),
			new ��2_Student("���̼�", 30)
		);
		
		list.stream()
			.mapToInt(��2_Student :: getScore)
			.forEach( score -> System.out.println(score) );
	}
}
