package src;

public class SigneEgalManquantException extends Exception{
	@Override
	public String getMessage() {
		return "Erreur : Signe egal Manquant";
	}
}
