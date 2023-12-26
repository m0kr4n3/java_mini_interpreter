package src;

public class TooMuchArgumentsException extends Exception{
	@Override
	public String getMessage() {
		return "Trop D'arguements entrés.";
	}
}
