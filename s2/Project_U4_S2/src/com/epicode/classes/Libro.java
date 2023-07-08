package com.epicode.classes;

import com.epicode.enums.Genere;
import com.epicode.enums.Periodicità;

public class Libro extends ElementoLetterario {

	private String autore;
	private Genere genere;
	
	public Libro(String isbn, String titolo, Integer annoPubblicazione, Integer numeroPagine, String autore, Genere genere) {
		super(isbn, titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}


	

	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + ", isbn=" + isbn + ", titolo=" + titolo
				+ ", annoPubblicazione=" + annoPubblicazione + ", numeroPagine=" + numeroPagine + "]";
	}

	
	

}
