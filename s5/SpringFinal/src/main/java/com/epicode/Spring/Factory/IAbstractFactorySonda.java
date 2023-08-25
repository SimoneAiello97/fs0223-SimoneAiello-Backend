package com.epicode.Spring.Factory;

import com.epicode.Spring.Factory.entities.Sonda;

public interface IAbstractFactorySonda {
	Sonda createSonda(long id, double latitude, double longitude);
}
