package com.src.TP_POO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Let extends Commande {
	public Let(String nom) {
		super(nom);
	}

	@Override
	protected void exec(String str, TableDesSymboles tabSymb)
			throws TooMuchArgumentsException, ParentheseFermanteManquanteException,
			ParentheseOuvranteManquanteException, OperandeManquantException, SigneEgalManquantException {

				System.out.println("llllllllllll");
		if (str.trim().isEmpty())
			throw new SigneEgalManquantException();
		String[] strArr = str.trim().split(" ",3);
		List<String> arrl = Arrays.asList(strArr);

		for (String string : arrl) {
			if (string.equals(" "))
				arrl.remove(string);
		}

		if (strArr.length > 0 && !(arrl.get(1).equals("=")))
			throw new SigneEgalManquantException();
		if (arrl.size() == 1 || arrl.size()==2)
			throw new OperandeManquantException();
		if (arrl.size() > 3)
			throw new TooMuchArgumentsException();
		if (arrl.size() == 3) {

			System.out.println("ssdqsdqs");
			try {
				double result = this.InterpreterExpression(arrl.get(2).trim(), tabSymb);

				tabSymb.addOrUpdateSymbole(new Variable(arrl.get(0),result,tabSymb));
				System.out.println("Ok : " + result);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
