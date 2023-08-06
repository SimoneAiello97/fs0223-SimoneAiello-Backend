package com.epicode.classes;

import java.time.LocalDate;

import javax.persistence.*;


public class Tessera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	private LocalDate dataAttivazione;
	private LocalDate dataScadenza;
	private boolean validita;
	
	@OneToOne
	private Utente utente;

	public Tessera(LocalDate dataAttivazione) {
		this.dataAttivazione = dataAttivazione;
		this.dataScadenza = dataAttivazione.plusDays(365);
		this.validita = true;
	}
	
	
	
	
}
