package com.epicode.Spring1.services;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.Spring1.models.Categoria;
import com.epicode.Spring1.models.Edificio;
import com.epicode.Spring1.models.Postazione;
import com.epicode.Spring1.repository.IPostazioneDAO;

@Service
public class PostazioneSvc {
@Autowired IPostazioneDAO repo;
	
	@Autowired
	@Qualifier("postazioneBean")
	private ObjectProvider<Postazione> postazioneProvider;
	
	public Postazione creaPostazione(String descrizione, Categoria categoria, Integer massimoPosti, Edificio edificio) {
		return postazioneProvider.getObject().builder()
				.descrizione(descrizione)
				.categoria(categoria)
				.massimoPosti(massimoPosti)
				.edificio(edificio)
				.build();
	}
	
	//CRUD
	
	public void createPostazioneDB(Postazione e) {
		repo.save(e);
	}
	
	public Postazione readPostazioneDB(long id) {
		return repo.findById(id).get();
	}
	
	public void updatePostazioneDB(Postazione e) {
		repo.save(e);
	}
	
	public void deletePostazioneDB(Postazione e) {
		repo.delete(e);
	}
	
	//Metodo che mi restituisce la lista di tutti gli postazioni salvati nel DB
	
	public List<Postazione> AllPostazioniDB() {
		return (List<Postazione>) repo.findAll();
	}
	
	public List<Postazione> cercaPerCategoria(Categoria categoria) {
		return repo.findByCategoria(categoria);
	}
	public List<Postazione> cercaPerCitta(String citta) {
		return repo.findByCitta(citta);
	}
	public List<Postazione> cercaPerCategoriaPerCitta(Categoria categoria,String citta) {
		return repo.trovaByTipoAndCitta(categoria, citta);
	}
}
