package com.src.TP_POO;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

abstract class Commande extends Symbole{
	public Commande(String nom){
		super(nom);
	}

	public double InterpreterExpression(String expression,TableDesSymboles tabSymb) throws IncorrectOperandeException,DivisionParZeroException,SymboleNonTrouveException{

		Expression exp = new Expression(expression);

		try{
			ArrayList<String> expPostFixe = exp.turnToPostFixed();
			Deque<Double> vars = new LinkedList<Double>();

			//	Traitement de l'expression qui est en postfix
			for (String string : expPostFixe) {
				if(Utils.isNumeric(string))	vars.push( Double.parseDouble(string));	
				//	is an operand
				else if(Expression.isOperator(string)==0){
					//	la recherche dans la table des symboles
					Symbole symb;

					try{
						System.out.println("avant");

						symb = tabSymb.readSymbole(string);

						if(symb==null)			throw new SymboleNonTrouveException(string);
						if(!(symb instanceof Variable))	throw new IncorrectOperandeException();

						vars.push( ((Variable) symb).getValeur() );

					}catch(Exception e){
						System.out.println(e.getMessage());
					}


				}
				//	is an operator
				else if(Expression.isOperator(string)>0){
					//	depends if operator is unary or binary
					//	auquels cas on depile 2 operande ou 1 operande
					if(Expression.isOperator(string)==1 || Expression.isOperator(string)==2){
						
						double v1 = vars.pop();
						double v2 = vars.pop();
						switch(string){
							case "+" :
								vars.push(v2+v1);
								break;
							case "-" :
								vars.push(v2-v1);
								break;
							case "/" :
								if(v1==0)	throw new DivisionParZeroException();
								vars.push(v2/v1);
								break;
							case "*" :
								vars.push(v2*v1);
								break;
						}
					}else{
						Symbole symb;

						try{
							symb = tabSymb.readSymbole(string.trim());
							double varia = vars.pop();
							vars.push(((Fonction)symb).excec(varia));
	
						}catch(Exception e){
							System.out.println(e.getMessage());
						}		
					}
				}
			
			}

			return vars.pop();

		}catch(Exception e){
			System.out.println(e.getMessage());
		}

		return 0;		
	}

	abstract protected void exec (String str,TableDesSymboles tabSymb) throws TooMuchArgumentsException,ParentheseFermanteManquanteException,ParentheseOuvranteManquanteException,OperandeManquantException,SigneEgalManquantException;
}