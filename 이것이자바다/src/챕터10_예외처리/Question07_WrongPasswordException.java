package 챕터10_예외처리;

public class Question07_WrongPasswordException extends Exception{
	public Question07_WrongPasswordException() {}
	public Question07_WrongPasswordException(String message) {
		super(message);
	}
}
