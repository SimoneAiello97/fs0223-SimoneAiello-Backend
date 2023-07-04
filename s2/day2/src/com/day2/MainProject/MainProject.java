package com.day2.MainProject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day2.classes.Rubrica;

public class MainProject {
	
	private static Logger log = LoggerFactory.getLogger(MainProject.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//primoEsercizio();
		//secondoEsercizio();
		Rubrica rubrica = new Rubrica("Mario Rossi", "1234");
		Rubrica.inserimento(rubrica);
		System.out.println(rubrica.toString());
		Rubrica.cancellazione("Mario Rossi");
		System.out.println(rubrica.toString());
		
	}

	// ESERCIZIO 1
	public static void primoEsercizio() {
		System.out.println("Inserisci il numero di elementi da inserire");
		Scanner input = new Scanner(System.in);
		int numeroElementi = Integer.parseInt(input.nextLine());
		
		Set<String> parole = new HashSet<>();
        Set<String> paroleDuplicate = new HashSet<>();

        System.out.println("Inserisci le parole una per volta:");

        for (int i = 0; i < numeroElementi; i++) {
            String parola = input.nextLine();

            if (!parole.add(parola)) {
                paroleDuplicate.add(parola);
            }
        }

        System.out.println("Parole duplicate:");
        for (String parola : paroleDuplicate) {
            System.out.println(parola);
        }

        System.out.println("Numero di parole distinte: " + parole.size());

        System.out.println("Elenco delle parole distinte:");
        for (String parola : parole) {
            System.out.println(parola);
        }
        input.close();
    }
	
	//ESERCIZIO 2
	public static void secondoEsercizio() {
		System.out.println("Inserisci il numero di elementi che vuoi inserire");
		List<Number> lista = new ArrayList<Number>();
		Scanner input = new Scanner(System.in);
		int numeroElementi = Integer.parseInt(input.nextLine());
		
		for(int i = 0 ; i< numeroElementi; i++) {
			int numeroCasuale = (int) (Math.random()*101);
			lista.add(numeroCasuale);
		}
		System.out.println(lista);
		Collections.reverse(lista);
		System.out.println("elementi al contrario: " + lista);
		
		boolean condizione = false;
		
		
		if(condizione){
		for(int i = 0; i<lista.size(); i ++){
				if(i%2 == 0) {
					System.out.println("Stampati i valori pari: " + lista.get(i));
				}
			}
			
		}
		else {
			for(int i = 0; i<lista.size(); i ++) {
				System.out.println("Stampati i valori dispari: " + lista.get(i));
			}
		}
	
		
		input.close();
	}

	
	
}

