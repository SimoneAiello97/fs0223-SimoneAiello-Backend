package com.epicode.classes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.epicode.Enum.Sesso;
@Entity
@Table(name = "persone")

public class Persona {
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
	 long id;
	@Column(name = "nome", nullable = false)
	 String nome;
	@Column(name = "cognome", nullable = false)
	 String cognome;
	@Column(name = "email", nullable = false)
	 String email;
	@Column(name = "date", nullable = false)
	 Date dataDiNascita;
	@Enumerated(EnumType.STRING)
	 Sesso sesso;
	
	@ManyToMany(mappedBy = "people")
    @OrderBy("events")
    private List<Evento> events;
	
	 
	 
	public Persona() {
		super();
	}


	public Persona(String nome, String cognome, String email, Date dataDiNascita, Sesso sesso) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;
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


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDataDiNascita() {
		return dataDiNascita;
	}


	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}


	public Sesso getSesso() {
		return sesso;
	}


	public void setSesso(Sesso sesso) {
		this.sesso = sesso;
	}


	public List<Evento> getLista() {
		return events;
	}


	public void setLista(List<Evento> lista) {
		this.events = lista;
	}


	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", dataDiNascita="
				+ dataDiNascita + ", sesso=" + sesso + ", lista=" + events + ", getId()=" + getId() + "]";
	}
	 
	 
	 

}
