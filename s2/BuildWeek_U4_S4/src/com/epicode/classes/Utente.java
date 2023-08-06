package com.epicode.classes;

import javax.persistence.*;

@Entity
public class Utente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
protected long id;
protected String nome;
protected String cognome;

//OneToOne
// Tessera

//OneToMany
//Lista Biglietti

// Costruttore vuoto
public Utente() {}

// Costruttore con nome e cognome
public Utente(String nome, String cognome) {
	this.nome = nome;
	this.cognome = cognome;
}

// Metodi Get di nome e cognome
public String getNome() {
	return nome;
}
public String getCognome() {
	return cognome;
}
// Metodo toString
@Override
public String toString() {
	return "Utente [nome= " + nome + ", cognome= " + cognome + "]";
}



}
