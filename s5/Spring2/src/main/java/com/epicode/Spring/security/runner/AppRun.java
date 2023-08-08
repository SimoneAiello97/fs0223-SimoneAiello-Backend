package com.epicode.Spring.security.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.Spring.security.entity.enums.DeviceType;
import com.epicode.Spring.security.service.DeviceService;

@Component
public class AppRun implements CommandLineRunner {
	@Autowired DeviceService deviceSvc;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello world!");
		
		//Provato tutti i vari metodi su PostMan, sia le assegnazioni, sia il mettere in disuso/ manutenzione i vari device
		
		//deviceSvc.addDevice(DeviceType.SMARTPHONE);
		//deviceSvc.addDevice(DeviceType.TABLET);
		//deviceSvc.addDevice(DeviceType.LAPTOP);
		//deviceSvc.addDevice(DeviceType.SMARTPHONE);
		//deviceSvc.addDevice(DeviceType.TABLET);
		//deviceSvc.addDevice(DeviceType.LAPTOP);
		//deviceSvc.addDevice(DeviceType.SMARTPHONE);
		//deviceSvc.addDevice(DeviceType.TABLET);
		//deviceSvc.addDevice(DeviceType.LAPTOP);
		
		//deviceSvc.assignDevice(1, DeviceType.SMARTPHONE);
		
	}

}
