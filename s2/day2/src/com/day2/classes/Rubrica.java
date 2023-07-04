package com.day2.classes;

import java.util.HashMap;
import java.util.Map;

public class Rubrica {
	String nome;
	String numeroTelefono;
	
		public Rubrica(String nome, String numeroTelefono){
			this.nome = nome;
			this.numeroTelefono = numeroTelefono;
		}
		
		public static void inserimento(Rubrica a) {
			Map<String, String> utente = new HashMap<String, String>();
			utente.put(a.nome, a.numeroTelefono);
		}
		
		public static void  cancellazione(String nome) {
			Map<String, String> utente = new HashMap<String, String>();
			utente.remove(nome);
		}
		
		public static void cercaPersone(String numero) {
			Map<String, String> utente = new HashMap<String, String>();
		}
}
