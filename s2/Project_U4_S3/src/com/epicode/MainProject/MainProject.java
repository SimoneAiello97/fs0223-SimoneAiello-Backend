package com.epicode.MainProject;

import java.sql.Date;
import java.sql.SQLException;

import com.epicode.DataAccessObject.LibroDAO;
import com.epicode.DataAccessObject.PrestitoDAO;
import com.epicode.DataAccessObject.RivistaDAO;
import com.epicode.DataAccessObject.UtenteDAO;
import com.epicode.Enum.Genere;
import com.epicode.Enum.Periodicita;
import com.epicode.classes.Libro;
import com.epicode.classes.Prestito;
import com.epicode.classes.Rivista;
import com.epicode.classes.Utente;

public class MainProject {

	public static void main(String[] args) throws SQLException {
		LibroDAO LibroDAO = new LibroDAO();
		RivistaDAO RivistaDAO = new RivistaDAO();
		UtenteDAO UtenteDAO = new UtenteDAO();
		PrestitoDAO PrestitoDAO = new PrestitoDAO();
		Libro l1 = new Libro("Il piccolo Principe", 1943,90,"Antoine de Saint-Exupéry", Genere.ROMANZO);
		//LibroDAO.save(l1);
		//LibroDAO.getByAnnoPubblicazione(1943);
		//LibroDAO.getByAutore("Antoine de Saint-Exupéry");
		//LibroDAO.getByTitolo("piccolo");
		Rivista r1 = new Rivista("Vogue", 1892,150, Periodicita.MENSILE );
		//RivistaDAO.save(r1);
		//RivistaDAO.getByAnnoPubblicazione(1892);
		//RivistaDAO.getByTitolo("og");
		Date dataDiNascita = new Date(90, 6, 16);
		Utente u1 = new Utente("Mario","Rossi", dataDiNascita, 123l);
		//UtenteDAO.save(u1);
		//UtenteDAO.getById(1);
		Date dataInizioPrestito = new Date(99, 5, 6);
		Prestito p1 = new Prestito(u1,l1, dataInizioPrestito);
		//PrestitoDAO.save(p1);
	}

}
