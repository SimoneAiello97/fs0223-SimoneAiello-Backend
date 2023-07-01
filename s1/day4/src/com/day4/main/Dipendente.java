/**
 * 
 */
package com.day4.main;

/**
 * 
 */
public class Dipendente {
	static int stipendioBase = 1000;
	private int matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello livello;
	private Dipartimento dipartimento;
	
	// Costruttore 1
	public Dipendente(int matricola, Dipartimento dipartimento){
		this.matricola = matricola;
		this.dipartimento = dipartimento;
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = 30;
		this.livello = Livello.OPERAIO;
	}
	
	//Costruttore 2
	public Dipendente(int matricola, int stipendio, double importoOrarioStraordinario, Livello livello, Dipartimento dipartimento){
		this.matricola = matricola;
		this.stipendio = stipendio + stipendioBase;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
	}
	
	// Override per Stampa
	@Override
	public String toString() {
		return "Dipendente: [matricola = " + matricola + ", dipartimento = " + dipartimento + ", stipendio = " + stipendio + ", livello ="
				+ livello + "]";
	}
	
	// Metodo promuovi
	public static void promuovi(Dipendente a) {
		if(a.livello == Livello.OPERAIO) {
			a.livello = Livello.IMPIEGATO;
			a.stipendio = stipendioBase * 1.2;
			
		}
		else if (a.livello == Livello.IMPIEGATO) {
			a.livello = Livello.QUADRO;
			a.stipendio = stipendioBase * 1.5;
		}
		else if (a.livello == Livello.QUADRO) {
			a.livello = Livello.DIRIGENTE;
			a.stipendio = stipendioBase * 2;
		}
	}
	
	//Metodo Calcola paga
	public static void calcolaPaga(Dipendente a){
		double paga =  a.stipendio;
		System.out.println(paga);
	}
	//Metodo Calcola paga extra
	public static double calcolaPagaStraordinario(Dipendente a, int ore){
		double paga =  a.stipendio + (a.importoOrarioStraordinario*ore) ;
		return paga;
	}
	
	//Metodi Get e Set
	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}
	
	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}
	
	public Dipartimento getDipartimento() {
		return dipartimento;
	}
	
	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}
	
	public static int getStipendioBase() {
		return stipendioBase;
	}
	
	public int getMatricola() {
		return matricola;
	}
	
	public double getStipendio() {
		return stipendio;
	}
	
	public Livello getLivello() {
		return livello;
	}
	
}
