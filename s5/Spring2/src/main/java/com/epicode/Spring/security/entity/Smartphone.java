package com.epicode.Spring.security.entity;

import com.epicode.Spring.security.entity.enums.DeviceStatus;
import com.epicode.Spring.security.entity.enums.DeviceType;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("smartphone")
public class Smartphone extends Device{
	public Smartphone() {
		this.setStato( DeviceStatus.DISPONIBILE);
		this.setTipo(DeviceType.SMARTPHONE);
	}
}
