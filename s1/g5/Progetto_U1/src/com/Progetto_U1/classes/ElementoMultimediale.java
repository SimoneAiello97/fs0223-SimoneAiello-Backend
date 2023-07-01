package com.Progetto_U1.classes;

//Creo una classe astratta che verrá estesa dalle altre classi Immagini, RiproduzioneAudio e Video

public abstract class ElementoMultimediale {
	protected String title;
	
	public ElementoMultimediale(String title) {
		this.title = title	;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public abstract void play();

}
