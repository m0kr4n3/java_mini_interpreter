package src;

public class SyntaxeException extends Exception {
	@Override
	public String getMessage() {
		return "Erreur : Nom de variable erroné.";
	}
}
