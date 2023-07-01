package com.day2;

import java.sql.Date;

public class Cliente {
	 	public String codiceCliente;
	 	public String nomeCognome;
	 	public String email;
	 	public Date dataIscrizione;

	    public Cliente(String codiceCliente, String nomeCognome, String email, Date dataIscrizione) {
	        this.codiceCliente = codiceCliente;
	        this.nomeCognome = nomeCognome;
	        this.email = email;
	        this.dataIscrizione = dataIscrizione;
	    }
}
