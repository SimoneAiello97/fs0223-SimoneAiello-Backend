package com.epicode.Spring.security.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.epicode.Spring.security.entity.Device;
import com.epicode.Spring.security.entity.Laptop;
import com.epicode.Spring.security.entity.Smartphone;
import com.epicode.Spring.security.entity.Tablet;
import com.epicode.Spring.security.entity.User;
import com.epicode.Spring.security.entity.enums.DeviceStatus;
import com.epicode.Spring.security.entity.enums.DeviceType;
import com.epicode.Spring.security.exception.MyAPIException;
import com.epicode.Spring.security.repository.IDevicePaginationRepository;
import com.epicode.Spring.security.repository.IDeviceRepository;

@Service
public class DeviceService {
	@Autowired IDeviceRepository repo;
	@Autowired IDevicePaginationRepository pageRepo;
	@Autowired UserService userSvc;
	
	@Autowired @Qualifier("smartphoneBean") private ObjectProvider<Smartphone> smartphoneProvider;
	@Autowired @Qualifier("tabletBean") private ObjectProvider<Tablet> tabletProvider;
	@Autowired @Qualifier("laptopBean") private ObjectProvider<Laptop> laptopProvider;
	
	public Device addDevice(DeviceType tipo) {
		switch(tipo) {
		case SMARTPHONE:
			Smartphone smartphone = smartphoneProvider.getObject();
			repo.save(smartphone);
			System.out.println("Smartphone creato e salvato nel DB:" + "ID Smartphone" + smartphone.getId());
			return smartphone;
		case TABLET:
			Tablet tablet = tabletProvider.getObject();
			repo.save(tablet);
			System.out.println("Tablet creato e salvato nel DB:" + "ID Tablet" + tablet.getId());
			return tablet;
		case LAPTOP:
			Laptop laptop = laptopProvider.getObject();
			repo.save(laptop);
			System.out.println("Laptop creato e salvato nel DB:" + "ID Laptop" + laptop.getId());
			return laptop;
		default:
			return null;
		}
	}
	
	public Device getById(Long id) {
		if (repo.existsById(id)) {
			return repo.findById(id).get();			
		}
		else {
			throw new MyAPIException(HttpStatus.BAD_REQUEST, "Device non trovato!");			
		}
	}
	
	public Page<Device> getDevicesPagination(Pageable page) {
		return pageRepo.findAll(page);
	}
	
	public void deleteById(Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);			
		}
		else {
			throw new MyAPIException(HttpStatus.BAD_REQUEST, "Cancellazione errata, Device non trovato!");			
		}
	}
	
	public Device assignDevice(long id, DeviceType tipo) {
		User u = userSvc.getById(id);
		List<Device> lista = repo.findByTipoAndStato(tipo, DeviceStatus.DISPONIBILE);
		if(lista.isEmpty()) {
			throw new MyAPIException(HttpStatus.BAD_REQUEST, "Nessun dispositivo disponibile di questo tipo!");
		}else {
			Device d = lista.get(0);
			d.setUser(u);
			d.setStato(DeviceStatus.ASSEGNATO);
			repo.save(d);
			System.out.println("Assegnazione effettuata: /nDevice " + d.getTipo()+ " assegnato a " + u.getName());
			return d;
		}
	}
	
	public Device disuseDevice(long id) {
	    Device device = getById(id);

	    if (!device.getStato().equals(DeviceStatus.DISMESSO)) {
	    	device.setStato(DeviceStatus.DISMESSO);
	        device.setUser(null);
	        repo.save(device);
	        System.out.println("Il device `" + device.getTipo() + "` con id: " + device.getId() + " é stato dismesso");
	        return device;
	    } else {
	    	throw new MyAPIException(HttpStatus.BAD_REQUEST, "Il device `" + device.getTipo() + "` con id: " + device.getId() + " é giá dismesso");
	    }

	}
	
	public Device toggleManutenzione(long id) {
		Device device = getById(id);
		if(device.getStato().equals(DeviceStatus.ASSEGNATO) || device.getStato().equals(DeviceStatus.DISPONIBILE)) {
			device.setStato(DeviceStatus.MANUTENZIONE);
			device.setUser(null);
			repo.save(device);
			System.out.println("Il device é in manutenzione");
			return device;
			
		}else if(device.getStato().equals(DeviceStatus.MANUTENZIONE)) {
			device.setStato(DeviceStatus.DISPONIBILE);
			repo.save(device);
			System.out.println("Il device é tornato disponibile");
			return device;
			
		}else {
			System.out.println("Il device é dismesso e non piú utilizzabile");
			return null;
		}
	}
}
