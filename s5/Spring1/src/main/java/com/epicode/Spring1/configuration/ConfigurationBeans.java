package com.epicode.Spring1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.Spring1.models.Edificio;
import com.epicode.Spring1.models.Postazione;
import com.epicode.Spring1.models.Prenotazione;
import com.epicode.Spring1.models.Utente;

@Configuration
public class ConfigurationBeans {
	
	@Bean("utenteBean")
	@Scope("prototype")
	public Utente utente() {
		return new Utente();
	}
	
	@Bean("edificioBean")
	@Scope("prototype")
	public Edificio edificio() {
		return new Edificio();
	}
	
	@Bean("postazioneBean")
	@Scope("prototype")
	public Postazione postazione() {
		return new Postazione();
	}
	
	@Bean("prenotazioneBean")
	@Scope("prototype")
	public Prenotazione prenotazione() {
		return new Prenotazione();
	}
}
