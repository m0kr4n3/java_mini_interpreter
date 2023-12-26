package src;

public class IncorrectOperandeException extends Exception{
	@Override
	public String getMessage() {
		return "Un des operande est incorrect.";
	}
	
}
