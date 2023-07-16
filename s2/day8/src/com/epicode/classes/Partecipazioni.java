package com.epicode.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.epicode.Enum.Stato;
@Entity
@Table(name = "partecipazioni")
public class Partecipazioni {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	@OneToOne
	Persona persona;
	
	Evento evento;
	
	Stato stato;
	
}
