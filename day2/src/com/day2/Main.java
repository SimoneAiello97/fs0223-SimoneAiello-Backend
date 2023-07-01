package com.day2;

public class Main {

	public static void main(String[] args) {
		// Esercizio 1
		
		Rettangolo r1 = new Rettangolo(5,6);
		Rettangolo r2 = new Rettangolo(3,4);
		/*
		 * r1.stampaRettangolo(r1); 
		 * r2.stampaRettangolo(r2);
		 */
		Rettangolo.stampaDueRettangoli(r1, r2);
		
		System.out.println("----------");
		
		//Esercizio 2
		Sim s1 = new Sim(123456);
		s1.stampaSim(s1);
		
		
	}

}
