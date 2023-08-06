package com.epicode.Spring1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.Spring1.models.Edificio;

@Repository
public interface IEdificioDAO extends CrudRepository<Edificio, Long> {

	public Edificio findByIndirizzo(String indirizzo);
}
