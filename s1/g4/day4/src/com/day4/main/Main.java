package com.day4.main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dipendente a = new Dipendente(1, Dipartimento.PRODUZIONE);
		Dipendente b = new Dipendente(2, Dipartimento.PRODUZIONE);
		Dipendente c = new Dipendente(3, 50, 0, Livello.IMPIEGATO, Dipartimento.AMMINISTRAZIONE);
		Dipendente d = new Dipendente(4, 100, 0, Livello.DIRIGENTE, Dipartimento.VENDITE);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
			System.out.println("-----------------");
		
		Dipendente.promuovi(b);
		Dipendente.promuovi(c);
		System.out.println(b);
		System.out.println(c);
		
			System.out.println("-----------------");
		
		System.out.println(Dipendente.calcolaPagaStraordinario(a, 5) + Dipendente.calcolaPagaStraordinario(b, 5)+ Dipendente.calcolaPagaStraordinario(c, 5)+ Dipendente.calcolaPagaStraordinario(d, 5) );
	}

}
