package com.day2;

import java.util.Arrays;

public class Sim {
	
	public int numero;
	public double credito;
	public Chiamata[] numeroChiamate = new Chiamata[5] ;
	
	public Sim (int numero) {
		this.numero = numero;
		this.credito = 0;
		this.numeroChiamate = new Chiamata[5] ;
	}
	
	public void chiamata(Sim a) {
			Chiamata[] x = a.numeroChiamate;
			this.numeroChiamate[0] = new Chiamata(10, "987654321");
	        this.numeroChiamate[1] = new Chiamata(5, "555555555");
	        this.numeroChiamate[2] = new Chiamata(8, "111111111");
	        this.numeroChiamate[3] = new Chiamata(3, "999999999");
	        this.numeroChiamate[4] = new Chiamata(7, "777777777");
	        
			for (int i = 0; i < x.length; i++) {
				System.out.println("Durata: " + x[i].durata + ", Numero chiamato: " + x[i].numeroChiamato);
			};
	}
	
	public static void stampaSim(Sim a) {
		System.out.println("Numero di telefono: " + a.numero);
		System.out.println("Credito residuo: " + a.credito + " €");
		a.chiamata(a);
	}
	

}
