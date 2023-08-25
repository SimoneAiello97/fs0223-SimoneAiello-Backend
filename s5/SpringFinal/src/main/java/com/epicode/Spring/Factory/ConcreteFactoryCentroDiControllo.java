package com.epicode.Spring.Factory;

import com.epicode.Spring.Factory.entities.CentroDiControllo;

public class ConcreteFactoryCentroDiControllo implements IAbstractFactoryCentroDiControllo{

	@Override
	public CentroDiControllo createCentroDiControllo() {
		return new CentroDiControllo();
	}

}
