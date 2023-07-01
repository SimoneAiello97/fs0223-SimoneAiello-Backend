package com.Progetto_U1.classes;

import com.Progetto_U1.interfaces.IVolume;

public class RegistrazioneAudio extends ElementoMultimediale implements IVolume{

	public int durata;
	public int volume;
	
	public RegistrazioneAudio(String title, int durata) {
		super(title);
		this.durata = durata;
		this.volume = 5;
	
	}
	

	@Override
	public String toString() {
		return "Audio " + this.title + ": [durata=" + durata + ", volume=" + volume + "]";
	}


	@Override
	public int abbassaVolume() {
		if(this.volume <= 0) {
			System.out.println("Il volume non puó essere inferiore a 0");
			return this.volume;
		}
		this.volume--;
		System.out.println("Il volume é stato diminuito a: " + this.volume);
		return this.volume;
	}

	@Override
	public int alzaVolume() {
		if(this.volume >= 5) {
			System.out.println("Il volume non puó essere superiore a 5");
			return this.volume;
		}
		this.volume++;
		System.out.println("Il volume é stato aumentato a: " + this.volume);
		return this.volume;
	}


	@Override
	public void play() {
		
		for(int i = 0; i < this.durata;i++){
			System.out.print(this.title);
			
			for (int x = 0; x < this.volume;x ++) {
				System.out.print("!");
			}
			System.out.println("");
		}
		
	}
	
	
}
