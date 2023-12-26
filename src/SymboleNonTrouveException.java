package src;

public class SymboleNonTrouveException extends Exception {

	private String symb="";

	public SymboleNonTrouveException(String symb){
		this.symb=symb;
	}

	@Override
	public String getMessage() {
		return "Erreur : variable "+ this.symb +" non déclarée";
	}
}
