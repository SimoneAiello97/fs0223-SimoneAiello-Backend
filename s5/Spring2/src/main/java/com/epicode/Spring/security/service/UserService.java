package com.epicode.Spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.epicode.Spring.security.entity.User;
import com.epicode.Spring.security.exception.MyAPIException;
import com.epicode.Spring.security.repository.IUserPaginationRepository;
import com.epicode.Spring.security.repository.IUserRepository;

@Service
public class UserService {

	@Autowired IUserRepository repo;
	@Autowired IUserPaginationRepository pageRepo;
	
	public User getById(Long id) {
		if (repo.existsById(id)) {
			return repo.findById(id).get();			
		}
		else {
			throw new MyAPIException(HttpStatus.BAD_REQUEST, "Utente non trovato!");			
		}
	}
	
	public Page<User> getUsersPagination(Pageable page) {
		return pageRepo.findAll(page);
	}
	
	public void deleteById(Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);			
		}
		else {
			throw new MyAPIException(HttpStatus.BAD_REQUEST, "Cancellazione errata, Utente non trovato!");			
		}
	}
}
