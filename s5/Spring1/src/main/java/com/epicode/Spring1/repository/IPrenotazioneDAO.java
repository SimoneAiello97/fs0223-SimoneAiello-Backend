package com.epicode.Spring1.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epicode.Spring1.models.Prenotazione;
import com.epicode.Spring1.models.Utente;

@Repository
public interface IPrenotazioneDAO extends CrudRepository<Prenotazione, Long>{
	
	public List<Prenotazione> findByData(LocalDate data);
	
	//Mi creo una query personalizzata per controllare se il singolo utente ha prenotato per la singola data
	//Ho utilizzate CASE per creare una valutazione condizionale che mi restituisse true/false
	@Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM Prenotazione p WHERE p.utente = :utente AND p.data = :data")
	boolean haPrenotatoPerData(@Param("utente") Utente utente, @Param("data") LocalDate data);

}
