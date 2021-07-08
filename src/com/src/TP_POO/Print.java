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
		if(str.trim().isEmpty())	throw new SecondMembreManquantException();

		try {
			double result = this.InterpreterExpression(str.trim(), tabSymb);

			System.out.println("La valeur est : " + result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}