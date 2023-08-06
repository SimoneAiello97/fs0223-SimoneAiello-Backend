package com.epicode.Spring1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.Spring1.models.Utente;

@Repository
public interface IUtenteDAO extends CrudRepository<Utente, Long> {
	public Utente findByEmail(String email);
	public Utente findByUsername(String username);
}
