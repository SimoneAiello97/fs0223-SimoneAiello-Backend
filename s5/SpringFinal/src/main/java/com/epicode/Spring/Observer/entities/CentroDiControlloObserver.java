package com.epicode.Spring.Observer.entities;
import java.util.Observable;
import java.util.Observer;

import com.epicode.Spring.Proxy.SondaProxy;

import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("deprecation")
@Data
@NoArgsConstructor
public class CentroDiControlloObserver implements  Observer {

	@Override
	public void update(Observable o, Object sonda) {
		SondaObserver s = (SondaObserver) o;
		long idSonda = s.getId();
		double latitude = s.getLatitude();
		double longitude = s.getLongitude();
		int smokeLevel = s.getSmokeLevel();	
		
		String notification = "Incendio rilevato: Sonda " + idSonda + " - Lat: " + latitude + " Lon: " + longitude + " Smoke: " + smokeLevel;
        String alarm_url = "http://host/alarm?sensorId="+idSonda+"&lat="+latitude+"&lon="+longitude+"&smokeLevel="+smokeLevel+"]";
        System.out.println(notification);
        //System.out.println(alarm_url);
        
        SondaProxy sp = new SondaProxy(s);
		
	}


}
