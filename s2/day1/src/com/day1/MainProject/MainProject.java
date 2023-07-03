package com.day1.MainProject;

import java.util.Arrays;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day1.Exception.MyException;

public class MainProject {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		esercizioUno();
		esercizioDue();
	}
	
	public static void esercizioUno() {
		Logger  log = LoggerFactory.getLogger(MainProject.class);
		int[] arr = new int[5];
		for(int i = 0; i < arr.length; i++) {
			int a = (int) (Math.floor(Math.random()*10) + 1);
			arr[i] = a;
		}
		System.out.println((Arrays.toString(arr)));
		boolean condizione = true;
		
			while(condizione) {
				System.out.println("Scegli un numero da 1 a 5 per selezionare il numero da cambiare");
				int posizione = Integer.parseInt(input.nextLine());
					
				if(posizione !=0) {
					try {
						if(posizione <= 5 && posizione >=0) {
							System.out.println("Scegli il numero con cui sosituirlo");
							int nuovoNumero = Integer.parseInt(input.nextLine());
								try {
									if(nuovoNumero <= 10 && nuovoNumero >0) {
									arr[posizione - 1] = nuovoNumero;
									System.out.println(Arrays.toString(arr));
								}
									else {
										throw new MyException("numero invalido: deve essere tra 1 e 10");
									}
								}
								catch(MyException b){
									log.error(b.getMessage());
								}
						}
						else {
							throw new MyException("La posizione del numero puó essere un numero da 1 a 5");	
						}
					}
					catch(MyException a){
						log.error(a.getMessage());
					}					
				}
				else {
					condizione = false;	
					System.out.println("Gioco terminato!");
				}
				
				}
	}
	
	public static void esercizioDue() {
		Logger  log = LoggerFactory.getLogger(MainProject.class);
		boolean condizione = true;
		while(condizione) {
			
			Scanner input = new Scanner(System.in);
			System.out.println("Inserisci i chilometri percorsi: ");
			int chilometriPercorsi = Integer.parseInt(input.nextLine());
			System.out.println("Inserisci i litri consumati: ");
			int litriConsumati = Integer.parseInt(input.nextLine());;
			
			try {
				if(litriConsumati != 0) {
					int chilometriAlLitro = chilometriPercorsi/litriConsumati;
					System.out.println("L'utente ha viaggiato a " + chilometriAlLitro + " km/litro");	
					condizione = false;
				}
				else {
					throw new MyException("Seee abbiamo er fenomeno qui!");
				}
			}
				catch(MyException a){
					log.error(a.getMessage());
				}
			
			}
		
		
	}



}


