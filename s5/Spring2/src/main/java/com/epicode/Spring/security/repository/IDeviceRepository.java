package com.epicode.Spring.security.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epicode.Spring.security.entity.Device;
import com.epicode.Spring.security.entity.enums.DeviceStatus;
import com.epicode.Spring.security.entity.enums.DeviceType;

public interface IDeviceRepository extends CrudRepository<Device, Long>{
	public List<Device> findByTipo(DeviceType tipo);
	public List<Device> findByStato(DeviceStatus stato);
	public List<Device> findByTipoAndStato(DeviceType tipo, DeviceStatus stato);
}
