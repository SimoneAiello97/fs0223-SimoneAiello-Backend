package com.epicode.classes;

import java.time.LocalDate;

import javax.persistence.*;
@Entity
public abstract class CartaDaViaggio {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private LocalDate dataEmissione;
 
@ManyToOne
private RivenditoreAutorizzato rivenditoreAutorizzato;


public CartaDaViaggio() {}


public CartaDaViaggio(LocalDate dataEmissione, RivenditoreAutorizzato rivenditoreAutorizzato) {
	super();
	this.dataEmissione = dataEmissione;
	this.rivenditoreAutorizzato = rivenditoreAutorizzato;
}


}
