package é��10_����ó��;

public class ��_HandlingCodeAccordingToExceptionType {
			// Multiple catch ���� catch

	// try ��� ���δ� �پ��� ������ ���ܰ� �߻��� �� �ִ�. �� ���, �߻��Ǵ� ���ܺ��� ���� ó�� �ڵ带 �ٸ��� �Ϸ��� ��� �ؾ� �ұ�? �̰Ϳ� ���� �ش��� ���� catch ����� �ۼ��ϴ� ���̴�.
	// catch ����� ���� Ŭ���� Ÿ���� try ��Ͽ��� �߻��� ������ ������ ���ϴµ�, try ��Ͽ��� �ش� Ÿ���� ���ܰ� �߻��ϸ� catch ����� �����ϵ��� �Ǿ� �ִ�.
	
	//	try {
	//		ArrayIndexOutOfBoundsException �߻�			��
	//													��
	//		NumberFormatException �߻�	(x)				��
	//													��
	//	} catch(ArrayIndexOutOfBoundsException e) {	�禡������
	//		���� ó��1
	//	} catch(NumberFormatException e) {
	//		���� ó��2
	//	}
	
	// catch ����� ���� ���� ������ �� �ϳ��� catch ��ϸ� �����Ѵ�. �� ������ try ��Ͽ��� ���� �ٹ������� ���ܰ� �߻����� �ʰ�,
	// �㳪�� ���ܰ� �߻��ϸ� ��� ������ ���߰� �ش� catch ������� �̵��ϱ� �����̴�. �׷� ���� ������ ���캸��
	
			//	Procedure catch		catch ����
	
	// ���� catch ����� �ۼ��� �� ������ ���� ���� ���� Ŭ������ ���� ���� Ŭ�������� �Ʒ��ʿ� ��ġ�ؾ� �Ѵ�.
	// try ��Ͽ��� ���ܰ� �߻����� ��, ���ܸ� ó������ catch ����� ���������� ���ʴ�� �˻��ȴ�. ���� ���� ���� Ŭ������ catch ����� ���� �ִٸ�, ���� ���� Ŭ������ catch ����� ������� �ʴ´�.
	// ���� ������ �ڵ��� �߸��� ���̴�.
	
	//	try {
	//
	//		ArrayIndexOutOfBoundsException �߻�			��
	//													��
	//		NumberFormatException �߻�					��
	//													��
	//	} catch(Exception e) {					�禡��������������
	//		���� ó��1
	//	} catch(ArrayIndexOutOfBoundsException e) {		// ������� ����
	//		���� ó��2
	//	}
	
	// ArrayIndexOutOfBoundsException�� NumberFormatException�� ��� Exception�� ��ӹޱ� ������ ù ��° catch ��ϸ� ���õǾ� ����ȴ�.
	// �� ��° catch ����� � ��쿡�� ������� �ʴ´�. �� �ڵ�� ������ ���� �����ؾ� �Ѵ�.
	
	//	try {
	//
	//		ArrayIndexOutOfBoundsException �߻�			��	
	//													��
	//		NumberFormatException �߻�					��
	//													��
	//	} catch(ArrayIndexOutOfBoundsException e) {	�禡������
	//		���� ó��1
	//	} catch(Exception e) {		
	//		���� ó��2
	//	}
	
	// try ��Ͽ��� ArrayIndexOutOfBoundsException�� �߻��ϸ� ù ���� catch ����� �����ϰ�, �� ���� �ٸ� ���ܰ� �߻��ϸ� �� ��° catch ����� �����Ѵ�.
	
			//	Multiple catch		��Ƽ catch
	
	// �ڹ� 7 ���� �ϳ��� catch ��Ͽ��� ���� ���� ���ܸ� ó���� �� �ֵ��� ��Ƽ catch ����� �߰��ߴ�.
	// ������ ��Ƽ catch ����� �ۼ��ϴ� ����� �����ش�. catch ��ȣ() �ȿ� �����ϰ� ó���ϰ� ���� ���ܸ� |�� �����ϸ� �ȴ�.
	
	//	try {
	//	
	//		ArrayIndexOutOfBoundsException �Ǵ� NumberFormatException �߻�			��
	//																			��
	//		�ٸ� Exception �߻�														��
	//																			��
	//	} catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {	�禡������
	//		���� ó��1
	//	} catch(Exception e) {
	//		���� ó��2
	// }
}
