package com.epicode.Spring1.services;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.Spring1.models.Utente;
import com.epicode.Spring1.repository.IUtenteDAO;

@Service
public class UtenteSvc {
	@Autowired IUtenteDAO repo;
	
	@Autowired
	@Qualifier("utenteBean")
	private ObjectProvider<Utente> utenteProvider;
	
	public Utente creaUtente(String username, String nome, String cognome, String email) {
		return utenteProvider.getObject().builder()
				.username(username).nome(nome).cognome(cognome).email(email).build();
		}
	
	//CRUD
	
	public void createUtenteDB(Utente e) {
		repo.save(e);
	}
	
	public Utente readUtenteDB(long id) {
		return repo.findById(id).get();
	}
	
	public void updateUtenteDB(Utente e) {
		repo.save(e);
	}
	
	public void deleteUtenteDB(Utente e) {
		repo.delete(e);
	}
	
	//Metodo che mi restituisce la lista di tutti gli utenti salvati nel DB
	
	public List<Utente> AllUtentiDB() {
		return (List<Utente>) repo.findAll();
	}
	
	public Utente cercaPerUsername(String username) {
		return repo.findByUsername(username);
	}
	public Utente cercaPerEmail(String email) {
		return repo.findByEmail(email);
	}
}
