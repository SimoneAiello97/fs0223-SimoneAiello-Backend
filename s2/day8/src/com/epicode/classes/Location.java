package com.epicode.classes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
	long id; 
	@Column(name = "nome", nullable = false)
	String nome;
	@Column(name = "citta", nullable = false)
	String citta;
	
	@OneToMany(mappedBy = "location")
    private List<Evento> eventsInLocation;
	
	public Location() {
		super();
	}
	
	public Location(String nome, String citta) {
		this.nome = nome;
		this.citta = citta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	@Override
	public String toString() {
		return "Location [nome=" + nome + ", citta=" + citta + ", getId()=" + getId() + "]";
	}
	
	

	
	
	
}
