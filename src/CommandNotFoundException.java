package src;

public class CommandNotFoundException extends Exception {
	@Override
	public String getMessage() {
		return "Commande non trouvée.";
	}
}
