package com.src.TP_POO;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


class Interpreteur{

	public Interpreteur(){
		
	}

	public void lancerShell(TableDesSymboles tabSymb){
		Boolean stop = false;
		
		Scanner sc = new Scanner(System.in).useDelimiter("\n");
		while(!stop){
			System.out.print("> ");

			String commandeLine = sc.nextLine();
			try{
				Commande cmd = InterpreterLigne(commandeLine,tabSymb);
				if(cmd instanceof End)	stop=true;
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		sc.close();
	}

	public Commande InterpreterLigne(String ligne,TableDesSymboles tabSymb)throws MissingArgumentException, CommandNotFoundException,TooMuchArgumentsException{
		if(ligne.trim().isEmpty())	throw new CommandNotFoundException();
		
		String[] arrOfStr = ligne.trim().split(" ",2);
		List<String> arrl = Arrays.asList(arrOfStr);

		for (String string : arrl) {
			if (string.equals(" "))
				arrl.remove(string);
		}		

		Symbole unknown = new Symbole(arrl.get(0).trim());
		Symbole cm = tabSymb.readSymbole(unknown.getNom()); 

		if(cm==null)				throw new CommandNotFoundException();//	commande non trouvée
		else if(cm instanceof End)		return (Commande)cm;
		else if(!(cm instanceof Commande))	throw new CommandNotFoundException();
		else if(arrl.size()<2)			throw new MissingArgumentException();
		else{
			//	on traite les expressions autre part
			
			try{

				((Commande)cm).exec(arrl.get(1),tabSymb);
			}
			catch(Exception e){
				System.out.print(e.getMessage());
			}
			return (Commande)cm;
		}

	
	}
}
