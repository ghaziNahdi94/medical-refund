package com.cynapsys.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.cynapsys.entities.Admin;
import com.cynapsys.repositories.AdminRepository;

@Component
public class InitAdmin {

	private final String EMAIL_CYNAPSYS = "cynapsys";
	private final String PASSWORD_CYNAPSYS = "cynapsys";
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	
	@Autowired 
	AdminRepository ar;
	
	@EventListener(ApplicationReadyEvent.class)
	public void init() {
		
		if(ar.findByEmail(EMAIL_CYNAPSYS) == null) {
			
			Admin a = new Admin();
			a.setPrenom("Admin");
			a.setNom("");
			a.setEmail(EMAIL_CYNAPSYS);
			a.setPassword(passwordEncoder.encode(PASSWORD_CYNAPSYS));
			
			ar.save(a);
			
			System.out.println("Admin cynapsys crée avec succés-----------------");
		}
		
	}
	
	
	
}
