package com.epicode.MainProject;

import java.sql.SQLException;
import java.time.LocalDate;

import com.epicode.Enum.TipoEvento;
import com.epicode.classes.Evento;
import com.epicode.classes.EventoDAO;
import com.epicode.classes.Location;

public class MainProject {

	public static void main(String[] args) {
		Location l = new Location ("Alcatraz", "Milano");
		Evento a = new Evento ("comunione", LocalDate.of(2023, 7, 11), "a mioccuggino ci fa la comunione", TipoEvento.PUBBLICO, 250, l );
		Evento b = new Evento ("cresima", LocalDate.of(2023, 7, 12), "a mioccuggino ci fa la cresima", TipoEvento.PRIVATO, 80, l);
		
		try {
			EventoDAO.save(a);
			EventoDAO.save(b);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
