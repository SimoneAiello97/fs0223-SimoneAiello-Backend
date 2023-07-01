package it.epicode.be;

import java.util.Arrays;

import java.util.Scanner;


public class Helloworld {
	static int x = 5;
	static int y = 6;
	static String z = "Simone";
	static String[] arrString = {"ciao","mi","chiamo","Simone","Aiello"};
	static String w = "sir";

public static void main (String[] args)
		{
		// Stampa a console  la frase
		System.out.println("This is my first Epicode Java Project!");
		moltiplica(x,y);
		concatena(z, y);
		inserisciInArray(arrString,"sir");
		/*Scanner stringaScan = new Scanner(System.in);
		String a = stringaScan.nextLine();
		String b = stringaScan.nextLine();
		String c = stringaScan.nextLine();
		System.out.print(a+b+c);*/
		
		perimetroRettangolo(10.5,12.3);
		pariDispari(6);
		perimetroTriangolo();
	
		}
//metodo che moltiplica
public static void moltiplica(int a, int b) {
	 int c = a*b;
	 System.out.println(c);
}
//metod che concatena
public static void concatena(String a, int b) {
	 String c = a + " " + b;
	 System.out.println(c);
}
//metodo di array
public static String[] inserisciInArray(String[] array,String nuovaStringa) {
	if (array.length != 5) {
        throw new IllegalArgumentException("L'array deve contenere esattamente 5 elementi.");
    }

    String[] nuovoArray = new String[6];

    for (int i = 0; i < array.length + 1; i++) {
        if (i < 3) {
            nuovoArray[i] = array[i];
        } else if (i == 3) {
            nuovoArray[i] = nuovaStringa;
        } else {
            nuovoArray[i] = array[i - 1];
        }
    }
    System.out.println(Arrays.toString(nuovoArray));
    return nuovoArray;
    }

public static double perimetroRettangolo(double a, double b) {
	double c = (a+b)*2;
	System.out.println(c);
	return c;
}

 public static int pariDispari(int a) {
	 int c = a%2;
	 System.out.println(c);
	return c;
 } 

 private static double perimetroTriangolo() {
		Scanner sc = new Scanner(System.in);
	    System.out.print("lato_1: ");
	    String lato_1 = sc.nextLine();
	    Double lato_1_doubled = Double.parseDouble(lato_1);
	    System.out.print("lato_2: ");
	    String lato_2 = sc.nextLine();
	    Double lato_2_doubled = Double.parseDouble(lato_2);
	    System.out.print("lato_3: ");
	    String lato_3 = sc.nextLine();
	    Double lato_3_doubled = Double.parseDouble(lato_3);

	    double semiPerimetro = (lato_3_doubled + lato_2_doubled + lato_1_doubled)/2;
	    System.out.print(Math.sqrt(semiPerimetro * (semiPerimetro - lato_1_doubled) * (semiPerimetro - lato_2_doubled) * (semiPerimetro - lato_3_doubled)));
	    sc.close();
	    return Math.sqrt(semiPerimetro * (semiPerimetro - lato_1_doubled) * (semiPerimetro - lato_2_doubled) * (semiPerimetro - lato_3_doubled));
	}
}



