package com.epicode.classes;

import java.time.LocalDate;

import javax.persistence.*;

public class Biglietto extends CartaDaViaggio {
private boolean obliterato;
@ManyToOne
private Utente utente;

public Biglietto(LocalDate dataEmissione, RivenditoreAutorizzato rivenditoreAutorizzato, boolean obliterato,
		Utente utente) {
	super(dataEmissione, rivenditoreAutorizzato);
	this.obliterato = obliterato;
	this.utente = utente;
}



}
