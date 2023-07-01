package com.Progetto_U1.MainProject;

import java.util.Scanner;

import com.Progetto_U1.classes.ElementoMultimediale;
import com.Progetto_U1.classes.Immagine;
import com.Progetto_U1.classes.RegistrazioneAudio;
import com.Progetto_U1.classes.Video;

public class MainProject {

	public static void main(String[] args) {

		// ORA FARÓ SI CHE SIA L'UTENTE A SCEGLIERE, TRAMITE LO SCANNER, I VARI ELEMENTI
		// MULTIMEDIALI

		System.out.println("LETTORE MULTIMEDIALE");
		System.out.println("Salve! In questo momento riempiamo il tuo lettore con 5 elementi multimediali!");
		Scanner input = new Scanner(System.in);
		ElementoMultimediale[] lettoreMultimediale = new ElementoMultimediale[5];

		for (int i = 0; i < 5; i++) {

			int tipologia, durata;
			String title;
			boolean variabile = true;

			while (variabile) {
				System.out.println("Specifica il tipo di file multimediale che desideri inserire:");
				System.out.println("(Attualmente hai " + i + " /5 Elementi Multimediali)");
				System.out.println("1 per Immagine \n2 per Audio \n3 per Video");
				System.out.println("");
				tipologia = Integer.parseInt(input.nextLine());

				switch (tipologia) {

				case 1:
					System.out.println("Inserire il titolo dell'immagine:");
					title = input.nextLine();
					lettoreMultimediale[i] = new Immagine(title);
					variabile = false;
					break;
				case 2:
					System.out.println("Inserire il titolo dell'audio:");
					title = input.nextLine();
					System.out.println("Inserire la durata dell'audio `" + title + "`.");
					durata = Integer.parseInt(input.nextLine());
					lettoreMultimediale[i] = new RegistrazioneAudio(title, durata);
					variabile = false;
					break;
				case 3:
					System.out.println("Inserire il titolo del video. ");
					title = input.nextLine();
					System.out.println("Inserire la durata del video `" + title + "`.");
					durata = Integer.parseInt(input.nextLine());
					lettoreMultimediale[i] = new Video(title, durata);
					variabile = false;
					break;
				default:
					System.out.println("Selezione errata!");
					break;
				}
			}
		}

		// E INFINE SARÁ L'UTENTE A "GIOCARE" CON IL LETTORE MULTIMEDIALE

		int inputLettoreMultimediale = 0;
		boolean condizione = true;

		while (condizione) {
			System.out.println("=============");
			System.out.println("    MENU   ");
			System.out.println("=============");
			System.out.println("Scegli da 1 a 5 per mettere play, altrimenti 0 per stoppare tutto!");

			for (int i = 0; i < 5; i++) {
				System.out.print((i + 1) + ")" + lettoreMultimediale[i].getTitle() + " ");
			}
			System.out.println("");
			inputLettoreMultimediale = Integer.parseInt(input.nextLine());

			if (inputLettoreMultimediale == 0) {
				condizione = false;
				System.out.println("Stop!");
				break;
			}

			ElementoMultimediale el = lettoreMultimediale[inputLettoreMultimediale - 1];
			lettoreMultimediale[inputLettoreMultimediale - 1].play();
			System.out.println("Vuoi modificare qualcosa del file multimediale? [Y/N]");
			String risposta = input.nextLine();
			if (risposta.equalsIgnoreCase("Y")) {
				if (lettoreMultimediale[inputLettoreMultimediale - 1] instanceof Immagine) {

					System.out.println("Vuoi modificare la luminosità? \n1. Si \n2. No, va bene così");
					int risposta1 = Integer.parseInt(input.nextLine());

					switch (risposta1) {
					case 1:
						boolean exit = true;
						while (exit) {
							System.out.println(
									"Vuoi abbassare o alzare la luminosità? \n1. Abbassare la luminosità. \n2. Alzare la luminosità. \n3. Indietro");
							int risposta2 = Integer.parseInt(input.nextLine());
							switch (risposta2) {
							case 1:
								((Immagine) el).diminuisciLuminosità();
								break;
							case 2:
								((Immagine) el).aumentaLuminosità();
								break;
							case 3:
								exit = false;
								break;
							}
						}

						break;

					case 2:
						System.out.println("Ok a posto così");
						continue;
					}

				} else if (el instanceof RegistrazioneAudio) {
					System.out.println("Vuoi modificare il volume? \n1. Si \n2. No, va bene così");
					int risposta1 = Integer.parseInt(input.nextLine());

					switch (risposta1) {
					case 1:
						boolean exit = true;
						while (exit) {
							System.out.println(
									"Vuoi abbassare o alzare il volume? \n1. Abbassare il volume. \n2. Alzare il volume. \n3. Indietro");
							int risposta2 = Integer.parseInt(input.nextLine());

							switch (risposta2) {
							case 1:
								((RegistrazioneAudio) el).abbassaVolume();
								break;
							case 2:
								((RegistrazioneAudio) el).alzaVolume();
								break;
							case 3:
								exit = false;
								break;
							}
						}
						break;
					case 2:
						System.out.println("Ok a posto così");
						continue;
					}
				} else if (el instanceof Video) {
				    System.out.println("Vuoi modificare il volume o la luminosità? \n1. Il volume \n2. La luminosità");

				    int risposta1 = Integer.parseInt(input.nextLine());

				    boolean exit1 = true; 
				    boolean exit2 = true; 

				    switch (risposta1) {
				        // Il volume
				        case 1:
				            System.out.println("Vuoi modificare il volume? \n1. Si \n2. No, va bene così");
				            int risposta1a = Integer.parseInt(input.nextLine());
				            switch (risposta1a) {
				                case 1:
				                    while (exit1) {
				                        System.out.println("Vuoi abbassare o alzare il volume? \n1. Abbassare il volume. \n2. Alzare il volume. \n3. Indietro");
				                        int risposta1b = Integer.parseInt(input.nextLine());

				                        switch (risposta1b) {
				                            case 1:
				                                ((Video) el).diminuisciLuminosità();
				                                break;
				                            case 2:
				                                ((Video) el).alzaVolume();
				                                break;
				                            case 3:
				                                exit1 = false;
				                                break;
				                        }
				                    }
				                    break;
				                case 2:
				                    System.out.println("Ok a posto così");
				                    continue;
				            }
				            // La luminosità
				        case 2:
				            System.out.println("Vuoi modificare la luminosità? \n1. Si \n2. No, va bene così");
				            int risposta2a = Integer.parseInt(input.nextLine());
				            switch (risposta2a) {
				                case 1:
				                    while (exit2) {
				                        System.out.println("Vuoi abbassare o alzare la luminosità? \n1. Abbassare la luminosità. \n2. Alzare la luminosità. \n3. Indietro");
				                        int risposta1b = Integer.parseInt(input.nextLine());

				                        switch (risposta1b) {
				                            case 1:
				                                ((Video) el).abbassaVolume();
				                                break;
				                            case 2:
				                                ((Video) el).aumentaLuminosità();
				                                break;
				                            case 3:
				                                exit2 = false;
				                                break;
				                        }
				                    }
				                    break;
				                case 2:
				                    System.out.println("Ok a posto così");
				                    continue;
				            }
				    }
				

				}
			}
		}

		input.close();
	}
}
