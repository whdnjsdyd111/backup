package 챕터10_예외처리;

public class Question07_NotExistIDException extends Exception{
	public Question07_NotExistIDException() {}
	public Question07_NotExistIDException(String message) {
		super(message);
	}
}
