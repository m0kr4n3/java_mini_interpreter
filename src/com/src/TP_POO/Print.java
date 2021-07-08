package com.src.TP_POO;

class Print extends Commande{
	public Print(String nom){
		super(nom);
	}

	//	s'occupe de verifier la correctitude de l'expression donnée vis a vis de cette commande
	@Override
	protected void exec(String str,TableDesSymboles tabSymb) throws 	TooMuchArgumentsException,
									ParentheseFermanteManquanteException,
									ParentheseOuvranteManquanteException,
									OperandeManquantException,
									SigneEgalManquantException,
									SecondMembreManquantException 
	{
		
	}
}