package com.epicode.Spring.Observer.entities;

import java.util.Observable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@SuppressWarnings("deprecation")
public class SondaObserver extends Observable {
	
		
		    private long id;
		    private double latitude;
		    private double longitude;
		    private int smokeLevel;
		    
		    public SondaObserver(long id, double latitude, double longitude) {
		    	super();
		    	this.id = id;
		    	this.latitude = latitude;
		    	this.longitude = longitude;
		    	this.smokeLevel = 0;
		    }
		   
		    
		    
		    public void setSmokeLevel(int smokeLevel) {
		        this.smokeLevel = smokeLevel;
		        if (smokeLevel > 5) {
		        	notifySensore();
		        }
		    }
		    
		    private void notifySensore() {
		        setChanged();
		        notifyObservers(this);
		    }

	}

