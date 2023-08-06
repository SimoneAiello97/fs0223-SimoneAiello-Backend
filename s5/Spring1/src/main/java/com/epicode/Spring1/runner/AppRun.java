package com.epicode.Spring1.runner;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.Spring1.models.Categoria;
import com.epicode.Spring1.models.Edificio;
import com.epicode.Spring1.models.Postazione;
import com.epicode.Spring1.models.Prenotazione;
import com.epicode.Spring1.models.Utente;
import com.epicode.Spring1.services.EdificioSvc;
import com.epicode.Spring1.services.PostazioneSvc;
import com.epicode.Spring1.services.PrenotazioneSvc;
import com.epicode.Spring1.services.UtenteSvc;

@Component
public class AppRun implements CommandLineRunner {

	@Autowired UtenteSvc utenteSvc;
	@Autowired EdificioSvc edificioSvc;
	@Autowired PostazioneSvc postazioneSvc;
	@Autowired PrenotazioneSvc prenotazioneSvc;
	Logger log = LoggerFactory.getLogger(AppRun.class);
	Scanner input = new Scanner(System.in);
	
	@Override
	public void run(String... args) throws Exception {
		
		//Salvo degli edifici di partenza (per testarli, basta togliere i commenti)
		
		//System.out.println("Hello World");
		//Edificio e1 = edificioSvc.creaEdificio("Centro Commerciale La Galleria", "Via Roma 123", "Milano");
		//Edificio e2 = edificioSvc.creaEdificio("Biblioteca Centrale Le Sapienze", "Piazza Dante 7", "Firenze");
		//Edificio e3 = edificioSvc.creaEdificio("Ospedale Generale San Giorgio", "Via XX Settembre 45", "Torino");
		//Edificio e4 = edificioSvc.creaEdificio("Università Tecnica Politecnico Tech", "Strada Provinciale 89", "Bologna");
		//Edificio e5 = edificioSvc.creaEdificio("Teatro Municipale La Fenice", "Piazza San Marco 10", "Venezia");
			
		//edificioSvc.createEdificioDB(e1);
		//edificioSvc.createEdificioDB(e2);
		//edificioSvc.createEdificioDB(e3);
		//edificioSvc.createEdificioDB(e4);
		//edificioSvc.createEdificioDB(e5);
		
		//Per ogni edificio presente nel DB mi creo le varie postazioni per categoria
		
		//List<Edificio> listaEdifici = edificioSvc.AllEdificiDB();
		//listaEdifici.forEach(e ->{
		//	Postazione p1 = postazioneSvc.creaPostazione("Postazione Privata", Categoria.PRIVATO, 1, e);
		//	Postazione p2 = postazioneSvc.creaPostazione("Openspace Collaborativo", Categoria.OPENSPACE, 20, e);
		//	Postazione p3 = postazioneSvc.creaPostazione("Sala Riunioni Attrezzata", Categoria.SALA_RIUNIONI, 12, e);
		//	postazioneSvc.createPostazioneDB(p1);
		//	postazioneSvc.createPostazioneDB(p2);
		//	postazioneSvc.createPostazioneDB(p3);
		//});
		
		// Il "Giochino" chiede all'utente di registrarsi, se non si é ancora registrato e svolge
		// le richieste che il compito chiedeva: le varie ricerche di postazioni (per citta e per categoria)
		// e infine dopo la ricerca permette di effettuare una prenotazione
		
		Utente utente = null;
		boolean condizione = false;
		do {
			System.out.println("Benvenuto/a a PrenotaFacile, il miglior gestionale di prenotazioni al mondo");
			System.out.println("É la tua prima volta qui?");
			System.out.println("1. No, sono giá registrato/a");
			System.out.println("2. Si, devo ancora registrarmi");
			int risposta = Integer.parseInt(input.nextLine());
			switch(risposta) {
			case 1:
				System.out.println("Inserisci il tuo username");
				String risposta2 = input.nextLine();
				utente = utenteSvc.cercaPerUsername(risposta2);
				if(utente != null) {
					System.out.println("Utente trovato");
					System.out.println("Bentornato/a " + utente.getNome());
					condizione = true;
				}
				else {
					System.out.println("Ops.. qualcosa é andato storto.");
					System.out.println("Qualche campo inserito non é corretto, riprova!");
				}
				break;
			case 2:
				System.out.println("Benvenuto, per completare la tua registrazione ci servono qualche secondo del tuo tempo");
				System.out.println("Inserisci il tuo nome");
				String nome = input.nextLine();
				System.out.println("Inserisci il tuo cognome");
				String cognome = input.nextLine();
				System.out.println("Inserisci il tuo personale Username");
				String username = input.nextLine();
				System.out.println("Inserisci la tua personale email");
				String email = input.nextLine();
				utente = utenteSvc.creaUtente(username, nome, cognome, email);
				utenteSvc.createUtenteDB(utente);
				System.out.println("Ciao " + utente.getNome()+", siamo riusciti a creare e il tuo profilo");
				System.out.println("Ricorda il tuo username personale per i prossimi accessi é: " + utente.getUsername());
				condizione = true;
				break;
			default:
				log.error("Inserisci una delle opzioni ammissibili!");
				break;
			}
		}while(!condizione);
		
		System.out.println("Abbiamo diversi edifici per prenotare! Effettua la ricerca per trovare la postazione giusta per te");
		System.out.println("1. Cerca un postazione attraverso il nome della cittá");
		System.out.println("2. Cerca un postazione attraverso la categoria che piú ti aggrada (Privato, OpenSpace, Sala riunioni)");
		System.out.println("3. Cerca un postazione attraverso il nome della cittá e la categoria");
		int risposta4 = Integer.parseInt(input.nextLine());
			
		boolean condizione2 = false;
			do {
				switch(risposta4) {
				case 1:
					System.out.println("Quale cittá stavi pensando?");
					String citta = input.nextLine();
					List<Postazione> listaPostazioniPerCitta = postazioneSvc.cercaPerCitta(citta);
					if(listaPostazioniPerCitta.size() != 0) {
						System.out.println("Abbiamo queste postazioni per questa cittá: " + citta);
						listaPostazioniPerCitta.forEach(p -> System.out.println(p));
					}
					else {
						System.out.println("Non é stata trovata nessuna postazione per questa cittá: " + citta);
					}
					condizione2 = true;
					break;
				case 2:
					System.out.println("Quale categoria stavi pensando?");
					System.out.println("1. Privata");
					System.out.println(" Una postazione privata offre un ambiente tranquillo e riservato, ideale per chi necessita di concentrazione e privacy durante il lavoro.");
					System.out.println("2. Open Space");
					System.out.println("L'openspace è un'area condivisa, perfetta per il lavoro collaborativo e l'interazione tra colleghi.");
					System.out.println("3. Sala riunioni");
					System.out.println("La sala riunioni è progettata per ospitare incontri e riunioni aziendali. È dotata di tavolo conferenza, sedie ergonomiche, schermo per presentazioni e attrezzature audio-video di alta qualità.");
					int risposta5 = Integer.parseInt(input.nextLine());
						switch(risposta5) {
						case 1:
							List<Postazione> listaPostazioniPerCategoria1 = postazioneSvc.cercaPerCategoria(Categoria.PRIVATO);
							if(listaPostazioniPerCategoria1.size()!= 0) {
								System.out.println("Abbiamo queste postazioni di categoria Privata: ");
								listaPostazioniPerCategoria1.forEach(p -> System.out.println(p));
							}
							else {
								System.out.println("Non abbiamo trovato nessua postazione di categoria Privata!");
							}
							condizione2 = true;
						break;
						case 2:
							List<Postazione> listaPostazioniPerCategoria2 = postazioneSvc.cercaPerCategoria(Categoria.OPENSPACE);
							if(listaPostazioniPerCategoria2.size()!= 0) {
								System.out.println("Abbiamo queste postazioni di categoria Open Space: ");
								listaPostazioniPerCategoria2.forEach(p -> System.out.println(p));
							}
							else {
								System.out.println("Non abbiamo trovato nessua postazione di categoria Open Space!");
							}
							condizione2 = true;
						break;
						case 3:
							List<Postazione> listaPostazioniPerCategoria3 = postazioneSvc.cercaPerCategoria(Categoria.SALA_RIUNIONI);
							if(listaPostazioniPerCategoria3.size()!= 0) {
								System.out.println("Abbiamo queste postazioni di categoria Sala Riunioni: ");
								listaPostazioniPerCategoria3.forEach(p -> System.out.println(p));
							}
							else {
								System.out.println("Non abbiamo trovato nessua postazione di categoria Sala Riunioni!");
							}
						break;
						}
					break;
				case 3:
					System.out.println("Quale cittá stavi pensando?");
					String citta2 = input.nextLine();
					System.out.println("Quale categoria stavi pensando?");
					System.out.println("1. Privata /n2. Open Space /n3. Sala Riunioni");
					int risposta6 = Integer.parseInt(input.nextLine());
					switch(risposta6){
						case 1:
							Categoria categoria2 = Categoria.PRIVATO;
							List<Postazione> listaPostazioniPerCategoriaPerCitta = postazioneSvc.cercaPerCategoriaPerCitta(categoria2, citta2);
							if(listaPostazioniPerCategoriaPerCitta.size()!=0) {
								System.out.println("La ricerca effettuata ha dato questi risultati:");
								listaPostazioniPerCategoriaPerCitta.forEach(p -> System.out.println(p));
							}else {
								System.out.println("La ricerca non ha dato nessun risultato");
							}
							condizione2 = true;
							break;
						case 2:
							Categoria categoria3 = Categoria.OPENSPACE;
							List<Postazione> listaPostazioniPerCategoriaPerCitta2 = postazioneSvc.cercaPerCategoriaPerCitta(categoria3, citta2);
							if(listaPostazioniPerCategoriaPerCitta2.size()!=0) {
								System.out.println("La ricerca effettuata ha dato questi risultati:");
								listaPostazioniPerCategoriaPerCitta2.forEach(p -> System.out.println(p));
							}else {
								System.out.println("La ricerca non ha dato nessun risultato");
							}
							condizione2 = true;
							break;
						case 3:
							Categoria categoria4 = Categoria.SALA_RIUNIONI;
							List<Postazione> listaPostazioniPerCategoriaPerCitta3 = postazioneSvc.cercaPerCategoriaPerCitta(categoria4, citta2);
							if(listaPostazioniPerCategoriaPerCitta3.size()!=0) {
								System.out.println("La ricerca effettuata ha dato questi risultati:");
								listaPostazioniPerCategoriaPerCitta3.forEach(p -> System.out.println(p));
							}else {
								System.out.println("La ricerca non ha dato nessun risultato");
							}
							condizione2 = true;
							break;
							default:
								break;
					}
				}
			}while(!condizione2);
		
			System.out.println("Ora, dopo la tua ricerca vuoi prenotare?");
			System.out.println("1. Si, voglio prenotare");
			System.out.println("2. No, la ricerca non mi ha soddisfatto, torneró un altro momento...");
			int risposta7 = Integer.parseInt(input.nextLine());
			switch(risposta7) {
			case 1:
				System.out.println("Seleziona una data:");
				System.out.println("Indicami il mese per quando vorresti prenotare");
				int mese = Integer.parseInt(input.nextLine());
				if(mese <= 12 && mese !=0) {
					System.out.println("Seleziona ora il giorno: ");
				}else {
					System.out.println("Mese non valido");
				}
				int giorno = Integer.parseInt(input.nextLine());
				if(giorno!=0 && giorno <=31) {	
					System.out.println("Inserisci l'id della postazione");
				}else {
					System.out.println("Giorno non valido");
				}
				int id = Integer.parseInt(input.nextLine());
				Postazione postazione = postazioneSvc.readPostazioneDB(id);
				LocalDate data = LocalDate.of(2023, mese, giorno);
				if(data.isAfter(LocalDate.now())) {
					Prenotazione p = prenotazioneSvc.creaPrenotazione(data, utente, postazione);
					prenotazioneSvc.createPrenotazioneDB(p);
					System.out.println("Prenotazione effettuata con successo a " +
					p.getPostazione().getEdificio().getCitta() + "nel "
							+p.getPostazione().getEdificio().getNome() + ", in "
							+ p.getPostazione().getEdificio().getIndirizzo() + ", il giorno: "
							+ data);
				}
				else {
					System.out.println("Non si puó piú prenotare questa data, devi scegliere una data FUTURA");
				}
			break;
			case 2:
				System.out.println("Torna a trovarci quando vuoi!");
				break;
			default:
				break;
			}
			
			
	}

}
