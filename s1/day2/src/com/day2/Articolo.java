package com.day2;

public class Articolo {
	public String codiceArticolo;
	public String descrizione;
	public double prezzo;
	public int pezziDisponibili;

    public Articolo(String codiceArticolo, String descrizione, double prezzo, int pezziDisponibili) {
        this.codiceArticolo = codiceArticolo;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.pezziDisponibili = pezziDisponibili;
    }
}
