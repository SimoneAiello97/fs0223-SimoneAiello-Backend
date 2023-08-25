package com.epicode.Spring.Factory.entities;

import com.epicode.Spring.Factory.interfaces.ICentroDiControllo;
import com.epicode.Spring.Factory.interfaces.ISensore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CentroDiControllo implements ICentroDiControllo {
	@Override
	public void triggerAllarm(Sonda sonda) {
		
		long idSonda = sonda.getId();
				double latitude = sonda.getLatitude();
				double longitude = sonda.getLongitude();
				int smokeLevel = sonda.getSmokeLevel();
				String notification = "Incendio rilevato: Sonda " + idSonda + " - Lat: " + latitude + " Lon: " + longitude + " Smoke: " + smokeLevel;
        String alarm_url = "http://host/alarm?sensorId="+idSonda+"&lat="+latitude+"&lon="+longitude+"&smokeLevel="+smokeLevel+"]";
        System.out.println(notification);
        System.out.println(alarm_url);
	}

	//@Override
	//public void rilevazioneFuoco(Sonda sonda) {
		//long idSonda = sonda.getId();
		//double latitude = sonda.getLatitude();
		//double longitude = sonda.getLongitude();
		//int smokeLevel = sonda.getSmokeLevel();	
		//String notification = "Incendio rilevato: Sonda " + idSonda + " - Lat: " + latitude + " Lon: " + longitude + " Smoke: " + smokeLevel;
        //String alarm_url = "http://host/alarm?sensorId="+idSonda+"&lat="+latitude+"&lon="+longitude+"&smokeLevel="+smokeLevel+"]";
        
        //System.out.println(notification);
        //System.out.println(alarm_url);
	//}

}
