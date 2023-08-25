package com.epicode.Spring.Factory;

import com.epicode.Spring.Factory.entities.Sonda;

public class ConcreteFactorySonda implements IAbstractFactorySonda{

	@Override
	public Sonda createSonda(long id, double latitude, double longitude) {
		Sonda sonda = new Sonda();
		sonda.setId(id);
		sonda.setLatitude(latitude);
		sonda.setLongitude(longitude);
		return sonda;
	}

}
