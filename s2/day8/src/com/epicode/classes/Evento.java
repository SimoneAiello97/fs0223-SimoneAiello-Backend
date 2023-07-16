package com.epicode.classes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.epicode.Enum.TipoEvento;

@Entity
@Table(name = "events")
public class Evento {
	
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
	long id;
	@Column(name = "title", nullable = false)
	String title;
	@Column(name = "date", nullable = false)
	LocalDate eventDate;
	@Column(name = "description", nullable = false)
	String description;
	@Enumerated(EnumType.STRING)
	TipoEvento tipoEvento;
	@Column(name = "attendees", nullable = false)
	int attendees;
	
	@ManyToOne(cascade = CascadeType.ALL)
    private Location location;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Persona> people;
	
	
	

	public Evento() {
		super();
	}

	public Evento(String title, LocalDate eventDate, String description, TipoEvento tipoEvento, int attendees, Location location) {
		this.title = title;
		this.eventDate = eventDate;
		this.description = description;
		this.tipoEvento = tipoEvento;
		this.attendees = attendees;
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public int getAttendees() {
		return attendees;
	}

	public void setAttendees(int attendees) {
		this.attendees = attendees;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", title=" + title + ", eventDate=" + eventDate + ", description=" + description
				+ ", tipoEvento=" + tipoEvento + ", attendees=" + attendees + "]";
	}
	

}
