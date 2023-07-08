package com.epicode.MainProject;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
	private static final Logger log = LoggerFactory.getLogger(CatalogoLetterario.class);
	
	private static final File fileTest = new File ("doc/test.txt");
	
	private static Map<String, ElementoLetterario> archivio= new HashMap<String, ElementoLetterario>();
	
	public static void main(String[] args) {
		
		//CatalogoLetterario catalogo = new CatalogoLetterario();
		
		// CREO 10 LIBRI DIVERSI
		
		//Libro libro4 = new Libro("2729L", "Dubliners", 1914, 160, "James Joyce", Genere.RACCONTO);
		//Libro libro5 = new Libro("2930L", "Hamlet", 1603, 320, "William Shakespeare", Genere.TEATRO);
		//Libro libro6 = new Libro("3132L", "The Power of Habit", 2012, 400, "Charles Duhigg", Genere.SAGGISTICA);
		//Libro libro7 = new Libro("3334L", "The New York Times: Complete Civil War, 1861-1865", 2010, 1000, "Harold Holzer", Genere.INFORMAZIONE);
		//Libro libro8 = new Libro("3536L", "Travels with Charley", 1962, 288, "John Steinbeck", Genere.VIAGGIO);
		//Libro libro9 = new Libro("3738L", "The Origin of Species", 1859, 400, "Charles Darwin", Genere.SCIENTIFICO);
		//Libro libro10 = new Libro("2223L", "Brave New World", 1932, 288, "Aldous Huxley", Genere.ROMANZO);
		
		//Rivista rivista4 = new Rivista("9012l", "The New Yorker", 1925, 120, Periodicità.SETTIMANALE);
		//Rivista rivista5 = new Rivista("3456l", "Sports Illustrated", 1954, 90, Periodicità.SETTIMANALE);
		//Rivista rivista6 = new Rivista("7891l", "Forbes", 1917, 70, Periodicità.SETTIMANALE);
		//Rivista rivista7 = new Rivista("2345l", "Rolling Stone", 1967, 110, Periodicità.MENSILE);
		//Rivista rivista8 = new Rivista("6789l", "Wired", 1993, 100, Periodicità.MENSILE);
		//Rivista rivista9 = new Rivista("0123l", "Harper's Bazaar", 1867, 130, Periodicità.MENSILE);
		//Rivista rivista10 = new Rivista("2468l", "Annual Photography Review", 2005, 200, Periodicità.SEMESTRALE);
		
		Libro libro1 = new Libro("123l", "The Great Gatsby", 1925, 180, "F. Scott Fitzgerald", Genere.ROMANZO);
		Libro libro2 = new Libro("2327L", "Leaves of Grass", 1855, 200, "Walt Whitman", Genere.POESIA);
		Libro libro3 = new Libro("2528L", "Sapiens: A Brief History of Humankind", 2011, 464, "Yuval Noah Harari", Genere.SAGGIO);
		
		// CREO 10 RIVISTE DIVERSE
		
		Rivista rivista1 = new Rivista("4236l", "National Geographic", 1888, 100, Periodicità.MENSILE);
		Rivista rivista2 = new Rivista("5467l", "Time", 1923, 80, Periodicità.SETTIMANALE);
		Rivista rivista3 = new Rivista("7890l", "Vogue", 1892, 150, Periodicità.MENSILE);
		
		try {
			aggiungi(libro1);
			aggiungi(libro2);
			aggiungi(libro3);
			aggiungi(rivista1);
			aggiungi(rivista2);
			aggiungi(rivista3);
			
			Set<ElementoLetterario> catalogo = new HashSet<>(archivio.values());

			salvaArchivio(catalogo);
			//caricaCatalogo();
			ricercaPerIsbn("7890l");
			ricercaPerAnnoPubblicazione(1925);
			ricercaPerAutore("Walt Whitman");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	public static void aggiungi(ElementoLetterario elemento){
		archivio.put(elemento.getIsbn(), elemento);
		log.info("Elemento aggiunto in archivio. Titolo: {}",elemento.getTitolo());
	}
	
	public static void rimuovi(String isbn) {
		 if (archivio.containsKey(isbn)) {
		        ElementoLetterario elementoRimosso = archivio.remove(isbn);
		        log.info("Elemento rimosso dall'archivio. ISBN: {} - Anno Pubblicazione: {}", elementoRimosso.getIsbn(), elementoRimosso.getAnnoPubblicazione());
		    } else {
		        log.info("Nessun elemento trovato con l'ISBN specificato: {}", isbn);
		    }
	}
	
	public static List<ElementoLetterario> ricercaPerIsbn(String isbn) {
	    List<ElementoLetterario> risultati = archivio.values().stream()
	            .filter(el -> el.getIsbn().equals(isbn))
	            .collect(Collectors.toList());

	    if (!risultati.isEmpty()) {
	        ElementoLetterario elementoTrovato = risultati.get(0);
	        System.out.println("Stavi cercando questo? `" + elementoTrovato.getTitolo()+"`");
	    }

	    return risultati;
	}

	
	public static List<ElementoLetterario> ricercaPerAnnoPubblicazione(Integer annoPubblicazione){
			
		List<ElementoLetterario> risultati = archivio.values().stream().filter(el -> annoPubblicazione.equals(el.getAnnoPubblicazione())) 
									  .collect(Collectors.toList());
		if(risultati.size()>1) {
			System.out.println("Stavi cercando questi?");
			for(ElementoLetterario elementoTrovato: risultati) {
				System.out.println(elementoTrovato.getTitolo());
			}
		}
		else if(!risultati.isEmpty()) {
	        ElementoLetterario elementoTrovato = risultati.get(0);
	        System.out.println("Stavi cercando questo? `" + elementoTrovato.getTitolo()+"`");
	    }

	    return risultati;
			
		}
	
	public static List<Libro> ricercaPerAutore(String autore){
		
		List<Libro> risultati = archivio.values().stream().filter(el -> el instanceof Libro) 
								  .map(el -> (Libro) el) 
								  .filter(el -> autore.equals(el.getAutore())) 
								  .collect(Collectors.toList()); 
		if(risultati.size()>1) {
			System.out.println("Stavi cercando questi?");
			for(ElementoLetterario elementoTrovato: risultati) {
				System.out.println(elementoTrovato.getTitolo());
			}
		}
		else if(!risultati.isEmpty()) {
	        ElementoLetterario elementoTrovato = risultati.get(0);
	        System.out.println("Stavi cercando questo? `" + elementoTrovato.getTitolo()+"`");
	    }
		return risultati;
	}
	
	
	public static void salvaArchivio(Set<ElementoLetterario> lista) throws IOException {
		if (fileTest.exists()) fileTest.delete();
		StringBuilder text = new StringBuilder();
		
		lista.forEach(el -> {
				if (el instanceof Libro) {
					text.append("type=book@");
				}  
				else if(el instanceof Rivista)
				{
					text.append("type=magazine@");
				}
				
				text.append(el.getIsbn() + "@").append(el.getTitolo() + "@")
					.append(el.getAnnoPubblicazione().toString() + "@").append(el.getNumeroPagine().toString() + "@");
				if (el instanceof Libro) 
				{
					Libro libro = (Libro) el;
					text.append(libro.getAutore() + "@").append(libro.getGenere() + "@");
				} 
				else if(el instanceof Rivista)
				{
					Rivista rivista = (Rivista) el;
					text.append(rivista.getPeriodicita() + "@");
				}
				text.append("#");
			});
		
		FileUtils.writeStringToFile(fileTest, text.toString(), "UTF-8", true);
	}

	
	
	
	

}
