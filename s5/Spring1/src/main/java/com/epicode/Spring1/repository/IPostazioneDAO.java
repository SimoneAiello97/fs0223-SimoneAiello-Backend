package com.epicode.Spring1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epicode.Spring1.models.Categoria;
import com.epicode.Spring1.models.Postazione;

@Repository
public interface IPostazioneDAO extends CrudRepository<Postazione, Long>{

	@Query("SELECT p FROM Postazione p WHERE p.categoria = :categoria")
	public List<Postazione> findByCategoria(Categoria categoria);
	
	//Ho usato UPPER dopo che un collega me l'ha consigliato... molto utile per confrontare 
	//i parametri senza considerare le differenze di maiuscole e minuscole.
	
	@Query("SELECT p FROM Postazione p WHERE UPPER(p.edificio.citta) = UPPER(:citta)")
    List<Postazione> findByCitta(@Param("citta") String citta);
	
	@Query("SELECT p FROM Postazione p WHERE p.categoria = :categoria AND UPPER(p.edificio.citta) = UPPER(:citta)")
	List<Postazione> trovaByTipoAndCitta(@Param("categoria") Categoria categoria, @Param("citta") String citta);
	
}
