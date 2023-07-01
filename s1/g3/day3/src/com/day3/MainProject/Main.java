package com.day3.MainProject;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stringaDispari("ciao");
		System.out.println("-------------------");
		annoBisestile(2000);
		System.out.println("-------------------");
		switchNumero(5);
		System.out.println("-------------------");
		stampaNumero(5);
		System.out.println("-------------------");
		stampaStringa();
	}
	
	//Esercizio 1
	public static boolean stringaDispari(String a) {
		if (a.length()%2 == 0) {
			System.out.println("La stringa inserita é pari");
			return true;
		}
		else {
			System.out.println("La stringa inserita é dispari");
			return false;
		}
	}

	public static boolean annoBisestile(int anno) {
		if(anno%100== 0 && anno%400 == 0) {
			 System.out.println("L'anno inserito é bisestile"); 
			return true;
		}else if(anno%4 == 0) {
			System.out.println("L'anno inserito é bisestile");
			return true;
		} else {
			System.out.println("L'anno inserito NON é bisestile");
			return false;
		}
	}

	//Esercizio 2
	public static void switchNumero(int num) {
 
		switch(num) {
		case 0:
		System.out.println("Numero inserito: zero");
		break;
		case 1:
			System.out.println("Numero inserito: uno");
			break;
		case 2:
			System.out.println("Numero inserito:due");
			break;
		case 3:
			System.out.println("Numero inserito: tre");
			break;
		 default:
		        System.out.println("Errore: il numero inserito é maggiore di 3");
		        break;		
		}
	}
		
	//Esercizio 3
	public static void stampaStringa() {
			Scanner sc = new Scanner(System.in);
	        String input;

	        while (true) {
	            System.out.println("Inserisci una stringa (inserisci \":q\" per uscire):");
	            input = sc.nextLine();

	            if (input.equals(":q")) {
	                System.out.println("Programma terminato.");
	                break;
	            }

	            for (int i = 0; i < input.length(); i++) {
	                char c = input.charAt(i);
	                System.out.print(c);

	                if (i < input.length() - 1) {
	                    System.out.print(",");
	                }
	            }

	            System.out.println();
	        }

	        sc.close();
		}
	
	//Esercizio 4
	public static void stampaNumero(int num) {
		for(int i = num; i >= 0; i--) {
			System.out.println(i);
		}
	}
}

