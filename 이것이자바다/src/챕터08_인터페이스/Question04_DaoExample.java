package 챕터08_인터페이스;

public class Question04_DaoExample {
	public static void dbWork(Question04_DataAccessObject dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}
	
	public static void main(String[] args) {
		dbWork(new Question04_OracleDao());
		dbWork(new Question04_MySqlDao());
	}
}
