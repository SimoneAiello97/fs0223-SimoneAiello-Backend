package com.Progetto_U1.classes;

import com.Progetto_U1.interfaces.ILuminosita;


public class Immagine extends ElementoMultimediale implements ILuminosita{
	
	public int luminosita;
	
	public Immagine(String title) {
		super(title);
		this.luminosita = 3;
		
	}
	
	

	@Override
	public String toString() {
		return "Immagine " + this.title + ": [luminosita=" + luminosita + "]";
	}



	@Override
	public void play() {
		this.show();
	};
	   
	public void show() {
		System.out.print(this.title);
		for (int i = 0; i < this.luminosita;i ++) {
			System.out.print('*');
		}
		System.out.println("");
	}



	@Override
	public int aumentaLuminosità() {
		if(this.luminosita >= 10) {
			System.out.println("La luminosità non puó essere superiore a 10");
			return this.luminosita;
		}
		this.luminosita++;
		System.out.println("La luminositá é stata aumentata a: " + this.luminosita);
		return this.luminosita;
	}



	@Override
	public int diminuisciLuminosità() {
		if(this.luminosita <= 0) {
			System.out.println("La luminosità non puó essere inferiore a 0");
			return this.luminosita;
		}
		this.luminosita--;
		System.out.println("La luminositá é stata diminuita a: " + this.luminosita);
		return this.luminosita;
	}

}
