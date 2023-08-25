package com.epicode.Spring.Factory.entities;

import java.util.ArrayList;
import java.util.List;

import com.epicode.Spring.Factory.interfaces.ISensore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sonda implements ISensore{
	 
	    private int smokeLevel;
	    private long id;
	    private double latitude;
	    private double longitude;
	    private CentroDiControllo cc;
	    
	    
	    public void setSmokeLevel(int smokeLevel) {
	        this.smokeLevel = smokeLevel;
	        if (smokeLevel > 5) {
	        	rilevazioneFuoco();
	        }
	    }
	    

		@Override
		public void rilevazioneFuoco() {
			cc.triggerAllarm(this);
			
		}


		
}
