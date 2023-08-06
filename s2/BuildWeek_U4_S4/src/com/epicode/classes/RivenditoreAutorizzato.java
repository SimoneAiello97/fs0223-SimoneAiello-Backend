package com.epicode.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class RivenditoreAutorizzato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int carteDaViaggioVendute;
	private LocalDate dataEmissione;
	//protected boolean apertura;
	
	@OneToMany
	private List<CartaDaViaggio> lista = new ArrayList();

	
	
	public RivenditoreAutorizzato() {}

	public RivenditoreAutorizzato(int carteDaViaggioVendute, LocalDate dataEmissione) {
		super();
		this.carteDaViaggioVendute = carteDaViaggioVendute;
		this.dataEmissione = dataEmissione;
	}
	
	
}
