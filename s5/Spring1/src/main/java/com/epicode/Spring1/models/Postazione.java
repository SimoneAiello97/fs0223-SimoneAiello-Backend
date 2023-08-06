package com.epicode.Spring1.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name="postazioni")

public class Postazione {
	//Chiamo id quello che la traccia definisce CODICE UNIVOCO
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
    private String descrizione;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
    private Categoria categoria;
	
	@Column(nullable = false)
	private Integer massimoPosti;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Edificio edificio;
	
	@OneToMany(mappedBy = "postazione", fetch = FetchType.EAGER)
	private List<Prenotazione> prenotazioni;

	
	
	
}
