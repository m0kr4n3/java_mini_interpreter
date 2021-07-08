package com.src.TP_POO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.src.TP_POO.ParentheseFermanteManquanteException;
import com.src.TP_POO.ParentheseOuvranteManquanteException;

public class Expression{
	private String expression;

	public Expression(String expression){
		this.expression=expression;
	}

	public String getExpression(){	return this.expression;}
	
	public ArrayList<String> turnToPostFixed() throws	ParentheseFermanteManquanteException,
								ParentheseOuvranteManquanteException,
								OperandeManquantException
	{
		Deque<String> operators = new LinkedList<String>();
		ArrayList<String> postfix = new ArrayList<String>();

		this.expression = this.expression.replace	(" ", "");
		String[] arrOfStr = this.expression.split("((?<=\\+|-|\\*|/|sqrt|cos|sin|tan|abs|log|\\(|\\))|(?=\\+|-|\\*|/|sqrt|cos|sin|tan|abs|log|\\(|\\)))");
		ArrayList<String> arrList = new ArrayList<String>(Arrays.asList(arrOfStr));
		String corrected = plusMoinsRegle(arrList);
		arrOfStr = corrected.split("((?<=\\+|-|\\*|/|sqrt|cos|sin|tan|abs|log|\\(|\\))|(?=\\+|-|\\*|/|sqrt|cos|sin|tan|abs|log|\\(|\\)))");
		arrList = new ArrayList<String>(Arrays.asList(corrected));
		
		int stackPrecedence			=-1;
		int currentPrecedence			=0;
		int currentNumberOfOperands		=0;
		int numberOfStackedOpeninParenthesis 	=0;

		for (String string : arrOfStr) {
		//	lets turn it to postfixed

			if(isOperator(string)==0){//	
				postfix.add(string);

				currentNumberOfOperands+=1;
			}
			if(isOperator(string)>0 && !string.equals("(") && !string.equals(")")){
				if(operators.isEmpty() || isOperator(operators.peek())==4){
					operators.push(string);
				}else if(isOperator(string)>isOperator(operators.peek())){
					operators.push(string);
				}else{
					while(!operators.isEmpty() && isOperator(operators.peek())<=isOperator(string)){

						if((isOperator(operators.peek())==1 || isOperator(operators.peek())==2) && currentNumberOfOperands<2) throw new OperandeManquantException();
						if(isOperator(operators.peek())==1 /**&& currentNumberOfOperands>1**/){	
							currentNumberOfOperands-=1;}
						else if(/**(isOperator(topOp)==1 && currentNumberOfOperands<2) ||**/ isOperator(operators.peek())==3){	
							currentNumberOfOperands-=0;}
						else if(isOperator(operators.peek())==2){				
							currentNumberOfOperands-=1;}
					
						if(currentNumberOfOperands<0)	throw new OperandeManquantException();
						
						
						postfix.add(operators.pop());

					}

					operators.add(string);
				}
			}else if(isOperator(string)==4){
				operators.push(string);
				++numberOfStackedOpeninParenthesis;
			}else if(isOperator(string)==5){
				if(!operators.isEmpty()){
					String topOp = operators.pop();
					while(isOperator(topOp)!=4){
						postfix.add(topOp);

						if(operators.isEmpty())	throw new ParentheseOuvranteManquanteException();

						if((isOperator(topOp)==1 || isOperator(topOp)==2) && currentNumberOfOperands<2) throw new OperandeManquantException();
						if(isOperator(topOp)==1 /**&& currentNumberOfOperands>1**/){	
							currentNumberOfOperands-=1;}
						else if(/**(isOperator(topOp)==1 && currentNumberOfOperands<2) ||**/ isOperator(topOp)==3){	
							currentNumberOfOperands-=0;}
						else if(isOperator(topOp)==2){				
							currentNumberOfOperands-=1;}

						if(currentNumberOfOperands<0)	throw new OperandeManquantException();
						

						topOp = operators.pop();
					}
					if(!operators.isEmpty() && isOperator(operators.peek())==3){

						if((isOperator(operators.peek())==1 || isOperator(operators.peek())==2) && currentNumberOfOperands<2)throw new OperandeManquantException();
						if(isOperator(operators.peek())==1 /**&& currentNumberOfOperands>1**/){	
							currentNumberOfOperands-=1;}
						else if(/**(isOperator(topOp)==1 && currentNumberOfOperands<2) ||**/ isOperator(operators.peek())==3){	
							currentNumberOfOperands-=0;}
						else if(isOperator(operators.peek())==2){				
							currentNumberOfOperands-=1;}

						if(currentNumberOfOperands<0)	throw new OperandeManquantException();


						postfix.add(operators.pop());}

					--numberOfStackedOpeninParenthesis;
				}else{	throw new ParentheseOuvranteManquanteException();}
			}
			// System.out.println(currentNumberOfOperands+ " outter");
			// System.out.println(operators + "operators");
		}

		if(numberOfStackedOpeninParenthesis>0)	throw	new ParentheseFermanteManquanteException();

		while(!operators.isEmpty()){
			if((isOperator(operators.peek())==1 || isOperator(operators.peek())==2) && currentNumberOfOperands<2) throw new OperandeManquantException();
			if(isOperator(operators.peek())==1 /**&& currentNumberOfOperands>1**/){	
				currentNumberOfOperands-=1;}
			else if(/**(isOperator(topOp)==1 && currentNumberOfOperands<2) ||**/ isOperator(operators.peek())==3){	
				currentNumberOfOperands-=0;}
			else if(isOperator(operators.peek())==2){				
				currentNumberOfOperands-=1;}

			if(currentNumberOfOperands<0)	throw new OperandeManquantException();
			
			postfix.add(operators.pop());
		}

		return postfix;
		
	}

	private String plusMoinsRegle(ArrayList<String> s){
		int count=0;
		String finale ="";
		for (String string : s) {
			if(isOperator(string)==1){
				if(count==0){
					finale = finale + "(0" + string + "1)*";
				}else if(isOperator(s.get(count-1))==4){
					finale = finale + "(0" + string + "1)*";
				}else if(isOperator(s.get(count-1))==2){
					finale = finale + "(0" + string + "1)*";
				}else if(isOperator(s.get(count-1))==1){
					finale = finale + "(0" + string + "1)*";
				}
			}else{
				finale = finale + string;
			}
			count++;
		}
		return finale;
	}

	//	retourne le niveau de precedence de l'operateur
	//	ou -1 si ce n'est pas un operateur
	static public int isOperator(String op){
		if(	op.equals("+") 		||
			op.equals("-") 		)	return 1;
		if(	op.equals("/") 		||
			op.equals("*") 		)	return 2;
		if(	op.equals("sin") 	||
			op.equals("cos") 	||
			op.equals("log") 	||
			op.equals("abs")	||
			op.equals("sqrt") 	||
			op.equals("tan"))		return 3;
		if(	op.equals("("))			return 4;
		if(	op.equals(")"))			return 5;	

		return 0;
	}



}
