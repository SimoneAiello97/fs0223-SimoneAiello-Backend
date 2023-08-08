package com.epicode.Spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.Spring.security.entity.Device;
import com.epicode.Spring.security.entity.User;
import com.epicode.Spring.security.entity.enums.DeviceType;
import com.epicode.Spring.security.service.DeviceService;
import com.epicode.Spring.security.service.UserService;


@RestController
@RequestMapping("/api")
public class DeviceController {

	@Autowired DeviceService deviceSvc;
	@Autowired UserService userSvc;
	
	//Tutti i metodi GET che chiunque autenticato puó fare
	
	@GetMapping("/devices")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Page<Device>> getAllDevices(Pageable pageable) {
		Page<Device> list = deviceSvc.getDevicesPagination(pageable);
		ResponseEntity<Page<Device>> resp = new ResponseEntity<Page<Device>>(list, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/users")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Page<User>> getAllUsers(Pageable pageable) {
		Page<User> ls = userSvc.getUsersPagination(pageable);
		ResponseEntity<Page<User>> resp = new ResponseEntity<Page<User>>(ls, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/devices/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getDeviceById(@PathVariable Long id) {
		Device device = deviceSvc.getById(id);
		ResponseEntity<Device> resp = new ResponseEntity<Device>(device, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/users/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getUserById(@PathVariable Long id) {
		User user = userSvc.getById(id);
		ResponseEntity<User> resp = new ResponseEntity<User>(user, HttpStatus.OK);
		return resp;
	}
	
	//Tutti i metodi DELETE che solo l'admin puó fare
	
	@DeleteMapping("/user/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> deleteUser(@PathVariable Long id) {
		User user = userSvc.getById(id);
		userSvc.deleteById(id);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/device/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Device> deleteDevice(@PathVariable Long id) {
		Device device = deviceSvc.getById(id);
		deviceSvc.deleteById(id);
		return ResponseEntity.ok(device);
	}
	
	//Tutti metodi POST e PUT che solo l'admin e i moderatori possono fare
	
	@PostMapping("/devices/new")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> addDevice(@RequestBody DeviceType tipo) {
		Device d = deviceSvc.addDevice(tipo);
		ResponseEntity<Device> resp = new ResponseEntity<Device>(d, HttpStatus.CREATED);
		return resp;
	}
	
	@PutMapping("/devices/smartphone/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> assignSmartphone(@PathVariable Long id) {
		Device device = deviceSvc.assignDevice(id, DeviceType.SMARTPHONE);
		return new ResponseEntity<Device>(device, HttpStatus.OK);
	}
	
	@PutMapping("/devices/tablet/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> assignTablet(@PathVariable Long id) {
		Device device = deviceSvc.assignDevice(id, DeviceType.TABLET);
		return new ResponseEntity<Device>(device, HttpStatus.OK);
	}

	@PutMapping("/devices/laptop/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> assignLaptop(@PathVariable Long id) {
		Device device = deviceSvc.assignDevice(id, DeviceType.LAPTOP);
		return new ResponseEntity<Device>(device, HttpStatus.OK);
	}
	
	@PutMapping("/devices/dismesso/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> disuseDevice(@PathVariable Long id) {
		Device device = deviceSvc.disuseDevice(id);
		return new ResponseEntity<Device>(device, HttpStatus.OK);
	}
	
	@PutMapping("/devices/manutenzione/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> toggleDevice(@PathVariable Long id) {
		Device device = deviceSvc.toggleManutenzione(id);
		return new ResponseEntity<Device>(device, HttpStatus.OK);
	}
	
}
