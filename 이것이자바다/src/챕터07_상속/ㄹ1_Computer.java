package é��07_���;

public class ��1_Computer extends ��1_Calculator {
	@Override
	double areaCircle(double r) {
		System.out.println("Computer ��ü�� areaCircle() ����");
		return Math.PI * r * r;
	}
	
	// �� �� ������ ����� ���� Computer�� �޼ҵ忡�� Math.PI ����� �̿��ߴ�.
	// ��� @Override ������̼��� �����ص� ������ �̰��� �ٿ������ν� ��Ȯ�� �������̵��� ������ �����Ϸ��� üũ�ϱ� ������ �������� �Ǽ��� �ٿ��ش�.
	// ���� �����ڰ� �Ǽ��� areaCircl() ó�� ���� e�� ���԰� �Ǹ� ������ ������ �߻��Ѵ�.
}
