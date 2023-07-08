package com.epicode.classes;

import com.epicode.enums.Periodicità;

public class Rivista extends ElementoLetterario{

private Periodicità periodicita;

public Rivista(String isbn, String titolo, Integer annoPubblicazione, Integer numeroPagine, Periodicità periodicita) {
	super(isbn, titolo, annoPubblicazione, numeroPagine);
	this.periodicita = periodicita;
}

public Periodicità getPeriodicita() {
	return periodicita;
}

public void setPeriodicita(Periodicità periodicita) {
	this.periodicita = periodicita;
}

@Override
public String toString() {
	return "Rivista [periodicita=" + periodicita + ", isbn=" + isbn + ", titolo=" + titolo + ", annoPubblicazione="
			+ annoPubblicazione + ", numeroPagine=" + numeroPagine + "]";
}


}
