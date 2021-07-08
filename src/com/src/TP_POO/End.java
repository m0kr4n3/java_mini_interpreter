package com.src.TP_POO;

public class End extends Commande{
	public End(String nom) {
		super(nom);
	}
	@Override
	protected void exec(String str, TableDesSymboles tabSymb)
			throws TooMuchArgumentsException, ParentheseFermanteManquanteException,
			ParentheseOuvranteManquanteException, OperandeManquantException, SigneEgalManquantException {
		
	}
}
