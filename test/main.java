package com.test;
import java.lang.Math;


interface myInter{
	public double doSmth(double param);
}

class Fonction{
	myInter func;
	
	Fonction(){}
	Fonction(myInter func){
		this.func=func;
	}

	public double exec(double p1){	return this.func.doSmth(p1);}
}

public class lol {

	public static void main(String[] args) {
		//	gotta wrap theme in an interface lol
		Fonction obj = new Fonction(Math::cos);

		System.out.println(obj.exec(Math.PI));
	}
}