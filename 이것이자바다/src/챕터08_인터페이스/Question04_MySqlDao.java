package é��08_�������̽�;

public class Question04_MySqlDao implements Question04_DataAccessObject {
	@Override
	public void select() {
		System.out.println("MySql DB���� �˻�");	
	}
	
	@Override
	public void insert() {
		System.out.println("MySql DB�� ����");	
	}
	
	@Override
	public void update() {
		System.out.println("MySql DB�� ����");	
	}
	
	@Override
	public void delete() {
		System.out.println("MySql DB���� ����");	
	}
}
