package com.day2.classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rubrica {
	String nome;
	String numeroTelefono;
	static Map<String, String> rubrica = new HashMap<String, String>();
	private static Logger log = LoggerFactory.getLogger(Rubrica.class);
	
		public Rubrica(String nome, String numeroTelefono){
			this.nome = nome;
			this.numeroTelefono = numeroTelefono;
		}
		
		public static void inserimento(Rubrica a) {
			rubrica.put(a.nome, a.numeroTelefono);
		}
		
		public static void  cancellazione(String nome) {
			rubrica.remove(nome);
		}
		
		public static String cercaPersone(String numero) {
			  for (Map.Entry<String, String> entry : rubrica.entrySet()) {
		            if (entry.getValue().equals(numero)) {
		                return entry.getKey();
		            }
		        }
		        return null; // Numero non trovato
		    }

		public static void stampaTutti() {
			Set<String> key = rubrica.keySet();
			Object[] arr = key.toArray();
			// ciclo for che mi itera tutti gli elementi presenti in un array
			for (Object s : arr) {
				log.info("Elemento key: " + s + " Value: " + rubrica.get(s));
			}
		}
}
