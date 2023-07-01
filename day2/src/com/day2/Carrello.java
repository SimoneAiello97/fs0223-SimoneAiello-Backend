package com.day2;

public class Carrello {
	public Cliente clienteAssociato;
	public Articolo[] elencoArticoli;
	public int costoArticoli;
	
	public Carrello(Cliente clienteAssociato) {
        this.clienteAssociato = clienteAssociato;
        this.elencoArticoli = new Articolo[5];
        this.costoArticoli = 0;
       
	}
}