package é��16_��Ʈ��_����ó��;

import java.util.Arrays;
import java.util.List;

public class ��2_MapAndReduceExample {
	public static void main(String[] args) {
		
		List<��2_Student> list = Arrays.asList(
			new ��2_Student("ȫ�浿", 10),
			new ��2_Student("�ſ��", 20),
			new ��2_Student("���̼�", 30)
		);
		
		double avg = list.stream()
			// �߰� ó�� (�л� ��ü�� ������ ����)
			.mapToInt(��2_Student :: getScore)
			// ���� ó�� (��� ����)
			.average()
			.getAsDouble();
		
		System.out.println("��� ����: " +avg);
			
	}
}
