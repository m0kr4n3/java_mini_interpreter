package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Let extends Commande {
	public Let(String nom) {
		super(nom);
	}

	@Override
	protected void exec(String str, TableDesSymboles tabSymb) throws	TooMuchArgumentsException,
										ParentheseFermanteManquanteException,
										ParentheseOuvranteManquanteException,
										OperandeManquantException,
										SigneEgalManquantException,
										SecondMembreManquantException
		{
		
		if (str.trim().isEmpty())
			throw new SecondMembreManquantException();
		
		String[] strArr = str.trim().split("=");
		List<String> arrl = Arrays.asList(strArr);
		if(arrl.size()<2)	throw new SigneEgalManquantException();
		
		try {
			double result = this.InterpreterExpression(arrl.get(1).trim(), tabSymb);

			tabSymb.addOrUpdateSymbole(new Variable(arrl.get(0).trim(),result,tabSymb));
			System.out.println("Ok : " + result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
