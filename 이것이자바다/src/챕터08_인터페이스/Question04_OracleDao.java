package é��08_�������̽�;

public class Question04_OracleDao implements Question04_DataAccessObject {
	@Override
	public void select() {
		System.out.println("Oracle DB���� �˻�");
	}
	
	@Override
	public void insert() {
		System.out.println("Oracle DB�� ����");
	}
	
	@Override
	public void update() {
		System.out.println("Oracle DB�� ����");
	}
	
	@Override
	public void delete() {
		System.out.println("Oracle DB���� ����");
	}
}
