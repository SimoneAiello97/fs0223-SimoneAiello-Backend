package com.epicode.Spring1.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.Spring1.models.Postazione;
import com.epicode.Spring1.models.Prenotazione;
import com.epicode.Spring1.models.Utente;
import com.epicode.Spring1.repository.IPrenotazioneDAO;

@Service
public class PrenotazioneSvc {
@Autowired IPrenotazioneDAO repo;
	
	@Autowired
	@Qualifier("prenotazioneBean")
	private ObjectProvider<Prenotazione> prenotazioneProvider;
	
	public Prenotazione creaPrenotazione(LocalDate data, Utente utente, Postazione postazione) {
		return prenotazioneProvider.getObject().builder()
				.data(data).utente(utente).postazione(postazione)
				.build();
	}
	
	//CRUD
	
	public void createPrenotazioneDB(Prenotazione e) {
		repo.save(e);
	}
	
	public Prenotazione readPrenotazioneDB(long id) {
		return repo.findById(id).get();
	}
	
	public void updatePrenotazioneDB(Prenotazione e) {
		repo.save(e);
	}
	
	public void deletePrenotazioneDB(Prenotazione e) {
		repo.delete(e);
	}
	
	//Metodo che mi restituisce la lista di tutti le prenotazioni salvate nel DB
	
	public List<Prenotazione> AllprenotazioniDB() {
		return (List<Prenotazione>) repo.findAll();
	}
	
	public List<Prenotazione> cercaPerData(LocalDate data){
		return repo.findByData(data);
	}
	
	public boolean haPrenotatoPerData(Utente utente, LocalDate data){
		return repo.haPrenotatoPerData(utente, data);
	}
}
