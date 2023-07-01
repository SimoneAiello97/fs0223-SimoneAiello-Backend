package com.day2;

public class Rettangolo {
	public int base;
	public int altezza;
	
public Rettangolo(int base, int altezza) {
	this.base = base;
	this.altezza = altezza;
}

public void stampaRettangolo(Rettangolo a){
	int areaRettangolo = a.base * a.altezza;
	int perimetroRettangolo = (a.base + a.altezza)*2;
	System.out.println("Area rettangolo: " + areaRettangolo);
	System.out.println("Perimetro rettangolo: " +perimetroRettangolo);
}

public static void  stampaDueRettangoli(Rettangolo a, Rettangolo b) {
	a.stampaRettangolo(a);
	b.stampaRettangolo(b);
	int perimetriCombinati = (a.base + a.altezza)* 2 + (b.base + b.altezza)* 2;
	int areeCombinate = (a.base * a.altezza)+ (b.base * b.altezza);
	System.out.println("La somma dei perimetri dei due rettangoli é: " + perimetriCombinati);
	System.out.println("La somma delle aree dei due rettangoli é: " + areeCombinate);
}

}
