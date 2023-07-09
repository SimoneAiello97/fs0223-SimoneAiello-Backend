package com.epicode.MainProject;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epicode.classes.ElementoLetterario;
import com.epicode.classes.Libro;
import com.epicode.classes.Rivista;
import com.epicode.enums.Genere;
import com.epicode.enums.Periodicità;

public class CatalogoLetterario {
	
	// MI CREO VARIABILI CHE USERÓ NEL CORSO DELL'APPLICAZIONE
	
	private static final Logger log = LoggerFactory.getLogger(CatalogoLetterario.class);
	private static final File fileTest = new File ("doc/test.txt");
	private static Set<ElementoLetterario> catalogo = new HashSet<>();
	public static Scanner input = new Scanner(System.in);
	
	// MI CREO DELLE VARIABILI DI COLORE 
	
	public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

	
	public static void main(String[] args) {

		// CREO 10 LIBRI DIVERSI
		
		Libro libro1 = new Libro("123l", "The Great Gatsby", 1925, 180, "F. Scott Fitzgerald", Genere.ROMANZO);
		Libro libro2 = new Libro("2327L", "Leaves of Grass", 1855, 200, "Walt Whitman", Genere.POESIA);
		Libro libro3 = new Libro("2528L", "Sapiens: A Brief History of Humankind", 2011, 464, "Yuval Noah Harari", Genere.SAGGIO);
		Libro libro4 = new Libro("2729L", "Dubliners", 1914, 160, "James Joyce", Genere.RACCONTO);
		Libro libro5 = new Libro("2930L", "Hamlet", 1603, 320, "William Shakespeare", Genere.TEATRO);
		Libro libro6 = new Libro("3132L", "The Power of Habit", 2012, 400, "Charles Duhigg", Genere.SAGGISTICA);
		Libro libro7 = new Libro("3334L", "The New York Times: Complete Civil War, 1861-1865", 2010, 1000, "Harold Holzer", Genere.INFORMAZIONE);
		Libro libro8 = new Libro("3536L", "Travels with Charley", 1962, 288, "John Steinbeck", Genere.VIAGGIO);
		Libro libro9 = new Libro("3738L", "The Origin of Species", 1859, 400, "Charles Darwin", Genere.SCIENTIFICO);
		Libro libro10 = new Libro("2223L", "Brave New World", 1932, 288, "Aldous Huxley", Genere.ROMANZO);
		
		// CREO 10 RIVISTE DIVERSE
		
		Rivista rivista1 = new Rivista("4236l", "National Geographic", 1888, 100, Periodicità.MENSILE);
		Rivista rivista2 = new Rivista("5467l", "Time", 1923, 80, Periodicità.SETTIMANALE);
		Rivista rivista3 = new Rivista("7890l", "Vogue", 1892, 150, Periodicità.MENSILE);Rivista rivista4 = new Rivista("9012l", "The New Yorker", 1925, 120, Periodicità.SETTIMANALE);
		Rivista rivista5 = new Rivista("3456l", "Sports Illustrated", 1954, 90, Periodicità.SETTIMANALE);
		Rivista rivista6 = new Rivista("7891l", "Forbes", 1917, 70, Periodicità.SETTIMANALE);
		Rivista rivista7 = new Rivista("2345l", "Rolling Stone", 1967, 110, Periodicità.MENSILE);
		Rivista rivista8 = new Rivista("6789l", "Wired", 1993, 100, Periodicità.MENSILE);
		Rivista rivista9 = new Rivista("0123l", "Harper's Bazaar", 1867, 130, Periodicità.MENSILE);
		Rivista rivista10 = new Rivista("2468l", "Annual Photography Review", 2005, 200, Periodicità.SEMESTRALE);

		// LE AGGIUNGO ALLA MIA BIBLIOTECA PERSONALE
		
		try {
			aggiungi(libro1);
			aggiungi(libro2);
			aggiungi(libro3);
			aggiungi(libro4);
			aggiungi(libro5);
			aggiungi(libro6);
			aggiungi(libro7);
			aggiungi(libro8);
			aggiungi(libro9);
			aggiungi(libro10);
			aggiungi(rivista1);
			aggiungi(rivista2);
			aggiungi(rivista3);
			aggiungi(rivista4);
			aggiungi(rivista5);
			aggiungi(rivista6);
			aggiungi(rivista7);
			aggiungi(rivista8);
			aggiungi(rivista9);
			aggiungi(rivista10);
			salvaArchivio(catalogo);
			//caricaArchivio();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//DOPO DI CHE FACCIO PARTIRE UNA PICCOLA APPLICAZIONE INTERATTIVA CHE CHIEDE ALL'UTENTE DI GUARDARE LA BIBLIOTECA O DI FARE RICERCHE

		System.out.println(MAGENTA + "==============================" + RESET);
		System.out.println(YELLOW + "Benvenuto nella mia Biblioteca" + RESET);
		System.out.println(MAGENTA + "==============================" + RESET);
		boolean condizione = true;
		while (condizione) {
			System.out.println(CYAN + "Stai cercando qualcosa in particolare o vuoi semplicemente guardarti attorno? "
					+ RESET + " \n1. Conosco la biblioteca, devo fare una ricerca! "
					+ "\n2. È la mia prima volta qui \n3. Devo andare via");
			int risposta = Integer.parseInt(input.nextLine());
			switch (risposta) {
			case 1:
				boolean exit = true;
				while (exit) {
					System.out.println(GREEN + "Lieto di averti ancora qui allora!" + RESET);
					System.out.println(CYAN + "Che tipo di ricerca volevi fare? " + RESET
							+ "\n1. Ricerca attraverso un codice \n2. Ricerca per anno di pubblicazione \n3. Ricerca per Autore \n4. Ho cambiato idea, grazie");
					int risposta1 = Integer.parseInt(input.nextLine());
					switch (risposta1) {
					case 1:
						System.out.println(YELLOW
								+ "Scrivi il codice univoco del libro o della rivista che stai cercando:" + RESET);
						String codice = input.nextLine();
						ricercaPerIsbn(codice);
						System.out.println("");
						exit = false;
						break;
					case 2:
						System.out.println(
								YELLOW + "Scrivi l'anno di pubblicazione del libro o della rivista che stai cercando:"
										+ RESET);
						int annoPubblicazione = Integer.parseInt(input.nextLine());
						ricercaPerAnnoPubblicazione(annoPubblicazione);
						System.out.println("");
						exit = false;
						break;
					case 3:
						System.out.println(YELLOW + "Scrivi il nome dell'autore del libro che stai cercando:" + RESET);
						String autore = input.nextLine();
						ricercaPerAutore(autore);
						System.out.println("");
						exit = false;
						break;
					case 4:
						System.out.println(GREEN + "...ok" + RESET);
						System.out.println("");
						exit = false;
						break;
					default:
						System.out.println(RED + "Scelta non valida. Riprova." + RESET);
						break;
					}
				}
				break;
			case 2:
				boolean exit2 = true;
				System.out.println(
						GREEN + "Benvenuto allora!!!. Qui potrai trovare diversi libri e diverse riviste" + RESET);
				while (exit2) {
					System.out.println(CYAN + "Vuoi guardare la sezione dei libri o la sezione delle riviste? " + RESET
							+ "\n1. Sono piú interessato ai libri " + "\n2. Sono piú interessato alle riviste "
							+ "\n3. Indietro");
					int risposta2 = Integer.parseInt(input.nextLine());
					switch (risposta2) {
					case 1:
						try {
							caricaArchivio();
							System.out.println(MAGENTA + "Abbiamo questi libri:" + RESET);
							for (ElementoLetterario elemento : catalogo) {
								if (elemento instanceof Libro) {
									System.out.println(CYAN + "Titolo: " + RESET + elemento.getTitolo());
								}
							}
							System.out.println("");
						} catch (IOException e) {
							e.printStackTrace();
						}

						break;
					case 2:
						try {
							caricaArchivio();
							System.out.println(MAGENTA + "Abbiamo queste riviste:" + RESET);
							for (ElementoLetterario elemento : catalogo) {
								if (elemento instanceof Rivista) {
									System.out.println(CYAN + "Titolo: " + RESET + elemento.getTitolo());
								}
							}
							System.out.println("");
						} catch (IOException e) {
							e.printStackTrace();
						}

						break;
					case 3:

						exit2 = false;
						break;
					default:
						System.out.println(RED + "Scelta non valida. Riprova." + RESET);
						break;
					}
				}
				break;
			case 3:
				System.out.println(GREEN + "Va bene, torna a trovarci quando vuoi!" + RESET);
				condizione = false;
			}
		}

		input.close();
	}
	
	

	public static void aggiungi(ElementoLetterario elemento) {
	    catalogo.add(elemento);
	    //log.info("Elemento aggiunto al catalogo. Titolo: {}", elemento.getTitolo());
	}
	public static void rimuovi(String isbn) {
	    ElementoLetterario elementoRimosso = catalogo.stream()
	            .filter(elemento -> elemento.getIsbn().equals(isbn))
	            .findFirst()
	            .orElse(null);
	    
	    if (elementoRimosso != null) {
	        catalogo.remove(elementoRimosso);
	        log.info("Elemento rimosso dal catalogo. ISBN: {}, Titolo: {}", elementoRimosso.getIsbn(), elementoRimosso.getTitolo());
	    } else {
	        log.info("Nessun elemento trovato con l'ISBN specificato: {}", isbn);
	    }
	}
	
	public static List<ElementoLetterario> ricercaPerIsbn(String isbn) {
	    List<ElementoLetterario> risultati = catalogo.stream()
	            .filter(el -> el.getIsbn().equals(isbn))
	            .collect(Collectors.toList());

	    if (!risultati.isEmpty()) {
	        ElementoLetterario elementoTrovato = risultati.get(0);
	        System.out.println(CYAN +"Stavi cercando questo: "
	        		+ RESET + "`" + elementoTrovato.getTitolo() + "`");
	    }
	    else {
	    	System.out.println(RED + "Non abbiamo trovato nulla, ci spiace!" + RESET);
	    }

	    return risultati;
	}

	
	public static List<ElementoLetterario> ricercaPerAnnoPubblicazione(Integer annoPubblicazione){
			
		List<ElementoLetterario> risultati = catalogo.stream()
					.filter(el -> annoPubblicazione.equals(el.getAnnoPubblicazione())) 
				  .collect(Collectors.toList());
		
		if(risultati.size()>1) {
			System.out.println(CYAN +"Stavi cercando questi?" + RESET);
			for(ElementoLetterario elementoTrovato: risultati) {
				System.out.println(elementoTrovato.getTitolo());
			}
		}
		else if(!risultati.isEmpty()) {
	        ElementoLetterario elementoTrovato = risultati.get(0);
	        System.out.println(CYAN +"Stavi cercando questo: "
	        		+ RESET + "`" + elementoTrovato.getTitolo()+"`");
	    }
		else {
	    	System.out.println(RED + "Non abbiamo trovato nulla, ci spiace!" + RESET);
	    }

	    return risultati;
			
		}
	
	public static List<Libro> ricercaPerAutore(String autore){
		
		List<Libro> risultati = catalogo.stream().filter(el -> el instanceof Libro) 
								  .map(el -> (Libro) el) 
								  .filter(el -> autore.equals(el.getAutore())) 
								  .collect(Collectors.toList()); 
		if(risultati.size()>1) {
			System.out.println(CYAN + "Stavi cercando questi:" + RESET);
			for(ElementoLetterario elementoTrovato: risultati) {
				System.out.println(elementoTrovato.getTitolo());
			}
		}
		else if(!risultati.isEmpty()) {
	        ElementoLetterario elementoTrovato = risultati.get(0);
	        System.out.println(CYAN + "Stavi cercando questo: "
	        		+ RESET + "`"  + elementoTrovato.getTitolo()+"`");
	    }
		else {
	    	System.out.println(RED + "Non abbiamo trovato nulla, ci spiace!" + RESET);
	    }
		return risultati;
	}
	
	
	public static void salvaArchivio(Set<ElementoLetterario> lista) throws IOException {
		if (fileTest.exists()) fileTest.delete();
		StringBuilder text = new StringBuilder();
		
		lista.forEach(el -> {
				if (el instanceof Libro) {
					text.append("libro:~");
				}  
				else if(el instanceof Rivista)
				{
					text.append("rivista:~");
				}
				
				text.append(el.getIsbn() + "~").append(el.getTitolo() + "~")
					.append(el.getAnnoPubblicazione().toString() + "~").append(el.getNumeroPagine().toString() + "~");
				if (el instanceof Libro) 
				{
					Libro libro = (Libro) el;
					text.append(libro.getAutore() + "~").append(libro.getGenere() + "~");
				} 
				else if(el instanceof Rivista)
				{
					Rivista rivista = (Rivista) el;
					text.append(rivista.getPeriodicita() + "~");
				}
				text.append("#");
			});
		
		FileUtils.writeStringToFile(fileTest, text.toString(), "UTF-8", true);
	}
	
	public static void caricaArchivio() throws IOException {
	    String text = FileUtils.readFileToString(fileTest, "UTF-8");
	    String[] textSplittato = text.split("#");

	    Set<ElementoLetterario> lista = new HashSet<>();

	    for (String dato : textSplittato) {
	        String[] elementoLetterario = dato.split("~");
	        String tipo = elementoLetterario[0];
	        String isbn = elementoLetterario[1];
	        String titolo = elementoLetterario[2];
	        Integer annoPubblicazione = Integer.parseInt(elementoLetterario[3]);
	        Integer numeroPagine = Integer.parseInt(elementoLetterario[4]);

	        if (tipo.equals("libro:")) {
	        	
	            String autore = elementoLetterario[5];
            	Genere genere = Genere.valueOf(elementoLetterario[6]);
            	lista.add(new Libro(isbn, titolo, annoPubblicazione, numeroPagine,autore,genere ));
            	
	        } else if (tipo.equals("rivista:")) {
	        	
	            Periodicità periodico = Periodicità.valueOf(elementoLetterario[5]);
	            lista.add(new Rivista(isbn, titolo, annoPubblicazione, numeroPagine, periodico));
	        }
	    }

	    
			catalogo = lista;
		
	}

	

	
	
	
	

}
