package com.epicode.Spring.Proxy;

import com.epicode.Spring.Observer.entities.SondaObserver;

public class SondaProxy implements ISondaProxy{
	
	SondaObserver sonda;
	
	public SondaProxy(SondaObserver sonda) {
		super();
		this.sonda = sonda;
		allarm(sonda);
	}

	@Override
	public String allarm(SondaObserver sonda) {
		String alarm_url = "http://host/alarm?sensorId="+sonda.getId()+"&lat="+sonda.getLatitude()+"&lon="+sonda.getLongitude()+"&smokeLevel="+sonda.getSmokeLevel()+"]";
		System.out.println(alarm_url);
		return alarm_url;
	}

}
