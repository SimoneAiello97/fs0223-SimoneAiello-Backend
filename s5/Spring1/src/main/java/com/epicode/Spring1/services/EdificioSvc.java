package com.epicode.Spring1.services;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.Spring1.models.Edificio;
import com.epicode.Spring1.repository.IEdificioDAO;

@Service
public class EdificioSvc {
	@Autowired IEdificioDAO repo;
	
	//Indico quale esatta istanza di bean dovrebbe essere iniettata nel campo edificioProvider
	@Autowired 
	@Qualifier("edificioBean") 
	private ObjectProvider<Edificio> edificioProvider;
	
	public Edificio creaEdificio(String nome, String indirizzo, String citta) {
		return edificioProvider.getObject().builder()
				.nome(nome).indirizzo(indirizzo).citta(citta).build();
	}
	
	//CRUD
	
	public void createEdificioDB(Edificio e) {
		repo.save(e);
	}
	
	public Edificio readEdificioDB(long id) {
		return repo.findById(id).get();
	}
	
	public void updateEdificioDB(Edificio e) {
		repo.save(e);
	}
	
	public void deleteEdificioDB(Edificio e) {
		repo.delete(e);
	}
	
	//Metodo che mi restituisce la lista di tutti gli edifici salvati nel DB
	
	public List<Edificio> AllEdificiDB() {
		return (List<Edificio>) repo.findAll();
	}
	
	public Edificio cercaPerIndirizzo(String indirizzo) {
		return repo.findByIndirizzo(indirizzo);
	}
	
	

	

}
